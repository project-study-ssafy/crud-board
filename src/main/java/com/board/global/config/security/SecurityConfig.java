package com.board.global.config.security;


import com.board.global.config.security.handler.CustomAccessDeniedHandler;
import com.board.global.config.security.handler.CustomAuthenticationEntryPointHandler;
import com.board.global.config.security.handler.CustomLoginFailHandler;
import com.board.global.config.security.handler.CustomLoginSuccessHandler;
import com.board.global.config.security.handler.CustomLogoutSuccessHandler;
import com.board.global.config.security.provider.CustomAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    private final CustomLoginSuccessHandler customLoginSuccessHandler;

    private final CustomLoginFailHandler customLoginFailHandler;

    private final CustomLogoutSuccessHandler customLogoutSuccessHandler;

    private final CustomAuthenticationEntryPointHandler customAuthenticationEntryPointHandler;

    private final CustomAccessDeniedHandler customAccessDeniedHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
        HandlerMappingIntrospector introspector) throws Exception {

        MvcRequestMatcher.Builder mvc = new MvcRequestMatcher.Builder(introspector);

        MvcRequestMatcher[] permitAllWhiteList = {
            mvc.pattern("/"),
            mvc.pattern("/login"),
            mvc.pattern("/sign-up"),
            mvc.pattern("/WEB-INF/views/**"),
        };

        http.authorizeHttpRequests(auto -> auto
            .requestMatchers(permitAllWhiteList).permitAll()
            .anyRequest().authenticated()
        );

        http.formLogin(login -> login
            .loginProcessingUrl("/login")
            .usernameParameter("loginId")
            .failureUrl("/login?error=true") // 로그인 실패 시 이동할 URL
            .defaultSuccessUrl("/")
            .successHandler(customLoginSuccessHandler)
            .failureHandler(customLoginFailHandler)
        );

        http.logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessHandler(customLogoutSuccessHandler)
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .permitAll()
        );

        http.csrf(AbstractHttpConfigurer::disable);

        http.sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        );

        http.exceptionHandling(conf -> conf
            .authenticationEntryPoint(customAuthenticationEntryPointHandler)
            .accessDeniedHandler(customAccessDeniedHandler)
        );

        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(
        AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider( userDetailsService, bCryptPasswordEncoder());
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        CustomAuthenticationProvider authProvider = customAuthenticationProvider();
        return new ProviderManager(authProvider);
    }
}

package com.board.service;

import com.board.domain.User;
import com.board.dto.user.SignUpDto;
import com.board.global.exception.user.DuplicatedLoginIdException;
import com.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public User signUpProcess(SignUpDto user) {

        String loginId = user.getLoginId();
        String password = user.getPassword();
        String nickname =  user.getNickname();

        boolean exists = userRepository.existsByLoginId(loginId);

        if (exists) {
            throw new DuplicatedLoginIdException("중복된 사용자입니다.");
        }
        User signUpuser = new User(loginId, password, nickname);
        return userRepository.save(signUpuser);
    }

}

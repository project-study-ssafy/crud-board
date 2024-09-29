package com.board.service;

import com.board.domain.User;
import com.board.dto.user.SignUpDto;
import com.board.dto.user.UserUpdateDto;
import com.board.global.exception.user.DuplicatedLoginIdException;
import com.board.global.exception.user.DuplicatedNicknameException;
import com.board.global.exception.user.UserNotFoundException;
import com.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public User signUpProcess(SignUpDto user) {

        String loginId = user.getLoginId();
        String nickname =  user.getNickname();

        if (userRepository.existsByLoginId(loginId)) {
            throw new DuplicatedLoginIdException("중복된 사용자입니다.");
        }

        if (userRepository.existsByNickname(nickname)) {
            throw new DuplicatedNicknameException("중복된 닉네임입니다.");
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());

        User signUpuser = new User(loginId, encodedPassword, nickname);
        return userRepository.save(signUpuser);
    }

    public User updateProcess(int id, UserUpdateDto userUpdateDto) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            throw new UserNotFoundException();
        }

        User findUser = userRepository.findByNickname(userUpdateDto.getNickname());

        if (findUser != null && findUser.getId() != id) {
            throw new DuplicatedNicknameException();
        }

        user.update(userUpdateDto.getNickname(), userUpdateDto.getPassword());
        return user;
    }

    public void withdraw(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException();
        }
        userRepository.delete(user);
    }
}

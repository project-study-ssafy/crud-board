package com.board.repository;

import com.board.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByLoginId(String loginId);
    boolean existsByNickname(String nickname);

    User findByLoginId(String loginId);
    User findByNickname(String nickname);
}

package com.board.repository;

import com.board.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByLoginId(String loginId);
    boolean existsByNickname(String nickname);

    User findByNickname(String nickname);
}

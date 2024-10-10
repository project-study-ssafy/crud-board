package com.board.repository;

import com.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    @Query("SELECT b FROM Board b WHERE b.title LIKE %:keyword% OR b.user.nickname LIKE %:keyword%")
    Page<Board> findByTitleOrUserNickname(@Param("keyword") String keyword, Pageable pageable);
}

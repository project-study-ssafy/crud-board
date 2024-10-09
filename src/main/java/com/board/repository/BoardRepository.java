package com.board.repository;

import com.board.domain.Board;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Integer> {
  @Query("SELECT a FROM Board a ORDER BY 1 asc")
  List<Board> findAllOrderByCreatedDateAsc();
}

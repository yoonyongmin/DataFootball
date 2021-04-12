package com.yoon.df.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yoon.df.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
	
//	Page<Position> findAll(Pageable pageable);
//	
//	@Query(
//			value = "SELECT p FROM Position p WHERE p.title LIKE %:title% OR p.content LIKE %:content%",
//			countQuery = "SELECT COUNT(p.id) FROM Position p WHERE p.title LIKE %:title% OR p.content LIKE %:content%"
//	)
//	Page<Position> findAllSearch(String title, String content, Pageable pageable);
	
}

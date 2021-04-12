package com.yoon.df.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yoon.df.model.Stat;

@Repository
public interface StatRepository extends JpaRepository<Stat, Integer> {
	
//	@Query("SELECT stat FROM Stat stat WHERE goal=(SELECT max(goal) from stat")
//	List<Stat> findByGoal(@Param("goal") int goal);
	
//	@Query("SELECT s FROM Stat AS s WHERE s.goal > 10")
//	Collection<Stat> findByUser();

//	테이블 정렬 할 때 사용하면 될 듯!
//	@Query("SELECT s FROM Stat AS s ORDER BY s.goal DESC")
//	Collection<Stat> findByUser();
	
}
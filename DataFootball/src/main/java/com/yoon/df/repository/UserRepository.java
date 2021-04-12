package com.yoon.df.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yoon.df.model.Stat;
import com.yoon.df.model.User;
import com.yoon.df.model.UserDto;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	Collection<User> findTop1ByOrderByStatGoalDesc();	
	Collection<User> findTop1ByOrderByStatAssistDesc();	
	Collection<User> findTop1ByOrderByStatTackleDesc();

	
	@Query("SELECT u FROM User u ORDER BY u.position.id")
	Collection<User> findByPosition();
//	
//	@Query("SELECT u FROM User u ORDER BY u.stat.goal DESC")
//	Collection<User> findByGoal();
//	
//	@Query("SELECT u FROM User u ORDER BY u.stat.shoot DESC")
//	Collection<User> findByShoot();
//	
//	@Query("SELECT u FROM User u ORDER BY u.stat.assist DESC")
//	Collection<User> findByAssist();
//	
//	@Query("SELECT u FROM User u ORDER BY u.stat.pass DESC")
//	Collection<User> findByPass();
//	
//	@Query("SELECT u FROM User u ORDER BY u.stat.tackle DESC")
//	Collection<User> findByTackle();
//	
//	@Query("SELECT u FROM User u ORDER BY u.stat.intercept DESC")
//	Collection<User> findByIntercept();

	
//	List<User> findAllById(int id, Pageable pageable);
	
	

}

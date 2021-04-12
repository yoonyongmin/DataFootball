package com.yoon.df.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yoon.df.model.UserDto;

@Repository
public interface UserDtoRepository extends JpaRepository<UserDto, Integer> {

//	@Query("SELECT u FROM UserDto u ORDER BY u.position.id")
//	Page<UserDto> findAll(Pageable pageable);
//	
//	@Query("SELECT u FROM UserDto u ORDER BY u.stat.goal DESC")
//	Page<UserDto> findByGoal(Pageable pageable);
//	
//	@Query("SELECT u FROM UserDto u ORDER BY u.stat.shoot DESC")
//	Page<UserDto> findByShoot(Pageable pageable);
//	
//	@Query("SELECT u FROM UserDto u ORDER BY u.stat.assist DESC")
//	Page<UserDto> findByAssist(Pageable pageable);
//	
//	@Query("SELECT u FROM UserDto u ORDER BY u.stat.pass DESC")
//	Page<UserDto> findByPass(Pageable pageable);
//	
//	@Query("SELECT u FROM UserDto u ORDER BY u.stat.tackle DESC")
//	Page<UserDto> findByTackle(Pageable pageable);
//	
//	@Query("SELECT u FROM UserDto u ORDER BY u.stat.intercept DESC")
//	Page<UserDto> findByIntercept(Pageable pageable);
	
	
	@Query(value = "select * from user left join stat on user.id = stat.user_id "
			+ "left join position on position_id = position.id "
			+ "where user.name like concat('%',:searchKeyword,'%')"
			+ " or position.name like concat('%',:searchKeyword,'%')"
			+ " order by user.name asc, user.position_id desc", nativeQuery=true)
	Page<UserDto> findBySearchName(String searchKeyword, Pageable pageable);
}

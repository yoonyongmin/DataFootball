package com.yoon.df.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yoon.df.model.Stat;
import com.yoon.df.model.User;
import com.yoon.df.model.UserDto;
import com.yoon.df.repository.UserDtoRepository;
import com.yoon.df.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDtoRepository userDtoRepository;
	
	public java.util.List<User> findAll() {
		List<User> list = userRepository.findAll();
		return list;
	}
	
	public Optional<User> findById(int id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	@Transactional
	public User save(User user) {
		userRepository.save(user);
		return user;
	}
	
	@Transactional(readOnly = true)
	public Page<UserDto> findAll(Pageable pageable) {
		return userDtoRepository.findAll(pageable);
	}

}

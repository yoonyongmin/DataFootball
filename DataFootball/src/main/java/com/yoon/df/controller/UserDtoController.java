package com.yoon.df.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoon.df.model.UserDto;
import com.yoon.df.repository.UserDtoRepository;
import com.yoon.df.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserDtoController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDtoRepository userDtoRepository;
	
	@GetMapping(value = "/api/search")
	public HashMap<String, Object> findBySearchKeyword(@RequestParam(name = "searchKeyword") String searchKeyword,
											@RequestParam(name = "page") String currentPage) {
		Pageable pageable = PageRequest.of(Integer.parseInt(currentPage), 5);
		
		Page<UserDto> user = userDtoRepository.findBySearchName(searchKeyword, pageable);
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("totalPage", user.getTotalPages());
		map.put("searchKeyword", user.getContent());
		
		return map;
	}
	
	
	@PostMapping(value = "/api/paging")
	public HashMap<String, Object> getUsers(@RequestParam("page") int currentPage) {
		
		Pageable pageable = PageRequest.of(currentPage, 5, Sort.by("name").ascending());
		
		Page<UserDto> user	= userService.findAll(pageable);
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("totalPage", user.getTotalPages());
		map.put("totalCount", user.getNumberOfElements());
		map.put("list", user.getContent());
		
		return map;
	}
	
	@PostMapping(value = "/api/topPosition")
	public HashMap<String, Object> getPosition(@RequestParam("page") int currentPage) {
		
		Pageable pageable = PageRequest.of(currentPage, 5, Sort.by("position.id").descending());
		
		Page<UserDto> user	= userService.findAll(pageable);
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("totalPage", user.getTotalPages());
		map.put("list", user.getContent());
		
		return map;
	}
	
	@PostMapping(value = "/api/topGoal")
	public HashMap<String, Object> getGoal(@RequestParam("page") int currentPage) {
		
		Pageable pageable = PageRequest.of(currentPage, 5, Sort.by("stat.goal").descending());
		
		Page<UserDto> user	= userService.findAll(pageable);
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("totalPage", user.getTotalPages());
		map.put("list", user.getContent());
		
		return map;
	}
	
	@PostMapping(value = "/api/topShoot")
	public HashMap<String, Object> getShoot(@RequestParam("page") int currentPage) {
		
		Pageable pageable = PageRequest.of(currentPage, 5, Sort.by("stat.shoot").descending());
		
		Page<UserDto> user	= userService.findAll(pageable);
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("totalPage", user.getTotalPages());
		map.put("list", user.getContent());
		
		return map;
	}

	@PostMapping(value = "/api/topAssist")
	public HashMap<String, Object> getAssist(@RequestParam("page") int currentPage) {
		
		Pageable pageable = PageRequest.of(currentPage, 5, Sort.by("stat.assist").descending());
		
		Page<UserDto> user	= userService.findAll(pageable);
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("totalPage", user.getTotalPages());
		map.put("list", user.getContent());
		
		return map;
	}
	
	@PostMapping(value = "/api/topPass")
	public HashMap<String, Object> getPass(@RequestParam("page") int currentPage) {
		
		Pageable pageable = PageRequest.of(currentPage, 5, Sort.by("stat.pass").descending());
		
		Page<UserDto> user	= userService.findAll(pageable);
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("totalPage", user.getTotalPages());
		map.put("list", user.getContent());
		
		return map;
	}
	
	@PostMapping(value = "/api/topTackle")
	public HashMap<String, Object> getTackle(@RequestParam("page") int currentPage) {
		
		Pageable pageable = PageRequest.of(currentPage, 5, Sort.by("stat.tackle").descending());
		
		Page<UserDto> user	= userService.findAll(pageable);
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("totalPage", user.getTotalPages());
		map.put("list", user.getContent());
		
		return map;
	}
	
	@PostMapping(value = "/api/topIntercept")
	public HashMap<String, Object> getIntercept(@RequestParam("page") int currentPage) {
		
		Pageable pageable = PageRequest.of(currentPage, 5, Sort.by("stat.intercept").descending());
		
		Page<UserDto> user	= userService.findAll(pageable);
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("totalPage", user.getTotalPages());
		map.put("list", user.getContent());
		
		return map;
	}
	
}













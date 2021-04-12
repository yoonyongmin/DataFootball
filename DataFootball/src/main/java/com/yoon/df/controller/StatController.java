package com.yoon.df.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoon.df.model.Stat;
import com.yoon.df.model.User;
import com.yoon.df.repository.StatRepository;
import com.yoon.df.repository.UserRepository;
import com.yoon.df.service.StatService;
import com.yoon.df.service.UserService;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class StatController {
	
	@Autowired
	private StatRepository statRepositoty;
	
	@Autowired
	private StatService statService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/api/statList")
	public List<Stat> findAll() {
		List<Stat> list = statService.findAll();
		System.out.println(list);
		return list;
	}	
	
	@GetMapping(value = "/api/selectStat")
	public ResponseEntity<Stat> selectStat(@RequestParam(name = "id") int id) {
		Optional<Stat> stat = statService.findById(id);
		return new ResponseEntity<Stat>(stat.get(), HttpStatus.OK);
	}
	

	

	
	@PutMapping(value = "/api/goalUpdate")
	public void goalUpdate(@RequestParam(name = "id") int id,
							@RequestParam(name = "goal") int goal,
							@RequestParam(name = "shoot") int shoot,
							@RequestParam(name = "assist") int assist,
							@RequestParam(name = "pass") int pass,
							@RequestParam(name = "tackle") int tackle,
							@RequestParam(name = "intercept") int intercept,
							@RequestParam(name = "user_id") User user) {
		
		Stat stat = new Stat(id, goal, shoot, assist, pass, tackle, intercept, user);
		statService.updateStat(stat);
	}
	
	@PutMapping(value = "/api/shootUpdate")
	public void shootUpdate(@RequestParam(name = "id") int id,
							@RequestParam(name = "goal") int goal,
							@RequestParam(name = "shoot") int shoot,
							@RequestParam(name = "assist") int assist,
							@RequestParam(name = "pass") int pass,
							@RequestParam(name = "tackle") int tackle,
							@RequestParam(name = "intercept") int intercept,
							@RequestParam(name = "user_id") User user) {
		
		Stat stat = new Stat(id, goal, shoot, assist, pass, tackle, intercept, user);
		statService.updateStat(stat);
	}
	
	@PutMapping(value = "/api/assistUpdate")
	public void assistUpdate(@RequestParam(name = "id") int id,
							@RequestParam(name = "goal") int goal,
							@RequestParam(name = "shoot") int shoot,
							@RequestParam(name = "assist") int assist,
							@RequestParam(name = "pass") int pass,
							@RequestParam(name = "tackle") int tackle,
							@RequestParam(name = "intercept") int intercept,
							@RequestParam(name = "user_id") User user) {
		
		Stat stat = new Stat(id, goal, shoot, assist, pass, tackle, intercept, user);
		statService.updateStat(stat);
	}
	
	@PutMapping(value = "/api/passUpdate")
	public void passUpdate(@RequestParam(name = "id") int id,
							@RequestParam(name = "goal") int goal,
							@RequestParam(name = "shoot") int shoot,
							@RequestParam(name = "assist") int assist,
							@RequestParam(name = "pass") int pass,
							@RequestParam(name = "tackle") int tackle,
							@RequestParam(name = "intercept") int intercept,
							@RequestParam(name = "user_id") User user) {
		
		Stat stat = new Stat(id, goal, shoot, assist, pass, tackle, intercept, user);
		statService.updateStat(stat);
	}
	
	@PutMapping(value = "/api/tackleUpdate")
	public void tackleUpdate(@RequestParam(name = "id") int id,
							@RequestParam(name = "goal") int goal,
							@RequestParam(name = "shoot") int shoot,
							@RequestParam(name = "assist") int assist,
							@RequestParam(name = "pass") int pass,
							@RequestParam(name = "tackle") int tackle,
							@RequestParam(name = "intercept") int intercept,
							@RequestParam(name = "user_id") User user) {
		
		Stat stat = new Stat(id, goal, shoot, assist, pass, tackle, intercept, user);
		statService.updateStat(stat);
	}
	
	@PutMapping(value = "/api/interceptUpdate")
	public void interceptUpdate(@RequestParam(name = "id") int id,
							@RequestParam(name = "goal") int goal,
							@RequestParam(name = "shoot") int shoot,
							@RequestParam(name = "assist") int assist,
							@RequestParam(name = "pass") int pass,
							@RequestParam(name = "tackle") int tackle,
							@RequestParam(name = "intercept") int intercept,
							@RequestParam(name = "user_id") User user) {
		
		Stat stat = new Stat(id, goal, shoot, assist, pass, tackle, intercept, user);
		statService.updateStat(stat);
	}
		
}







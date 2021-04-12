package com.yoon.df.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yoon.df.model.UploadFile;
import com.yoon.df.model.Foot;
import com.yoon.df.model.Position;
import com.yoon.df.model.Stat;
import com.yoon.df.model.User;
import com.yoon.df.model.UserDto;
import com.yoon.df.repository.FileRepository;
import com.yoon.df.repository.FootRepository;
import com.yoon.df.repository.PositionRepository;
import com.yoon.df.repository.StatRepository;
import com.yoon.df.repository.UserDtoRepository;
import com.yoon.df.repository.UserRepository;
import com.yoon.df.service.FileService;
import com.yoon.df.service.UserService;

import io.swagger.models.Model;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileService fileService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StatRepository statRepository;
	
	@Autowired
	private PositionRepository positionRepository;
	
	@Autowired
	private FootRepository footRepository;
	
	@Autowired
	private UserDtoRepository userDtoRepository;

	
//	@GetMapping(value = "/api/userList")
//	public List<User> findAll(){
//		List<User> list = userService.findAll();
//		System.out.println(list);
//		return list;		
//	}
	
	
//	@PostMapping("/api/paging")
//	public int paging(@RequestParam(name = "page") int page,
//						@RequestParam(name = "size") int size,
//						@RequestParam(name = "sortItem") String sortItem,
//						@RequestParam(name = "sortOrder") String sortOrder) {
//		
//		Sort sort = null;
//		
//		if (sortOrder.equals("asc")) {
//			sort = Sort.by(sortItem).ascending();
//		} else {
//			sort = Sort.by(sortItem).descending();
//		}
//		
//		Pageable pageable = PageRequest.of(page, size, sort);
//		
//		Page<User> list = userService.findAll(pageable);		
//		
//		return list.getTotalPages();
//	}
//	
//	@GetMapping(value = "/api/paging")
//	List<UserDto> getUsers(@PageableDefault(size = 5) Pageable pageable) {
//		Page<UserDto> user	= userService.findAll(pageable);
//		List<UserDto> list = user.getContent();
//		return list;
//	}
//	

//
//	@GetMapping(value = "/api/paging")
//	public ResponseEntity userDto(@PageableDefault(size = 5) final Pageable pageable) {
//		Page<UserDto> userDto = userService.findAll(pageable);
//		return new ResponseEntity<>(userDto, HttpStatus.OK);
//	}
	
	
	@GetMapping(value = "/api/userList")
	public Collection<User> findAll() {
		Collection<User>list = userRepository.findByPosition();
		System.out.println(list);
		return list;
	}
	
//	@GetMapping(value = "/api/topGoal")
//	public Collection<User> findAllGoal() {
//		Collection<User>list = userRepository.findByGoal();
//		System.out.println(list);
//		return list;
//	}
//	
//	@GetMapping(value = "/api/topShoot")
//	public Collection<User> findAllShoot() {
//		Collection<User>list = userRepository.findByShoot();
//		System.out.println(list);
//		return list;
//	}
//	
//	@GetMapping(value = "/api/topAssist")
//	public Collection<User> findAllAssist() {
//		Collection<User>list = userRepository.findByAssist();
//		System.out.println(list);
//		return list;
//	}
//	
//	@GetMapping(value = "/api/topPass")
//	public Collection<User> findAllPass() {
//		Collection<User>list = userRepository.findByPass();
//		System.out.println(list);
//		return list;
//	}
//	
//	@GetMapping(value = "/api/topTackle")
//	public Collection<User> findAllTackle() {
//		Collection<User>list = userRepository.findByTackle();
//		System.out.println(list);
//		return list;
//	}
//	
//	@GetMapping(value = "/api/topIntercept")
//	public Collection<User> findAllIntercept() {
//		Collection<User>list = userRepository.findByIntercept();
//		System.out.println(list);
//		return list;
//	}
	
	
	@GetMapping(value = "/api/selectOne")
	public ResponseEntity<User> selectOne(@RequestParam(name = "id") int id) {
		Optional<User> user = userService.findById(id);
		return new ResponseEntity<User>(user.get(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/api/userInsert")
	public ResponseEntity<User> userInsert(@RequestParam(name = "id") int id, 
			@RequestParam(name = "name") String name,
			@RequestParam(name = "height") int height,
			@RequestParam(name = "weight") int weight,
			@RequestParam(name = "backNumber") int backNumber,
			@RequestParam(name = "goal") int goal,
			@RequestParam(name = "shoot") int shoot,
			@RequestParam(name = "assist") int assist,
			@RequestParam(name = "pass") int pass,
			@RequestParam(name = "tackle") int tackle,
			@RequestParam(name = "intercept") int intercept,
			@RequestParam(name = "position_id") Position position_id,
			@RequestParam(name = "foot_id") Foot foot_id,
			@RequestParam(name = "file") MultipartFile file) throws IllegalStateException, IOException {
		
		System.out.println(file.toString());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		
		String origFilename = file.getOriginalFilename();
		String fileType = origFilename.substring(origFilename.indexOf("."));
		String filename = sdf.format(new Date()) + fileType;
		String filePath = "C:/Users/new/Desktop/YM/Angular/datafooball-project/src/assets/images/" + filename;
		
		file.transferTo(new File(filePath));

		User user = new User(id, name, height, weight, backNumber, position_id, foot_id);
		userRepository.save(user);
		
		Stat stat = new Stat(goal, shoot, assist, pass, tackle, intercept, user);
		statRepository.save(stat);
		
		UploadFile uploadFile = new UploadFile(origFilename, filename, filePath, user);
		fileService.save(uploadFile);
		
		return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
	}
	
	@PutMapping(value = "/api/userUpdate")
	public void userUpdate(@RequestParam(name = "id") int id, 
							@RequestParam(name = "name") String name,
							@RequestParam(name = "height") int height,
							@RequestParam(name = "weight") int weight,
							@RequestParam(name = "backNumber") int backNumber,
							@RequestParam(name = "position_id") Position position_id,
							@RequestParam(name = "foot_id") Foot foot_id) {
		
		User user = new User(id, name, height, weight, backNumber, position_id, foot_id);
		
		userService.updateUser(user);
	}
	
	@DeleteMapping(value = "/api/userDelete")
	public void userDelete(@RequestParam(name = "id") int id) {
//		User user = userRepository.getOne(id);
//		Position position = new Position();
//		Foot foot = new Foot();
//		
//		position.getUser().remove(user);
//		foot.getUser().remove(user);
//		
//		user.setPosition(null);
//		user.setFoot(null);
		
		userService.deleteUser(id);
	}
	
	@GetMapping(value = "/api/fwMvp")
	public Collection<User> findByFw() {
		Collection<User> list = userRepository.findTop1ByOrderByStatGoalDesc();
		return list;
	}
	
	@GetMapping(value = "/api/mfMvp")
	public Collection<User> findByMf() {
		Collection<User> list = userRepository.findTop1ByOrderByStatAssistDesc();
		return list;
	}
	
	@GetMapping(value = "/api/dfMvp")
	public Collection<User> findByDf() {
		Collection<User> list = userRepository.findTop1ByOrderByStatTackleDesc();
		return list;
	}
	
	@GetMapping(value = "/api/test")
	public String test() {
		return "Test";
	}
	

}






























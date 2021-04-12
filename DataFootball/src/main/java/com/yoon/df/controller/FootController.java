package com.yoon.df.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoon.df.model.Foot;
import com.yoon.df.service.FootService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FootController {
	
	@Autowired
	private FootService footService;
	
	@GetMapping(value = "/api/footList")
	public List<Foot> findAll() {
		List<Foot> list = footService.findAll();
		System.out.println(list);
		return list;
	}

}

package com.yoon.df.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoon.df.model.Position;
import com.yoon.df.service.PositionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PositionController {
	
	@Autowired
	private PositionService positionService;
	
	@GetMapping(value = "/api/positionList")
	public List<Position> findAll() {
		List<Position> list = positionService.findAll();
		System.out.println(list);
		return list;
	}

}

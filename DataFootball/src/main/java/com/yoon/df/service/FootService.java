package com.yoon.df.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoon.df.model.Foot;
import com.yoon.df.repository.FootRepository;

@Service
public class FootService {
	
	@Autowired
	private FootRepository footRepository;
	
	public List<Foot> findAll() {
		List<Foot> list = footRepository.findAll();
		return list;
	}

}

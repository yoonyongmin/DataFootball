package com.yoon.df.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoon.df.model.Position;
import com.yoon.df.repository.PositionRepository;

@Service
public class PositionService {
	
	@Autowired
	private PositionRepository positionRepository;
	
	public List<Position> findAll() {
		List<Position> list = positionRepository.findAll();
		return list;
	}

}

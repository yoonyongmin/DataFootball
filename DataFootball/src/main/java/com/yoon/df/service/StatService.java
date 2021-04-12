package com.yoon.df.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoon.df.model.Stat;
import com.yoon.df.repository.StatRepository;

@Service
public class StatService {
	
	@Autowired
	private StatRepository statRepository;
	
	public List<Stat> findAll() {
		List<Stat> list = statRepository.findAll();
		return list;
	}
	
	public Optional<Stat> findById(int id) {
		Optional<Stat> stat = statRepository.findById(id);
		return stat;
	}
	
	public Stat save(Stat stat) {
		statRepository.save(stat);
		return stat;
	}
	
	public void updateStat(Stat stat) {
		statRepository.save(stat);
	}
	
	public void deleteStat(int id) {
		statRepository.deleteById(id);
	}
	
	
}

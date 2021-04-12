package com.yoon.df.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yoon.df.model.Foot;

@Repository
public interface FootRepository extends JpaRepository<Foot, Integer> {

}

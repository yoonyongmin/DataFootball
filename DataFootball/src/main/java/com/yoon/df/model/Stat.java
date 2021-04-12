package com.yoon.df.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Stat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int goal;
	private int shoot;
	private int assist;
	private int pass;
	private int tackle;
	private int intercept;
	
	@JsonBackReference
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	
	public Stat() {
		super();
	}
	
	public Stat(Collection<Stat> stat) {
		
	}
	
	public Stat(int id) {
		this.id = id;
	}
	
	public Stat(int id, int goal, int shoot, int assist, int pass, int tackle, int intercept, User user) {
		super();
		this.id = id;
		this.goal = goal;
		this.shoot = shoot;
		this.assist = assist;
		this.pass = pass;
		this.tackle = tackle;
		this.intercept = intercept;
		this.user = user;
	}
	
	public Stat(int goal, int shoot, int assist, int pass, int tackle, int intercept, User user) {
		super();
		this.goal = goal;
		this.shoot = shoot;
		this.assist = assist;
		this.pass = pass;
		this.tackle = tackle;
		this.intercept = intercept;
		this.user = user;
	}
	
	public Stat(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public int getShoot() {
		return shoot;
	}

	public void setShoot(int shoot) {
		this.shoot = shoot;
	}

	public int getAssist() {
		return assist;
	}

	public void setAssist(int assist) {
		this.assist = assist;
	}

	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}

	public int getTackle() {
		return tackle;
	}

	public void setTackle(int tackle) {
		this.tackle = tackle;
	}

	public int getIntercept() {
		return intercept;
	}

	public void setIntercept(int intercept) {
		this.intercept = intercept;
	}

	@Override
	public String toString() {
		return "Stat [id=" + id + ", goal=" + goal + ", shoot=" + shoot + ", assist=" + assist + ", pass=" + pass
				+ ", tackle=" + tackle + ", intercept=" + intercept + "]";
	}

}

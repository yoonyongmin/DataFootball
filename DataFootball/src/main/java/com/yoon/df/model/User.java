package com.yoon.df.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {
	
//	@OneToMany(mappedBy = "user")
//	private List<UserPosition> userPosition = new ArrayList<>();

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "foot_id")
	private Foot foot;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "position_id")
	private Position position;
	
	
	@JsonManagedReference
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private UploadFile uploadFile;
	
	@JsonManagedReference
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private Stat stat;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	protected String name;
	protected int height;
	protected int weight;
	@JoinColumn(name = "back_number")
	protected int backNumber;


	public User() {}
	
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}	
	
	public User(int id, String name, int height, int weight, int backNumber, Position position_id, Foot foot_id) {
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.backNumber = backNumber;
		this.position = position_id;
		this.foot = foot_id;
	}

	public User(int id, String name, Stat stat) {
		this.id = id;
		this.name = name;
		this.stat = stat;
	}

	public User(Foot foot, Position position, UploadFile uploadFile, Stat stat, int id, String name, int height, int weight,
			int backNumber) {
		super();
		this.foot = foot;
		this.position = position;
		this.uploadFile = uploadFile;
		this.stat = stat;
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.backNumber = backNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public int getBackNumber() {
		return backNumber;
	}

	public void setBackNumber(int backNumber) {
		this.backNumber = backNumber;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Stat getStat() {
		return stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}
	
//	public void addStat(Stat s) {
//		if(stat == null) {
//			stat = new ArrayList<Stat>();
//		}
//		stat.add(s);
//	}
		
	public UploadFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(UploadFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Foot getFoot() {
		return foot;
	}

	public void setFoot(Foot foot) {
		this.foot = foot;
	}

	@Override
	public String toString() {
		return "User [uploadFile=" + uploadFile + ", stat=" + stat + ", id=" + id + ", name=" + name + ", height="
				+ height + ", weight=" + weight + ", backNumber=" + backNumber + "]";
	}

//	@Override
//	public String toString() {
//		return "User [id=" + id + ", name=" + name + ", height=" + height + ", weight=" + weight + ", backNumber="
//				+ backNumber + "]";
//	}
	
	

	
	

//	@Override
//	public String toString() {
//		String result = "[" + id + "]" + name;
//		for(Skill s : skill) {
//			result += "\n" + s.toString();
//		}
//		return result;
//	}


}

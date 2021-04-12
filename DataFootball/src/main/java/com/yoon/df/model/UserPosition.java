//package com.yoon.df.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//
//@Entity(name = "user_position")
//public class UserPosition {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	@JsonIgnore
//	private User user;
//	
//	@ManyToOne
//	@JoinColumn(name = "position_id")
//	@JsonIgnore
//	private Position position;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Position getPosition() {
//		return position;
//	}
//
//	public void setPosition(Position position) {
//		this.position = position;
//	}
//
//}

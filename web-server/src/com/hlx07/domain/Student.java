package com.hlx07.domain;

public class Student {
	private int id;
	private String number;
	private String name;
	private String college;
	private String score;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	public Student(String number, String name, String college, String score) {
		this.number = number;
		this.name = name;
		this.college = college;
		this.score = score;
	}
	public Student(int id,String number, String name, String college, String score) {
		this.id=id;
		this.number = number;
		this.name = name;
		this.college = college;
		this.score = score;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
}

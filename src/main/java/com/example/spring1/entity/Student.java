package com.example.spring1.entity;

public class Student {
	private String name;
	private int math;
	private int kor;
	private int com;
	private int total;
	private float avg;

	public int getCom() {
		return com;
	}
	public void setCom(int com) {
		this.com = com;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	
	
}

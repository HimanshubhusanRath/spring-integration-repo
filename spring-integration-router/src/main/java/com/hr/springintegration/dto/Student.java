package com.hr.springintegration.dto;

public class Student {

	private String name;
	private String city;

	@Override
	public String toString() {
		return "User [name=" + name + ", city=" + city + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}

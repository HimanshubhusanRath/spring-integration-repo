package com.hr.springintegration.dto;

public class User {

	private String name;
	private String city;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", city=" + city + "]";
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

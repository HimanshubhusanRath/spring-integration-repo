package com.hr.springintegration.dto;

public class Teacher {

	private String name;
	private int experienceYears;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", experienceYears=" + experienceYears + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}

}

package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor_details")
public class DoctorRecords {
	@Id
	private int id;
	private String doctorName;
	private int doctorAge;
	private String joinDate;
	
	public DoctorRecords() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DoctorRecords(int id, String doctorName, int doctorAge, String joinDate) {
		super();
		this.id = id;
		this.doctorName = doctorName;
		this.doctorAge = doctorAge;
		this.joinDate = joinDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getDoctorAge() {
		return doctorAge;
	}
	public void setDoctorAge(int doctorAge) {
		this.doctorAge = doctorAge;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	
}

package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient_record")
public class Records {
	
	@Id
	private int patientId;
	private String patientName;
	private int patientAge;
	private String admittedDate;
	private String dischargeDate;
	private String diagnosis;
	@Column(name = "doctor_id", columnDefinition = "INT DEFAULT 100")
	private int doctorId = 100;
	private String doctorName;
	private long contact;
	
	public Records() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Records(int patientId, String patientName, int patientAge, String admittedDate, String dischargeDate,
			String diagnosis, int doctorId, String doctorName, long contact) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.admittedDate = admittedDate;
		this.dischargeDate = dischargeDate;
		this.diagnosis = diagnosis;
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.contact = contact;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public String getAdmittedDate() {
		return admittedDate;
	}

	public void setAdmittedDate(String admittedDate) {
		this.admittedDate = admittedDate;
	}

	public String getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}
	
}

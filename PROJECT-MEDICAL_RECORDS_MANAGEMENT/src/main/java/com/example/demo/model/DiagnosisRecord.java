package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "diagnosis_detail")
public class DiagnosisRecord {

	@Id
	private int patientId;
	private String patientName;
	private int patientAge;
	private int doctorId;
	private String doctorName;
	private String diagnosis;
	private String testResult;
	private String medicinesPrescribed;
	private String doctorNote;
	
	public DiagnosisRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DiagnosisRecord(int patientId, String patientName, int patientAge, int doctorId, String doctorName,
			String diagnosis, String testResult, String medicinesPrescribed, String doctorNote) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.diagnosis = diagnosis;
		this.testResult = testResult;
		this.medicinesPrescribed = medicinesPrescribed;
		this.doctorNote = doctorNote;
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

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public String getMedicinesPrescribed() {
		return medicinesPrescribed;
	}

	public void setMedicinesPrescribed(String medicinesPrescribed) {
		this.medicinesPrescribed = medicinesPrescribed;
	}

	public String getDoctorNote() {
		return doctorNote;
	}

	public void setDoctorNote(String doctorNote) {
		this.doctorNote = doctorNote;
	}
	
	
}

package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;

@Entity
//@Table(name = "patient_table")
public class Records {
	
//	@Column(name = "doctor_id", columnDefinition = "INT DEFAULT 100")
	@Id
	private int patientId;
	private String patientName;
	private int patientAge;
	private String admittedDate;
	private String dischargeDate;
	private String diagnosis;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_doctor")
	private DoctorRecords dr;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_medicine")
	private List<MedicineRecord> mr;

	public Records() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Records(int patientId, String patientName, int patientAge, String admittedDate, String dischargeDate,
			String diagnosis, DoctorRecords dr, List<MedicineRecord> mr) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.admittedDate = admittedDate;
		this.dischargeDate = dischargeDate;
		this.diagnosis = diagnosis;
		this.dr = dr;
		this.mr = mr;
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

	public DoctorRecords getDr() {
		return dr;
	}

	public void setDr(DoctorRecords dr) {
		this.dr = dr;
	}

	public List<MedicineRecord> getMr() {
		return mr;
	}

	public void setMr(List<MedicineRecord> mr) {
		this.mr = mr;
	}
	
	
}

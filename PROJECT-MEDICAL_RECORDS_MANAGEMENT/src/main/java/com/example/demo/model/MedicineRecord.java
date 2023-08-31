package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity
//@Table(name = "medicine_table")
public class MedicineRecord {

	@Id
	private int medId;
	private String name;
	private String dosage;
	
	public MedicineRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedicineRecord(int medId, String name, String dosage) {
		super();
		this.medId = medId;
		this.name = name;
		this.dosage = dosage;
	}

	public int getMedId() {
		return medId;
	}

	public void setMedId(int medId) {
		this.medId = medId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	
	
}

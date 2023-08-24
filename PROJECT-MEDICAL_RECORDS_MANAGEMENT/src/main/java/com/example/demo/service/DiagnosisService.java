package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DiagnosisRecord;
import com.example.demo.repository.DiagRepo;

@Service
public class DiagnosisService {

	@Autowired
	DiagRepo rep;
	
	// ADD SINGLE RECORDS
	public DiagnosisRecord addinfo(DiagnosisRecord r) {
		return rep.save(r);
	}
	
	// ADD LIST OF RECORDS
	public List<DiagnosisRecord> addDetails(List<DiagnosisRecord> sr) {
		return (List<DiagnosisRecord>)rep.saveAll(sr);
	}
	
	// DISPLAY ALL RECORDS
	public List<DiagnosisRecord> displayDetails() {
		return rep.findAll();
	}
	
	// DISPLAY REQUIRED / SELECTED RECORDS BY ID
	public Optional<DiagnosisRecord> displayDetailsById(int id) {
		return rep.findById(id);
	}

	// UPDATE DATA IN A RECORDER BY ID
	public String updateDetails(int id, DiagnosisRecord sr) {
		rep.saveAndFlush(sr);
		if(rep.existsById(id)) {
			return "Record Updated successfully.";
		}
		else {
			return "Id does not exist";
		}
	}
	
	// DELETE SELECTED RECORD
	public void deleteDetails(int id) {
		rep.deleteById(id);
	}
}

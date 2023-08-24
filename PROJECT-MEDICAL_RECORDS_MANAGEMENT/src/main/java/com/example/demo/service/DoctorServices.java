package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DoctorRecords;
import com.example.demo.repository.DoctorRepo;

@Service
public class DoctorServices {

	@Autowired
	DoctorRepo rep;
	
	// ADD SINGLE RECORDS
	public DoctorRecords addinfo(DoctorRecords r) {
		return rep.save(r);
	}
	
	// ADD LIST OF RECORDS
	public List<DoctorRecords> addDetails(List<DoctorRecords> sr) {
		return (List<DoctorRecords>)rep.saveAll(sr);
	}
	
	// DISPLAY ALL RECORDS
	public List<DoctorRecords> displayDetails() {
		return rep.findAll();
	}
	
	// DISPLAY REQUIRED / SELECTED RECORDS BY ID
	public Optional<DoctorRecords> displayDetailsById(int id) {
		return rep.findById(id);
	}

	// UPDATE DATA IN A RECORDER BY ID
	public String updateDetails(int id, DoctorRecords sr) {
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

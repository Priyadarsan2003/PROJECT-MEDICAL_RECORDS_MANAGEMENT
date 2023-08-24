package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Records;
import com.example.demo.repository.Repository;

@Service
public class Services {
	
	@Autowired
	Repository rep;
	
	// ADD SINGLE RECORDS
	public Records addinfo(Records r) {
		return rep.save(r);
	}
	
	// ADD LIST OF RECORDS
	public List<Records> addDetails(List<Records> sr) {
		return (List<Records>)rep.saveAll(sr);
	}
	
	// DISPLAY ALL RECORDS
	public List<Records> displayDetails() {
		return rep.findAll();
	}
	
	// DISPLAY REQUIRED / SELECTED RECORDS BY ID
	public Optional<Records> displayDetailsById(int id) {
		return rep.findById(id);
	}
	
//	public List<Records> displayDetailsByName(String patientName) {
//		return rep.getByName(patientName);
//	}
	
	//DIRECT UPDATE
	public Records changeinfo(Records sr) {
		return rep.saveAndFlush(sr);
	}
	
	public Records updateinfobyid(int id, String name)
	{
		Optional<Records> rec = rep.findById(id);
		Records val = null;
		if(rec.isPresent())
		{
			val = rec.get();
			val.setPatientName(name);
		}
		return rep.save(val);
	}

	// UPDATE DATA IN A RECORDER BY ID
	public String updateDetails(int id, Records sr) {
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

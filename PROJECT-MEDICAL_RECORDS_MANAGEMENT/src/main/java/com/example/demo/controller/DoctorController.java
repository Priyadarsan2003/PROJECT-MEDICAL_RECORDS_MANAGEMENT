package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DoctorRecords;
import com.example.demo.service.DoctorServices;

@RestController
public class DoctorController {

	@Autowired
	DoctorServices ser;
	
	// ADD SINGLE RECORD
	@PostMapping("addDr")
	public DoctorRecords add(@RequestBody DoctorRecords r) {
		return ser.addinfo(r);
	}
		
	// ADD LIST OF RECORD
	@PostMapping("addDrDetails")
	public List<DoctorRecords> adddetails(@RequestBody List<DoctorRecords> r) {
		return ser.addDetails(r);
	}
		
	// SHOW ALL THE RECORDS
	@GetMapping("showDrDetails")
	public List<DoctorRecords> disp() {
		return ser.displayDetails();
	}

	// SHOW SPECIFIED RECORD BY ID
	@GetMapping("showDrDetails/{id}")
	public Optional<DoctorRecords> dispById(@PathVariable int id) {
		return ser.displayDetailsById(id);
	}
		
	// UPDATE SPECIFIED RECORD BY ID
	@PutMapping("updateDrDetails/{id}")
	public String updateById(@PathVariable int id, @RequestBody DoctorRecords ss) {
		return ser.updateDetails(id, ss);
	}
		
	//DELETE SPECIFIED RECORD BY ID
	@DeleteMapping("deleteDrDetails/{id}")
	public String deleteById(@PathVariable int id) {
		ser.deleteDetails(id);
		return " Record Deleted successfully";
	}
	
}

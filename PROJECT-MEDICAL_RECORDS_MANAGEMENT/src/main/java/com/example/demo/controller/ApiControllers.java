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

import com.example.demo.model.Records;
import com.example.demo.service.Services;

@RestController
public class ApiControllers {

	@Autowired
	Services ser;
	
	// ADD SINGLE RECORD
	@PostMapping("add")
	public Records add(@RequestBody Records r) {
		return ser.addinfo(r);
	}
	
	// ADD LIST OF RECORD
	@PostMapping("addDetails")
	public List<Records> adddetails(@RequestBody List<Records> r) {
		return ser.addDetails(r);
	}
	
	// SHOW ALL THE RECORDS
	@GetMapping("showDetails")
	public List<Records> disp() {
		return ser.displayDetails();
	}

	// SHOW SPECIFIED RECORD BY ID
	@GetMapping("showDetails/{id}")
	public Optional<Records> dispById(@PathVariable int id) {
		return ser.displayDetailsById(id);
	}
	
//	@GetMapping("showDetailsByName/{patientName}")
//	public List<Records> dispByName(@PathVariable String patientName) {
//		return ser.displayDetailsByName(patientName);
//	}
	
	// DIRECT UPDATE
	@PutMapping("updateDetails")
	public Records modify(@RequestBody Records r) {
		return ser.changeinfo(r);
	}
	
//	@PutMapping("updatedetailbyid")
//	public Records update(@RequestParam int id ,String patientName)
//	{
//		return ser.updateinfobyid(id,patientName);
//	}
	
	// UPDATE SPECIFIED RECORD BY ID
	@PutMapping("updateDetails/{id}")
	public String updateById(@PathVariable int id, @RequestBody Records ss) {
		return ser.updateDetails(id, ss);
	}
	
	//DELETE SPECIFIED RECORD BY ID
	@DeleteMapping("deleteDetails/{id}")
	public String deleteById(@PathVariable int id) {
		ser.deleteDetails(id);
		return " Record Deleted successfully";
	}
	
	
}

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

import com.example.demo.model.DiagnosisRecord;
import com.example.demo.service.DiagnosisService;

@RestController
public class DiagController {

	@Autowired
	DiagnosisService ser;
	
	// ADD SINGLE RECORD
	@PostMapping("addDiag")
	public DiagnosisRecord add(@RequestBody DiagnosisRecord r) {
		return ser.addinfo(r);
	}
	
	// ADD LIST OF RECORD
	@PostMapping("addDiagDetails")
	public List<DiagnosisRecord> adddetails(@RequestBody List<DiagnosisRecord> r) {
		return ser.addDetails(r);
	}
	
	// SHOW ALL THE RECORDS
	@GetMapping("showDiagDetails")
	public List<DiagnosisRecord> disp() {
		return ser.displayDetails();
	}

	// SHOW SPECIFIED RECORD BY ID
	@GetMapping("showDiagDetails/{id}")
	public Optional<DiagnosisRecord> dispById(@PathVariable int id) {
		return ser.displayDetailsById(id);
	}
	
	// UPDATE SPECIFIED RECORD BY ID
	@PutMapping("updateDiagDetails/{id}")
	public String updateById(@PathVariable int id, @RequestBody DiagnosisRecord ss) {
		return ser.updateDetails(id, ss);
	}
	
	//DELETE SPECIFIED RECORD BY ID
	@DeleteMapping("deleteDiagDetails/{id}")
	public String deleteById(@PathVariable int id) {
		ser.deleteDetails(id);
		return " Record Deleted successfully";
	}
	
}

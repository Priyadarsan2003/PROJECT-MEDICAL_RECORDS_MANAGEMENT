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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Records;
import com.example.demo.service.Services;

@RestController
public class ApiControllers {

	@Autowired
	Services ser;
	
//	@Autowired
//	private Repository rep;
	
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
	
	@PutMapping("updatedetailbyid")
	public Records update(@RequestParam int id, String patientName)
	{
		return ser.updateinfobyid(id, patientName);
	}
	
	// UPDATE SPECIFIED RECORD BY ID
	@PutMapping("updateDetails/{id}")
	public String updateById(@PathVariable int id, @RequestBody Records ss) {
		return ser.update(id, ss);
	}
	
//	@PutMapping("updatedetailbyid")
//	public Records update(@RequestParam int id, Records ss)
//	{
//		return ser.updatebyid(id, ss);
//	}
	
	// SORT THE RECORDS
		@GetMapping("sort/{name}")
		public List<Records> getSortInfo(@PathVariable String s) {
			return ser.sortinfo(s);
		}
		
		// PAGINATION
		@GetMapping("paging/{pageno}/{pagesize}")
		public List<Records> shoepageinfo(@PathVariable int pageno, @PathVariable int pagesize) {
			return ser.getByPage(pageno, pagesize);
		}
	
	//DELETE SPECIFIED RECORD BY ID
	@DeleteMapping("deleteDetails/{id}")
	public String deleteById(@PathVariable int id) {
		ser.delete(id);
		return " Record Deleted successfully";
	}
	
	@GetMapping("paging/{pageno}/{pagesize}/{s}")
	public List<Records> shoepage(@PathVariable int pageno, @PathVariable int pagesize, @PathVariable String s) {
		return ser.pagingDetails(pageno, pagesize, s);
	}
	
	// QUERY
	@GetMapping("query/get/{id}")
	public Records getdetails(@PathVariable int id)
	{
		return ser.getDetails(id);
	}
	@PutMapping("query/update/{id}/{newid}")
	public String updatedetails(@PathVariable int id, @PathVariable int newid)
	{
		ser.updateDetails(id, newid);
		return "Updated";
	}
	@DeleteMapping("query/delete/{id}")
	public String deletedetails(@PathVariable  int id)
	{
		ser.deleteDetails(id);
		return "Deleted "+id;
	}
	@GetMapping("query/get/class/{name}")
	public List<Records> getclassdetails(@PathVariable String name)
	{
		return ser.getClassDetails(name);
	}
	
//	@PostMapping("/mapping")
//	public String save(@RequestBody Records r) {
//		rep.save(r);
//		return "Data saved";
//	}
//	
//	@GetMapping("/show") 
//	public List<Records> get() {
//		return rep.findAll();
//	}
}

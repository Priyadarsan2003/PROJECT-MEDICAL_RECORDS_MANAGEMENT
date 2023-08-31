package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	
	public Records updateinfobyid(int id, String patientName)
	{
		Optional<Records> rec = rep.findById(id);
		Records val = null;
		if(rec.isPresent())
		{
			val = rec.get();
			val.setPatientName(patientName);
		}
		return rep.save(val);
	}
	
//	public Records updatebyid(int id, Records ss)
//	{
//		Optional<Records> rec = rep.findById(id);
//		Records val = null;
//		if(rec.isPresent())
//		{
//			val = rec.get();
//			val.setPatientId(id);
//			rep.saveAndFlush(ss);
//		}
//		return rep.save(val);
//	}

	// UPDATE DATA IN A RECORDER BY ID
	public String update(int id, Records sr) {
//		rep.saveAndFlush(sr);
		if(rep.existsById(id)) {
			return "Record Updated successfully.";
		}
		else {
			return "Id does not exist";
		}
	}
	
	// DELETE SELECTED RECORD
	public void delete(int id) {
		rep.deleteById(id);
	}
	
	// PAGINATION 
	public List<Records> getByPage(int pgno, int pgsize) {
		Page<Records> p = rep.findAll(PageRequest.of(pgno, pgsize));
		return p.getContent();
	}
	
	// SORT ASCENDING 
	public List<Records> sortinfo(String s) {
		return rep.findAll(Sort.by(Sort.DEFAULT_DIRECTION));
	}
	
	// SORT DESCENDING
	public List<Records> sortinfodesc(String s) {
		return rep.findAll(Sort.by(Sort.DEFAULT_DIRECTION, s));
	}
	
	// PAGINATION BY FIELD
	public List<Records> paging(int pgno, int pgsize, String s) {
		Sort st = Sort.by(s);
		Page<Records> p = rep.findAll(PageRequest.of(pgno, pgsize, st));
		return p.getContent();
	}
	
	public List<Records> pagingDetails(int pgno, int pgsize, String s) {
		Sort st = Sort.by(s);
		Page<Records> p = rep.findAll(PageRequest.of(pgno, pgsize, st));
		return p.getContent();
	}
	
	// QUERY
	public Records getDetails(int id)
	{
		return rep.getInfo(id);
	}
	
	public Records updateDetails(int id, int newid) {
		return rep.updateInfo(id, newid);
		
	}
	public Records deleteDetails(int id)
	{
		return rep.deleteInfo(id);
		
	}
	public List<Records> getClassDetails(String name)
	{
		return rep.getInfoClass(name);
	}
}

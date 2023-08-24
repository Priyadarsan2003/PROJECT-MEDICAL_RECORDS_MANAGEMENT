package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DoctorRecords;

public interface DoctorRepo extends JpaRepository<DoctorRecords, Integer>{
	
}

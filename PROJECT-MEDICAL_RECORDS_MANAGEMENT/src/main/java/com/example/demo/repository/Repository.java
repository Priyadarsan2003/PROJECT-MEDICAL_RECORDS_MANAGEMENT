package com.example.demo.repository;


//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Records;

public interface Repository extends JpaRepository<Records, Integer>{

//	List<Records> getByName(String patientName);
}

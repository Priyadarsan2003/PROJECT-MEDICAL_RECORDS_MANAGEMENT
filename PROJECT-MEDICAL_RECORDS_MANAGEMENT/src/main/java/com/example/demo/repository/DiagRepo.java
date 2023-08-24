package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DiagnosisRecord;

public interface DiagRepo extends JpaRepository<DiagnosisRecord, Integer>{

}

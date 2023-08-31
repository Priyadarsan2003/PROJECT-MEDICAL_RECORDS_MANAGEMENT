package com.example.demo.repository;


import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Records;

import jakarta.transaction.Transactional;

public interface Repository extends JpaRepository<Records, Integer>{

//	List<Records> getByName(String patientName);
	@Query(value = "select * from patient_table where patient_id=:s ", nativeQuery = true)
	public Records getInfo(@Param("s") int id);
	
	@Modifying
	@Transactional
	@Query(value = "delete from patient_table where patient_id=:s", nativeQuery = true)
	public Records deleteInfo(@Param("s") int id);
	
	@Modifying
	@Transactional
	@Query(value = "update patient_table m set m.patient_id=:s1 where m.patient_id=:s2", nativeQuery = true)
	public Records updateInfo(@Param("s1") int id, @Param("s2") int newid);
	
	@Query(value = "select * from patient_table b where b.patient_name like %:bn% ", nativeQuery = true)
	public List<Records> getInfoClass(@Param("bn") String p);
	
}

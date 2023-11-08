package com.ty.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.hrms.pojo.Batch;
@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {

	

}

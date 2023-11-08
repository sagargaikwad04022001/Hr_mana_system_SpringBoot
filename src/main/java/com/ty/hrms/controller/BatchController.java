package com.ty.hrms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hrms.pojo.Batch;
import com.ty.hrms.pojo.User;
import com.ty.hrms.repository.BatchRepository;
import com.ty.hrms.repository.UserRepository;
import com.ty.hrms.response.ResponseStructure;
import com.ty.hrms.service.BatchService;

@RestController
public class BatchController {

	@Autowired
	private BatchService service;
	
	
	
	@PostMapping("batch/{id}")
	public ResponseEntity<ResponseStructure<Batch>> saveBatch(@RequestBody Batch batch,@PathVariable int id)
	{
		return service.saveBatch(batch,id);
	}
	
	@GetMapping("batch/{id}")
	public ResponseEntity<ResponseStructure<Batch>> getBatchById(@PathVariable int id)
	{
		return service.getBatchById(id);
	}
	
	@GetMapping("batch")
	public ResponseEntity<ResponseStructure<List<Batch>>> getBatchesByUid(@RequestParam int id)
	{
		return service.getBatchByUserId(id);
	}
	
	
}

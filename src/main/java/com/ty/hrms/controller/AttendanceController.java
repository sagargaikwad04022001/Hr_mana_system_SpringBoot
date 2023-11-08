package com.ty.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ty.hrms.pojo.Attendance;
import com.ty.hrms.pojo.Batch;
import com.ty.hrms.response.ResponseStructure;
import com.ty.hrms.service.AttendanceService;

@RestController
public class AttendanceController {

	@Autowired
	private AttendanceService service;
	
	@PostMapping("attendance/{id}")
	public ResponseEntity<ResponseStructure<Attendance>> saveAttendance(@RequestBody Attendance file,@PathVariable int id)
	{
		return service.saveAttendance(file,id);
	}
	
	@GetMapping("attendance/{id}")
	public ResponseEntity<ResponseStructure<List<Attendance>>> getAttendanceByBatchId(@PathVariable int id)
	{
		return service.getAttendanceByBatchId(id);
	}
	
}

package com.ty.hrms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ty.hrms.dao.AttendanceDao;
import com.ty.hrms.dao.BatchDao;
import com.ty.hrms.dao.ImageDao;
import com.ty.hrms.exception.IdNotFoundException;
import com.ty.hrms.pojo.Attendance;
import com.ty.hrms.pojo.Batch;
import com.ty.hrms.pojo.Image;
import com.ty.hrms.response.ResponseStructure;

@Service
public class AttendanceService {

	@Autowired
	private AttendanceDao dao;

	@Autowired
	private BatchDao dao2;

	@Autowired
	private ImageDao dao3;

	public ResponseEntity<ResponseStructure<Attendance>> saveAttendance(Attendance a, int id) {
		
		
		Batch batch = dao2.getBatchById(id);
		if (batch != null) {
			List<Attendance> ats = batch.getAttendances();
			if (ats == null) {
				ats = new ArrayList<>();
			}
			Attendance attendance = dao.saveAttendance(a);
			ats.add(attendance);
			batch.setAttendances(ats);
			dao2.updateBatch(batch);
			return new ResponseEntity<ResponseStructure<Attendance>>(
					new ResponseStructure("Attendance saved", HttpStatus.CREATED.value(), attendance),
					HttpStatus.CREATED);

		}
		throw new IdNotFoundException("Batch id:" + id + " Not exist");
	}

	public ResponseEntity<ResponseStructure<List<Attendance>>> getAttendanceByBatchId(int id) {
		Batch batch = dao2.getBatchById(id);
		if (batch != null) {
			List<Attendance> ats = batch.getAttendances();
			return new ResponseEntity<ResponseStructure<List<Attendance>>>(
					new ResponseStructure("Attendance Found", HttpStatus.FOUND.value(), ats), HttpStatus.FOUND);
		}
		throw new IdNotFoundException("Batch Id:" + id + " not exist in database");
	}

}

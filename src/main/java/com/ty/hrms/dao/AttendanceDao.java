package com.ty.hrms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.ty.hrms.exception.IdNotFoundException;
import com.ty.hrms.pojo.Attendance;
import com.ty.hrms.pojo.Batch;
import com.ty.hrms.pojo.User;
import com.ty.hrms.repository.AttendanceRepository;
import com.ty.hrms.repository.BatchRepository;
import com.ty.hrms.repository.UserRepository;

@Repository
public class AttendanceDao {

	@Autowired
	private AttendanceRepository repository;
	@Autowired
	private BatchRepository repository2;
	
	public Attendance saveAttendance(Attendance attendance)
	{
		return repository.save(attendance);
	}
	
	public List<Attendance> getAttendanceByBatchId(int id)
	{
		Batch batch=repository2.findById(id).orElse(null);
		if(batch!=null)
		{
			List<Attendance> ats=batch.getAttendances();
			return ats;
		}
		return null;
		
	}

	public Attendance getAttendanceById(int id) {
		Attendance attendance=repository.findById(id).orElse(null);
		if(attendance!=null)
		{
			return attendance;
		}
		return null;
	}

	public Attendance updateAttendance(Attendance attendance) {
		return repository.save(attendance);
		
	}
}

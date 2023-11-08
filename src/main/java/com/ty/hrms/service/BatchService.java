package com.ty.hrms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hrms.dao.BatchDao;
import com.ty.hrms.dao.UserDao;
import com.ty.hrms.exception.IdNotFoundException;

import com.ty.hrms.exception.NoBatchesExistException;

import com.ty.hrms.pojo.Batch;
import com.ty.hrms.pojo.User;
import com.ty.hrms.response.ResponseStructure;

@Service
public class BatchService {

	@Autowired
	private BatchDao dao;
	@Autowired
	private UserDao dao2;

	public ResponseEntity<ResponseStructure<Batch>> saveBatch(Batch batch, int id) {
		User user=dao2.getUserById(id);
		if(user!=null)
		{
            List<Batch> batches=user.getBatches();			
			if(batches==null)
			{
				batches=new ArrayList<>();
			}
			Batch batch1=dao.saveBatch(batch);
			batches.add(batch);
			dao2.updateUser(user);	
			return new ResponseEntity<ResponseStructure<Batch>>(new ResponseStructure<Batch>("Batch Saved", HttpStatus.CREATED.value(), batch1),HttpStatus.ACCEPTED);

		}
		throw new IdNotFoundException("User Id:"+id+" Not Exist");
		
	}

	public ResponseEntity<ResponseStructure<Batch>> getBatchById(int id) {
		Batch batch=dao.getBatchById(id);
		if(batch!=null)
		{
			return new ResponseEntity<ResponseStructure<Batch>>(new ResponseStructure<Batch>("Data Found", HttpStatus.FOUND.value(), batch),HttpStatus.FOUND);
		}
		throw new IdNotFoundException("Batch Id:"+id+" Not Exist");
	}

	public ResponseEntity<ResponseStructure<List<Batch>>> getBatchByUserId(int id) {
		User user=dao2.getUserById(id);
		if(user!=null)
		{
			List<Batch> batches=user.getBatches();			
			if(batches!=null)
			{
				return new ResponseEntity<ResponseStructure<List<Batch>>>(new ResponseStructure("Batches Found", HttpStatus.FOUND.value(), batches),HttpStatus.FOUND);
			}
			throw new NoBatchesExistException("Batches Not assigned to user");
		}
		throw new IdNotFoundException("User Id:"+id+" Not Exist");
	}
	
}

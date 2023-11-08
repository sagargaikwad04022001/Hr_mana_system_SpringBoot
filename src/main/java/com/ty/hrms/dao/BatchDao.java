package com.ty.hrms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hrms.exception.IdNotFoundException;
import com.ty.hrms.pojo.Batch;
import com.ty.hrms.pojo.User;
import com.ty.hrms.repository.BatchRepository;
import com.ty.hrms.repository.UserRepository;
@Repository
public class BatchDao {

	@Autowired
	private BatchRepository repository;
	@Autowired
	private UserRepository repository2;
	
	public Batch saveBatch(Batch batch)
	{
		return repository.save(batch);
	}
	
	public Batch updateBatch(Batch batch)
	{
		return repository.save(batch);
	}
	
	public List<Batch> getBatchesByUserId(int uid)
	{
		User user=repository2.findById(uid).orElse(null);
		if(user!=null)
		{
			List<Batch> batches=user.getBatches();
			if(batches!=null && batches.size()>0)
			{
				return batches;
			}
		}
		return null;
	}
	
	public Batch getBatchById(int id)
	{
		Batch batch=repository.findById(id).orElse(null);
		if(batch!=null)
		{
			return batch;
		}
//		throw new BatchIdNotFoundException("Batch Id:"+id+" not Exist");
		return null;
	}
	
}

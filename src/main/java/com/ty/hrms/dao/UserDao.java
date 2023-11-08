package com.ty.hrms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hrms.pojo.User;
import com.ty.hrms.repository.UserRepository;

@Repository
public class UserDao {
    @Autowired
	private UserRepository repository;
	
	public User saveUser(User user)
	{
		return repository.save(user);
	}
	
	public User getUserById(int id)
	{
		User user=repository.findById(id).orElse(null);
		if(user!=null)
		{
			return user;
		}
		return null;
	}
	
	public User getUserByEmailAndPassword(String email,String password)
	{
		User user=repository.findByEmailAndPassword(email,password);
		if(user!=null)
		{
			return user;
		}
		return null;
	}
	
	public List<User> getAllUsers()
	{
		List<User> users=repository.findAll();
		if(users!=null)
		{
			return users;
		}
		return null;
	}
	
	public List<User> getAllUserByRole(String role)
	{
		List<User> users=repository.findByRole(role);
		if(users!=null)
		{
			return users;
		}
		return null;
	}
	
	public List<User> getAllUserByStatus(boolean status)
	{
		List<User> users=repository.findByStatus(status);
		if(users!=null)
		{
			return users;
		}
		return null;
	}
	
	public User updateUser(User user)
	{
		return repository.save(user);
	}
	
	public boolean removeUser(int id)
	{
		User user=repository.findById(id).orElse(null);
		if(user!=null)
		{
			repository.delete(user);
			return true;
		}
		return false;
	}
}

package com.ty.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hrms.dao.UserDao;
import com.ty.hrms.exception.IdNotFoundException;
import com.ty.hrms.exception.UserEmailNotExistException;
import com.ty.hrms.pojo.User;
import com.ty.hrms.response.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		
		User user1=dao.saveUser(user);
		return new ResponseEntity<ResponseStructure<User>>(
				new ResponseStructure("Data Saved", HttpStatus.CREATED.value(),user1 ),
				HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
		User user = dao.getUserById(id);
		if (user != null) {
			return new ResponseEntity<ResponseStructure<User>>(new ResponseStructure<User>("Data Found",HttpStatus.FOUND.value() , user),
					HttpStatus.FOUND);
		}
		throw new IdNotFoundException("User Id:" + id + " Not Exist");
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		User user2 = dao.updateUser(user);
		return new ResponseEntity<ResponseStructure<User>>(new ResponseStructure<User>("Data Updated",HttpStatus.OK.value() , user2),
				HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure> deleteUserById(int id) {
		User user=dao.getUserById(id);
		if(user!=null)
		{
			user.setBatches(null);
			dao.updateUser(user);
			dao.removeUser(id);
			return new ResponseEntity<ResponseStructure>(new ResponseStructure("Data Removed", HttpStatus.OK.value(), null),
					HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException("User Id:" + id + " Not Exist");
		
	}

	public ResponseEntity<ResponseStructure<List<User>>> getAllUsers() {
		List<User> users = dao.getAllUsers();
		return new ResponseEntity<ResponseStructure<List<User>>>(new ResponseStructure<List<User>>("Data Found", HttpStatus.FOUND.value(), users),
				HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<User>>> getAllUserByRole(String role) {
		List<User> users = dao.getAllUserByRole(role);
		return new ResponseEntity<ResponseStructure<List<User>>>(new ResponseStructure<List<User>>("Data Found", HttpStatus.FOUND.value(), users),
				HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<List<User>>> getAllUserByStatus(String status) {
		List<User> users;
		if (status.equals("Active")) {
			users = dao.getAllUserByStatus(true);
		} else {
			users = dao.getAllUserByStatus(false);
		}
		return new ResponseEntity<ResponseStructure<List<User>>>(
				new ResponseStructure("Data Found", HttpStatus.OK.value(), users), HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<User>> getUserByEmailAndPass(String email, String password) {
		User user=dao.getUserByEmailAndPassword(email, password);
		if(user!=null)
		{
			return new ResponseEntity<ResponseStructure<User>>(new ResponseStructure("Data Found", HttpStatus.FOUND.value(), user), HttpStatus.FOUND);
		}
		throw new UserEmailNotExistException("User email or password incorrect");
	}

	



}

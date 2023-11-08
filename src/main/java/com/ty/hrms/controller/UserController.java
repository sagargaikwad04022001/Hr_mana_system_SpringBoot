package com.ty.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hrms.pojo.User;
import com.ty.hrms.repository.UserRepository;
import com.ty.hrms.response.ResponseStructure;
import com.ty.hrms.service.UserService;
@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user)
	{
		return service.saveUser(user);
	}
	
	@GetMapping("user/{id}")
	public ResponseEntity<ResponseStructure<User>> getUserById(@PathVariable int id)
	{
		return service.getUserById(id);
	}
	
	@PutMapping("user")	
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user)
	{
		return service.updateUser(user);
	}
	
	@DeleteMapping("user")
	public ResponseEntity<ResponseStructure> deleteUser(@PathVariable int id)
	{
		return service.deleteUserById(id);
	}
	
	@GetMapping("users")
	public ResponseEntity<ResponseStructure<List<User>>> getAllUsers()
	{
		return service.getAllUsers();
	}
	
	@GetMapping("users/{role}")
	public ResponseEntity<ResponseStructure<List<User>>> getAllUsersByRole(@PathVariable String role)
	{
		return service.getAllUserByRole(role);
	}
	
	@GetMapping("usersByStatus/{status}")
	public ResponseEntity<ResponseStructure<List<User>>> getAllUsersByStatus(@PathVariable String status)
	{
		return service.getAllUserByStatus(status);
	}
	
	@GetMapping("user")
	public ResponseEntity<ResponseStructure<User>> getUserByEmailPass(@RequestParam String email,@RequestParam String password)
	{
		return service.getUserByEmailAndPass(email,password);
	}
	

	
}

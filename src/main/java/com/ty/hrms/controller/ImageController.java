package com.ty.hrms.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ty.hrms.pojo.Image;
import com.ty.hrms.response.ResponseStructure;
import com.ty.hrms.service.ImageService;

@RestController
public class ImageController {

	@Autowired
	private ImageService service;
	
	@PostMapping("image/{id}")
	public ResponseEntity<ResponseStructure<Image>> saveImage(@RequestBody MultipartFile file,@PathVariable int id) throws IOException
	{
		return service.saveImage(file,id);
	}
	
	@GetMapping("image/{id}")
	public ResponseEntity<ResponseStructure<String>> getImage(@PathVariable int id)
	{
		return service.getImageById(id);
	}
	
	
}

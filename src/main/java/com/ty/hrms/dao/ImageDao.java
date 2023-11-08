package com.ty.hrms.dao;


import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hrms.pojo.Image;
import com.ty.hrms.repository.ImageRepository;

@Repository
public class ImageDao {

	@Autowired
	private ImageRepository repository;
	
	public Image saveImage(Image image)
	{
		return repository.save(image);
	}
	
	public String getById(int id)
	{
		Image img=repository.findById(id).orElse(null);
		if(img!=null)
		{
			String base64Image = Base64.getEncoder().encodeToString(img.getImg());
			return base64Image;
		}
		return null;
		
	}
}

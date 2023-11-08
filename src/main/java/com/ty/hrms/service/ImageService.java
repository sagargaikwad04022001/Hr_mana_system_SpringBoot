package com.ty.hrms.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ty.hrms.dao.AttendanceDao;
import com.ty.hrms.dao.ImageDao;
import com.ty.hrms.exception.IdNotFoundException;
import com.ty.hrms.pojo.Attendance;
import com.ty.hrms.pojo.Image;
import com.ty.hrms.response.ResponseStructure;

@Service
public class ImageService {

	@Autowired
	private ImageDao dao;
	@Autowired
	private AttendanceDao dao2;

	public ResponseEntity<ResponseStructure<Image>> saveImage(MultipartFile file, int id) throws IOException {
		byte[] arr = file.getBytes();

		Attendance attendance = dao2.getAttendanceById(id);
		if (attendance != null) {
			Image image = new Image();
			image.setImg(arr);
			Image img = dao.saveImage(image);
			attendance.setImage(image);
			dao2.updateAttendance(attendance);
			return new ResponseEntity<ResponseStructure<Image>>(
					new ResponseStructure("Image Saved", HttpStatus.CREATED.value(), img), HttpStatus.CREATED);
		}
		throw new IdNotFoundException("Attendance id:" + id + " not exist");
	}

	public ResponseEntity<ResponseStructure<String>> getImageById(int id) {
		String i = dao.getById(id);
		if (i != null) {
			return new ResponseEntity<ResponseStructure<String>>(
					new ResponseStructure("Image Found", HttpStatus.FOUND.value(), i), HttpStatus.FOUND);
		}
		throw new IdNotFoundException("Image id:" + id + " Not exist in database");
	}

}

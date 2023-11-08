package com.ty.hrms.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity


@AllArgsConstructor
@NoArgsConstructor
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;		
	private byte[] img;
}

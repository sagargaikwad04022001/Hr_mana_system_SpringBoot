package com.ty.hrms.pojo;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
	@Entity
	@NoArgsConstructor	
	@AllArgsConstructor
	public class Attendance {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private int noOfStudent;
		@CreationTimestamp
		private LocalDateTime createdDateTime;
		@OneToOne
		private Image image;
		
	
}

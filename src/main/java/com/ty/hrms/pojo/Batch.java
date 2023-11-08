package com.ty.hrms.pojo;

import java.time.LocalDateTime;
import java.util.List;



import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@CreationTimestamp
	private LocalDateTime createdDateAndTime;
	@UpdateTimestamp
	private LocalDateTime completedDateAndTime;
	private boolean status;
	private String subject;
	@OneToMany
	private List<Attendance> attendances;
}

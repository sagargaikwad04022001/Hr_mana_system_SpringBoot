package com.ty.hrms.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor

@Entity
@Data
@Table(name = "user_details")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String employeeId;
	private String name;
	@Column(unique = true)
	private String email;
	private long phoneNumber;
	private String password;
	private String role;
	private boolean status;
	@OneToMany
	private List<Batch> batches;
	
	
	
}

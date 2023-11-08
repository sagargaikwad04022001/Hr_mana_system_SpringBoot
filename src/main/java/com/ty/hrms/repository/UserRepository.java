package com.ty.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.hrms.pojo.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailAndPassword(String email, String password);

	List<User> findByRole(String string);

	List<User> findByStatus(boolean status);

}

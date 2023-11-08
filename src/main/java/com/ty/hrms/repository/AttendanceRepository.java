package com.ty.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hrms.pojo.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

}

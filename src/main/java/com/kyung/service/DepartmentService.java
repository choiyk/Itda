package com.kyung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.mapper.DepartmentMapper;
import com.kyung.dto.Department;
import com.kyung.dto.DepartmentByUser;

@Service
public class DepartmentService {
	@Autowired DepartmentMapper departmentMapper;
	
	public List<Department> findAll()
	{
		List<Department> departments = departmentMapper.findAll();
		return departments;
	}

	public String findOneByUser(int userId)
	{
		System.out.println("service userId:"+userId);
		DepartmentByUser department = departmentMapper.findOneByUser(userId);
		String departmentName = department.getDepartmentName();
		return departmentName;
	}
}

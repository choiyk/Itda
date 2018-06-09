package com.kyung.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kyung.dto.Department;

@Mapper
public interface DepartmentMapper {
	List<Department> findAll();
}

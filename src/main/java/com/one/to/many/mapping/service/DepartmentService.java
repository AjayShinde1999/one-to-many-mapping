package com.one.to.many.mapping.service;

import com.one.to.many.mapping.payload.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    public DepartmentDto saveDepartment(DepartmentDto departmentDto);

    public List<DepartmentDto> getAllDepartment();

    public DepartmentDto getDepartmentById(long id);

    public void deleteDepartment(long id);

    public DepartmentDto updateDepartment(DepartmentDto departmentDto,long id);
}

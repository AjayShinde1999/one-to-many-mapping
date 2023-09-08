package com.one.to.many.mapping.service.impl;

import com.one.to.many.mapping.exception.ResourceNotFoundException;
import com.one.to.many.mapping.model.Department;
import com.one.to.many.mapping.payload.DepartmentDto;
import com.one.to.many.mapping.repository.DepartmentRepository;
import com.one.to.many.mapping.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        log.info("Payload From Postman : {}", departmentDto);
        Department department = mapToEntity(departmentDto);
        Department saveDepartment = departmentRepository.save(department);
        log.info("Data saved to database : {}", saveDepartment);
        return mapToDto(saveDepartment);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department> departments = departmentRepository.findAll();
        log.info("Fetched records from database : {}", departments);
        return departments.stream().map(department -> (mapToDto(department))).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getDepartmentById(long id) {
        log.info("Id from the request : {}", id);
        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Department not found with id : " + id)
        );
        log.info("Fetched data from database : {}", department);
        return mapToDto(department);
    }

    @Override
    public void deleteDepartment(long id) {
        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Department not found with id : " + id)
        );
        log.info("Record need to be Delete : {}", department);
        departmentRepository.delete(department);

    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto, long id) {
        log.info("Payload From Client : {}", departmentDto);
        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Department not found with id : " + id)
        );
        department.setName(departmentDto.getName());
        log.info("Updated Data : {}", departmentDto);
        Department updatedDepartment = departmentRepository.save(department);
        log.info("Saved Updated Data : {}", departmentDto);
        return mapToDto(updatedDepartment);
    }

    public Department mapToEntity(DepartmentDto departmentDto) {
        return modelMapper.map(departmentDto, Department.class);
    }

    public DepartmentDto mapToDto(Department department) {
        return modelMapper.map(department, DepartmentDto.class);
    }
}

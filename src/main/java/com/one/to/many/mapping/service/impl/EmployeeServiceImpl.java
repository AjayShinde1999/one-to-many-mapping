package com.one.to.many.mapping.service.impl;

import com.one.to.many.mapping.exception.ResourceNotFoundException;
import com.one.to.many.mapping.model.Department;
import com.one.to.many.mapping.model.Employee;
import com.one.to.many.mapping.payload.DepartmentDto;
import com.one.to.many.mapping.payload.EmployeeDto;
import com.one.to.many.mapping.repository.DepartmentRepository;
import com.one.to.many.mapping.repository.EmployeeRepository;
import com.one.to.many.mapping.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentRepository departmentRepository;

    private final ModelMapper modelMapper;

    @Override
    public EmployeeDto saveOneEmployee(EmployeeDto employeeDto, long id) {
        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Department Not Found With Id : " + id)
        );
        Employee employee = mapToEntity(employeeDto);
        employee.setDepartment(department);
        Employee saveEmployee = employeeRepository.save(employee);
        return mapToDto(saveEmployee);
    }

    public Employee mapToEntity(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, Employee.class);
    }

    public EmployeeDto mapToDto(Employee employee) {
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        // Check if the employee's department is not null
        if (employee.getDepartment() != null) {
            // Map the department's id and name to the departmentDto
            Department department = employee.getDepartment();
            DepartmentDto departmentDto = new DepartmentDto();
            departmentDto.setId(department.getId());
            departmentDto.setName(department.getName());

            // Set the departmentDto in the employeeDto
            employeeDto.setDepartment(departmentDto);
        }
        return employeeDto;
    }
}

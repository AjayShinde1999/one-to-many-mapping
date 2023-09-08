package com.one.to.many.mapping.service;

import com.one.to.many.mapping.payload.EmployeeDto;


public interface EmployeeService {

    EmployeeDto saveOneEmployee(EmployeeDto employeeDto,long id);
}

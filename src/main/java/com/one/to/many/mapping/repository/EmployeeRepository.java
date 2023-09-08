package com.one.to.many.mapping.repository;

import com.one.to.many.mapping.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}

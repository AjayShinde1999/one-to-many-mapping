package com.one.to.many.mapping.repository;

import com.one.to.many.mapping.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}

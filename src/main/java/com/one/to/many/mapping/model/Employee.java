package com.one.to.many.mapping.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_email")
    private String email;

    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "dept_id",referencedColumnName = "id")
    private Department department;
}

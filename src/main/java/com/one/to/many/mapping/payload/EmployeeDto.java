package com.one.to.many.mapping.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EmployeeDto {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;

    private DepartmentDto department;
}

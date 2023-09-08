package com.one.to.many.mapping.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class DepartmentDto {

    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 50,message = "Name should not be greater than 50 character")
    private String name;
}

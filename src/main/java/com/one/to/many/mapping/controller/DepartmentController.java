package com.one.to.many.mapping.controller;

import com.one.to.many.mapping.payload.DepartmentDto;
import com.one.to.many.mapping.service.DepartmentService;
import com.one.to.many.mapping.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public DepartmentDto saveDepartment(@Valid @RequestBody DepartmentDto departmentDto){
        return departmentService.saveDepartment(departmentDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<DepartmentDto> getAllDepartment(){
       return departmentService.getAllDepartment();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public DepartmentDto getDepartmentById(@PathVariable("id") long id){
       return departmentService.getDepartmentById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public ApiResponse deleteById(@PathVariable("id") long id){
        departmentService.deleteDepartment(id);
        return new ApiResponse("Deleted Successfully",true);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public DepartmentDto updateDepartment(@Valid @RequestBody DepartmentDto departmentDto,@PathVariable("id") long id){
       return departmentService.updateDepartment(departmentDto,id);
    }
}

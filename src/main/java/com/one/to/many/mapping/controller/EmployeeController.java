package com.one.to.many.mapping.controller;

import com.one.to.many.mapping.payload.EmployeeDto;
import com.one.to.many.mapping.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable("id") long id) {
        log.info("URL REQUEST ");
        return employeeService.saveOneEmployee(employeeDto, id);
    }
}

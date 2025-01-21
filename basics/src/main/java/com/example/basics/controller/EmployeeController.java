package com.example.basics.controller;
import com.example.basics.dto.EmployeeDTO;
import com.example.basics.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping ("/")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.saveEmployee(employeeDTO));
    }

//    @GetMapping
//    public List<EmployeeDTO> getAllEmployees() {
//        return (List<EmployeeDTO>) (List<EmployeeDTO>) ResponseEntity.ok(employeeService.getAllEmployees());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeDTO(@PathVariable Long id) { employeeService.deleteEmployee(id);
    }
}

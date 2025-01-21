package com.example.basics.service;


import com.example.basics.dto.EmployeeDTO;
import com.example.basics.model.Employee;
import com.example.basics.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(null, employeeDTO.getName(), employeeDTO.getDepartment(), employeeDTO.getSalary());
        Employee response = employeeRepository.save(employee);
        employeeDTO.setId(response.getId());
        return employeeDTO;
    }

//    public List<EmployeeDTO> getAllEmployees() {
//        return employeeRepository.findAll();
//    }

    public EmployeeDTO getEmployeeById(Long id) {
        Employee response = employeeRepository.findById(id).orElse(null);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        if(Objects.nonNull(response)){
            BeanUtils.copyProperties(response,employeeDTO);

        }else{
            //todo need to add a custom exception
            return null;
        }

        return employeeDTO;

    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}



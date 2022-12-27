package tn.teams.fromzero.services;

import tn.teams.fromzero.dto.EmployeeDTO;

import java.util.List;

public interface ServiceEmployee {

    EmployeeDTO save(EmployeeDTO dto);
    void delete(Long id);
    EmployeeDTO findById(Long id);
    List<EmployeeDTO> findAllEmployees();
    Integer countEmployeesByAge(Integer age);
}

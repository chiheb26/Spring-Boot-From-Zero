package tn.teams.fromzero.ServicesImpl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.teams.fromzero.dto.EmployeeDTO;
import tn.teams.fromzero.entities.Employee;
import tn.teams.fromzero.repositories.EmployeeRepository;
import tn.teams.fromzero.services.ServiceEmployee;
import tn.teams.fromzero.validations.ObjectsValidator;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceEmployeeImpl implements ServiceEmployee {


    private final EmployeeRepository employeeRepository;

    /* public ServiceEmployeeImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    */

    private final   ObjectsValidator<EmployeeDTO> objectsValidator;


    @Override
    public EmployeeDTO save(EmployeeDTO dto) {
        objectsValidator.validate(dto);
        Employee employee = EmployeeDTO.toEntity(dto);

        Employee savedEmployee= employeeRepository.save(employee);
        return EmployeeDTO.fromEntity(savedEmployee);
    }

    @Override
    public void delete(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new EntityNotFoundException(id+" not found"));
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO findById(Long id) {
        return employeeRepository.findById(id).map(EmployeeDTO::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No Employee was found with the provided ID"));
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Integer countEmployeesByAge(Integer age) {
        return employeeRepository.countEmployeesByAge(age);
    }
}

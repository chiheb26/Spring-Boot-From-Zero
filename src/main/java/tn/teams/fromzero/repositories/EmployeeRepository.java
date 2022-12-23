package tn.teams.fromzero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.teams.fromzero.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}

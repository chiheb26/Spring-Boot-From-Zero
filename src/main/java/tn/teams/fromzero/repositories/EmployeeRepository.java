package tn.teams.fromzero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.teams.fromzero.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("select count(emp) from Employee emp where emp.age=:age")
    Integer countEmployeesByAge( @Param("age") Integer age);
}

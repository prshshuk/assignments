package com.paypal.bfs.test.employeeserv.repository;
;
import com.paypal.bfs.test.employeeserv.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}

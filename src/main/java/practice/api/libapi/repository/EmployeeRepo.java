package practice.api.libapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.api.libapi.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}

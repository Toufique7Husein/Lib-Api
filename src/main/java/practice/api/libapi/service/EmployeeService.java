package practice.api.libapi.service;

import org.springframework.web.multipart.MultipartFile;
import practice.api.libapi.entity.Employee;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public void save(MultipartFile multipartFile) throws IOException;
    public List<Employee> findAll();
    public Employee findById(int id);
    public void deleteById(int id);

}

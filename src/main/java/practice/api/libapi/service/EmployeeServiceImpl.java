package practice.api.libapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import practice.api.libapi.entity.Employee;
import practice.api.libapi.helper.Helper;
import practice.api.libapi.repository.EmployeeRepo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepo employeeRepo;

    @Autowired
    EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    @Override
    public void save(MultipartFile file) throws IOException {
        System.out.println(file);
        List<Employee> employees = Helper.convertExcelToListOfEmployee(file.getInputStream());
        employeeRepo.saveAll(employees);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        return employee.get();
    }

    @Override
    public void deleteById(int id) {
        employeeRepo.deleteById(id);
    }
}

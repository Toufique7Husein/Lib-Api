package practice.api.libapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import practice.api.libapi.service.EmployeeService;

import java.io.IOException;

@RestController
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/employees")
    public boolean upload(@RequestParam("file")MultipartFile multipartFile) throws IOException {
        System.out.println("file saved into the database");
        employeeService.save(multipartFile);

        return true;
    }


    @GetMapping("/hi")
    public String hello() {
        return "Hi It's running:";
    }
}

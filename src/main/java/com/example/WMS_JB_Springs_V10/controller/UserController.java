package com.example.WMS_JB_Springs_V10.controller;

import com.example.WMS_JB_Springs_V10.model.Admin;
import com.example.WMS_JB_Springs_V10.model.Employee;
import com.example.WMS_JB_Springs_V10.model.LoginDTO;
import com.example.WMS_JB_Springs_V10.repository.UserRepository;
import com.example.WMS_JB_Springs_V10.service.UserService;
import com.example.WMS_JB_Springs_V10.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping ("/users/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return userService.getAllEmployees();
    }

    @GetMapping("/users/getAllAdmins")
    public List<Admin> getAllAdmins(){
        return userService.getAllAdmins();
    }

    @GetMapping("/users/employee/login")
    public boolean employeeLogin(@RequestBody LoginDTO loginDTO){
        return userService.isEmployeeValid(loginDTO.getUsername(),loginDTO.getPassword());
    }

    @GetMapping("/users/admin/login")
    public boolean userLogin(@RequestBody LoginDTO loginDTO){
        return userService.isAdminValid(loginDTO.getUsername(), loginDTO.getPassword());
    }


}




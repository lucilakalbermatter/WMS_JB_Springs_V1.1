package com.example.WMS_JB_Springs_V10.service;

import com.example.WMS_JB_Springs_V10.model.Admin;
import com.example.WMS_JB_Springs_V10.model.Employee;
import com.example.WMS_JB_Springs_V10.model.User;
import com.example.WMS_JB_Springs_V10.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    public List<Employee> getAllEmployees(){
        return UserRepository.getAllEmployees();
    }

    public List<Admin> getAllAdmins(){
        return UserRepository.getAllAdmins();
    }

    public boolean isEmployeeValid(String userName, String password){
        return UserRepository.isEmployeeValid(userName,password);
    }

    public boolean isAdminValid(String userName, String password){
        return UserRepository.isAdminValid(userName,password);
    }

}

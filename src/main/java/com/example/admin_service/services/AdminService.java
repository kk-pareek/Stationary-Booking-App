package com.example.admin_service.services;

import com.example.admin_service.entities.Admin;

import java.util.List;


public interface AdminService {



    List<Admin> getAdmin();
    Admin createAdmin(Admin admin);
    Admin geAdminById(Integer adminId);
    Admin updateAdminById(Integer adminId, Admin admin);
    Admin deleteAdminById(Integer adminId);


}

package com.example.admin_service.services;

import com.example.admin_service.entities.Admin;
import com.example.admin_service.exceptions.AdminNotFoundException;
import com.example.admin_service.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> getAdmin() {

        return adminRepository.findAll();
    }

    @Override
    public Admin createAdmin(Admin admin) {

        adminRepository.save(admin);
        return null;
    }

    @Override
    public Admin geAdminById(Integer adminId) {

        Optional<Admin> admin=adminRepository.findById(adminId);
        if(admin.isPresent()) {
            return admin.get();
        }
        else {
            throw new AdminNotFoundException("Admin with id: "+ adminId+" doesn't exist.");

        }

    }


    @Override
    public Admin updateAdminById(Integer adminId, Admin admin) {
        Admin existingAdmin=geAdminById(adminId);
        existingAdmin.setEmailId(admin.getEmailId());
        existingAdmin.setName(admin.getName());
        adminRepository.save(existingAdmin);
        return null;
    }

    @Override
    public Admin deleteAdminById(Integer adminId) {
        adminRepository.deleteById(adminId);
        return null;
    }
}

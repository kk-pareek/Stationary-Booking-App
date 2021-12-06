package com.example.admin_service.controller;

import com.example.admin_service.entities.Admin;
import com.example.admin_service.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdminController {

    private AdminService theAdminService;
    private Object Optional;

    @Autowired
    public AdminController(AdminService theAdminService) {
        this.theAdminService = theAdminService;
    }

    @GetMapping
    public ResponseEntity<String> applicationStatus(){
        return new ResponseEntity<>("Admin-Service is up", HttpStatus.OK);
    }



    @GetMapping("admin")
    public Iterable<Admin>getAdmin(){
        return theAdminService.getAdmin();
    }

    @PostMapping("create")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
        return new ResponseEntity<>(theAdminService.createAdmin(admin),HttpStatus.CREATED);
    }

    @GetMapping("admin/{adminId}")
    public  ResponseEntity<Admin> getAdminById(@PathVariable("adminId") Integer adminId){
        return new ResponseEntity<>(theAdminService.geAdminById(adminId),HttpStatus.FOUND);
    }

    @PutMapping("update/{adminId}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable("adminId") Integer adminId, @RequestBody Admin admin){
        return new ResponseEntity<>(theAdminService.updateAdminById(adminId, admin),HttpStatus.OK);
    }

    @DeleteMapping("delete/{adminId}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable("adminId") Integer adminId, @RequestBody Admin admin){
        return new ResponseEntity<>(theAdminService.deleteAdminById(adminId),HttpStatus.OK);
    }

}

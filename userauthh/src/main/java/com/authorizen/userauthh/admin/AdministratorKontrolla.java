package com.authorizen.userauthh.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdministratorKontrolla {
    @GetMapping
    public String get(){
        return "GET:: Admin Controller";
    }
    @PostMapping
    public String post(){
        return "POST:: Admin Controller";
    }
    @PutMapping
    public String put(){
        return "PUT:: Admin Controller";
    }
    @DeleteMapping
    public String delete(){
        return "DELETE:: Admin Controller";
    }

    
}

package com.authorizen.userauthh.admin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/management")
public class ManagementKontrola {
    @GetMapping
    public String get(){
        return "GET:: Management controller";
    }
    @PostMapping
    public String post(){
        return "POST:: Management controller";
    }
    @PutMapping
    public String put(){
        return "PUT:: Management controller";
    }
    @DeleteMapping
    public String delete(){
        return "DELETE:: Management controller";
    }
    
}
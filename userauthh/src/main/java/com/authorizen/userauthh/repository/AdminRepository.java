package com.authorizen.userauthh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authorizen.userauthh.model.Admin;
import com.authorizen.userauthh.model.User;
 
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
    
}
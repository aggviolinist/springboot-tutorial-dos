package com.authorizen.userauthh.admin;

import com.authorizen.userauthh.dto.CarRequest;
import com.authorizen.userauthh.model.Admin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/image")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/add-car")
    public ResponseEntity<Admin> addCar(@ModelAttribute CarRequest carRequest) {
        // Delegate all logic to the service layer
        Admin newCar = adminService.addCar(carRequest);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }
    //  @PostMapping("/add-car-no-image")
    // public ResponseEntity<Admin> addCarWithoutImage(@RequestBody CarDetailsRequest carDetailsRequest) {
    //     // You would create a service method to handle this
    //     Admin newCar = adminService.addCarWithoutImage(carDetailsRequest);
    //     return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    // }
}
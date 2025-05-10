package com.bazooka.controller;

import com.bazooka.entity.Car;
import com.bazooka.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class CarController {

    @Autowired
    private CarService carService;

    // Registration Endpoint
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Car car) {
        // Make sure to handle default values like 'available' in the service or entity.
        boolean isRegistered = carService.registerUser(car);
        if (isRegistered) {
            return ResponseEntity.ok("User registered successfully");
        } else {
            return ResponseEntity.badRequest().body("User already exists");
        }
    }

    // Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Car car) {
        boolean isValidUser = carService.loginUser(car.getEmail(), car.getPassword());
        if (isValidUser) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }
}

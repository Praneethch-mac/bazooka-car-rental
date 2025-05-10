package com.bazooka.service;

import com.bazooka.entity.Car;
import com.bazooka.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo carRepository;

    // Register User
    @Override
    public boolean registerUser(Car car) {
        // Check if user with the same email already exists
        if (carRepository.existsById(car.getEmail())) {
            return false; // User already exists
        }
        carRepository.save(car); // Save the new user
        return true;
    }

    // Validate Login
    @Override
    public boolean loginUser(String email, String password) {
        Car car = carRepository.findById(email).orElse(null);
        if (car != null && car.getPassword().equals(password)) {
            return true; // Valid user
        }
        return false; // Invalid credentials
    }
}

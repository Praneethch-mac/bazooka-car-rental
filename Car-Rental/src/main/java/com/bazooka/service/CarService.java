package com.bazooka.service;

import com.bazooka.entity.Car;

public interface CarService {
    boolean registerUser(Car car);
    boolean loginUser(String email, String password);
}

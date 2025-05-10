package com.bazooka.repo;

import com.bazooka.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car, String> {
    // JpaRepository already provides the basic CRUD methods (findById, save, etc.)
}

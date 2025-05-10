package com.bazooka.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    @Id
    private String email;  // Using email as the primary key

    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean available = true;  // Default value set to true
}

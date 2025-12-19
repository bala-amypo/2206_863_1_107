package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String name;
private String email;
private String password;
private String role;

@OneToMany
private List<Parcel> parcels;

public User() {}

public User(String name, String email, String password, String role) {
this.name = name;
this.email = email;
this.password = password;
this.role = role;
}

}
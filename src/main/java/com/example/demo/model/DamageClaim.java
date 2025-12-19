package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "damage_claims")
public class DamageClaim {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
private Parcel parcel;

private String claimDescription;
private String status;
private Double score;

@ManyToMany
private Set<ClaimRule> appliedRules;

private LocalDateTime filedAt;

@PrePersist
public void onCreate() {
this.filedAt = LocalDateTime.now();
this.status = "PENDING";
}
public void setParcel(Parcel parcel) {
    this.parcel = parcel;
    }
public DamageClaim() {}

// getters and setters
}
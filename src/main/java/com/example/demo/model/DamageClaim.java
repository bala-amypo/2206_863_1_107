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
private LocalDateTime filedAt;
private String status;
private Double score;

@ManyToMany
private Set<ClaimRule> appliedRules;

public DamageClaim() {}

@PrePersist
public void onCreate() {
this.filedAt = LocalDateTime.now();
this.status = "PENDING";
}

public Long getId() { return id; }
public void setParcel(Parcel parcel) { this.parcel = parcel; }
public String getClaimDescription() { return claimDescription; }
public void setClaimDescription(String claimDescription) {
this.claimDescription = claimDescription;
}
public void setScore(Double score) { this.score = score; }
public void setStatus(String status) { this.status = status; }
}
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "damage_claims")
public class DamageClaim {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
@JoinColumn(name = "parcel_id")
private Parcel parcel;

private String claimDescription;
private String status;
private Double score;

private LocalDateTime filedAt;

@PrePersist
public void beforeSave() {
filedAt = LocalDateTime.now();
status = "PENDING";
}

public DamageClaim() {
}

public Long getId() {
return id;
}

public void setParcel(Parcel parcel) {
this.parcel = parcel;
}
}
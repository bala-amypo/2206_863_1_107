package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "parcels")
public class Parcel {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(unique = true)
private String trackingNumber;

private String senderName;
private String receiverName;
private Double weightKg;

@OneToMany(mappedBy = "parcel")
private List<DamageClaim> claims;

public Parcel() {}

public Long getId() {
return id;
}

public String getTrackingNumber() {
return trackingNumber;
}

public Double getWeightKg() {
return weightKg;
}
}
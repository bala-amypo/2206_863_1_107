package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "evidence")
public class Evidence {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
private DamageClaim claim;

private String evidenceType;
private String fileUrl;
private LocalDateTime uploadedAt;

@PrePersist
public void onUpload() {
this.uploadedAt = LocalDateTime.now();
}
public void setClaim(DamageClaim claim) {}
    this.claim = claim;
    }

public Evidence() {

    }
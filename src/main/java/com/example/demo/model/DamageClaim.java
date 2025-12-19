package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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

private LocalDateTime filedAt;

private String status;

private Double score;

@ManyToMany
@JoinTable(
name = "claim_rule_mapping",
joinColumns = @JoinColumn(name = "claim_id"),
inverseJoinColumns = @JoinColumn(name = "rule_id")
)
private Set<ClaimRule> appliedRules;

@OneToMany(mappedBy = "claim")
private List<Evidence> evidenceList;

public DamageClaim() {
this.status = "PENDING";
}

@PrePersist
public void setFiledAt() {
this.filedAt = LocalDateTime.now();
}

public Long getId() {
return id;
}

public String getStatus() {
return status;
}
}
package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "claim_rules")
public class ClaimRule {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String ruleName;
private String conditionExpression;
private Double weight;

@ManyToMany(mappedBy = "appliedRules")
private Set<DamageClaim> claims;

public ClaimRule() {}

public ClaimRule(String ruleName, String conditionExpression, Double weight) {
this.ruleName = ruleName;
this.conditionExpression = conditionExpression;
this.weight = weight;
}
public Double getWeight() {
    return weight;
    }

}
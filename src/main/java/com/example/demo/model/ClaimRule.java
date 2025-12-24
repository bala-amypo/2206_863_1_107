package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "claim_rules")
public class ClaimRule {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String ruleName;
private String conditionExpression;
private Double weight;

public ClaimRule() {}

public Double getWeight() { return weight; }
public String getConditionExpression() { return conditionExpression; }
}
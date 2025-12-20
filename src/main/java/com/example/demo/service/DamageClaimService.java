package com.example.demo.service;

import com.example.demo.model.DamageClaim;

public interface DamageClaimService {

DamageClaim file(Long parcelId, DamageClaim claim);

DamageClaim get(Long id);
}
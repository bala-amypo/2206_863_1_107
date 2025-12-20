package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DamageClaimService;
import org.springframework.stereotype.Service;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

private final ParcelRepository parcelRepo;
private final DamageClaimRepository claimRepo;

public DamageClaimServiceImpl(ParcelRepository parcelRepo,
DamageClaimRepository claimRepo) {
this.parcelRepo = parcelRepo;
this.claimRepo = claimRepo;
}

public DamageClaim file(Long parcelId, DamageClaim claim) {
Parcel parcel = parcelRepo.findById(parcelId)
.orElseThrow(() -> new ResourceNotFoundException("parcel not found"));
claim.setParcel(parcel);
return claimRepo.save(claim);
}

public DamageClaim get(Long id) {
return claimRepo.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("claim not found"));
}
}
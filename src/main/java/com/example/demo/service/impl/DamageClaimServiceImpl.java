package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DamageClaim;
import com.example.demo.model.Parcel;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.DamageClaimService;
import org.springframework.stereotype.Service;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

private final ParcelRepository parcelRepository;
private final DamageClaimRepository claimRepository;

public DamageClaimServiceImpl(ParcelRepository parcelRepository,
DamageClaimRepository claimRepository) {
this.parcelRepository = parcelRepository;
this.claimRepository = claimRepository;
}

@Override
public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {
Parcel parcel = parcelRepository.findById(parcelId)
.orElseThrow(() -> new ResourceNotFoundException("parcel not found"));

claim.setParcel(parcel);
return claimRepository.save(claim);
}

@Override
public DamageClaim getClaim(Long id) {
return claimRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("claim not found"));
}
}
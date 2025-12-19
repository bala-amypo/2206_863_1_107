package com.example.demo.service.impl;

import com.example.demo.exception.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DamageClaimService;

public class DamageClaimServiceImpl implements DamageClaimService {

private final ParcelRepository parcelRepository;
private final DamageClaimRepository claimRepository;

public DamageClaimServiceImpl(ParcelRepository parcelRepository,
DamageClaimRepository claimRepository) {
this.parcelRepository = parcelRepository;
this.claimRepository = claimRepository;
}

public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {
Parcel parcel = parcelRepository.findById(parcelId)
.orElseThrow(() -> new ResourceNotFoundException("parcel not found"));
claim.setParcel(parcel);
return claimRepository.save(claim);
}

public DamageClaim getClaim(Long claimId) {
return claimRepository.findById(claimId)
.orElseThrow(() -> new ResourceNotFoundException("claim not found"));
}
}
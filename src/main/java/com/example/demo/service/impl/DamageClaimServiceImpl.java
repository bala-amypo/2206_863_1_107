package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DamageClaimService;
import com.example.demo.exception.*;
import com.example.demo.util.RuleEngineUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

private final ParcelRepository parcelRepo;
private final DamageClaimRepository claimRepo;
private final ClaimRuleRepository ruleRepo;

public DamageClaimServiceImpl(
ParcelRepository parcelRepo,
DamageClaimRepository claimRepo,
ClaimRuleRepository ruleRepo) {

this.parcelRepo = parcelRepo;
this.claimRepo = claimRepo;
this.ruleRepo = ruleRepo;
}

public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {
Parcel parcel = parcelRepo.findById(parcelId)
.orElseThrow(() -> new ResourceNotFoundException("parcel not found"));
claim.setParcel(parcel);
return claimRepo.save(claim);
}

public DamageClaim evaluateClaim(Long claimId) {
DamageClaim claim = claimRepo.findById(claimId)
.orElseThrow(() -> new ResourceNotFoundException("claim not found"));

List<ClaimRule> rules = ruleRepo.findAll();
double score = RuleEngineUtil.computeScore(
claim.getClaimDescription(), rules);

claim.setScore(score);
claim.setStatus(score >= 0.5 ? "APPROVED" : "REJECTED");
return claimRepo.save(claim);
}

public DamageClaim getClaim(Long claimId) {
return claimRepo.findById(claimId)
.orElseThrow(() -> new ResourceNotFoundException("claim not found"));
}
}
package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.EvidenceService;
import com.example.demo.exception.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvidenceServiceImpl implements EvidenceService {

private final EvidenceRepository evidenceRepo;
private final DamageClaimRepository claimRepo;

public EvidenceServiceImpl(
EvidenceRepository evidenceRepo,
DamageClaimRepository claimRepo) {

this.evidenceRepo = evidenceRepo;
this.claimRepo = claimRepo;
}

public Evidence uploadEvidence(Long claimId, Evidence evidence) {
DamageClaim claim = claimRepo.findById(claimId)
.orElseThrow(() -> new ResourceNotFoundException("claim not found"));
evidence.setClaim(claim);
return evidenceRepo.save(evidence);
}

public List<Evidence> getEvidenceForClaim(Long claimId) {
return evidenceRepo.findByClaim_Id(claimId);
}
}
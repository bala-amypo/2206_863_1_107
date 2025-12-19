package com.example.demo.service.impl;

import com.example.demo.exception.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.EvidenceService;
import java.util.List;

public class EvidenceServiceImpl implements EvidenceService {

private final EvidenceRepository evidenceRepository;
private final DamageClaimRepository claimRepository;

public EvidenceServiceImpl(EvidenceRepository evidenceRepository,
DamageClaimRepository claimRepository) {
this.evidenceRepository = evidenceRepository;
this.claimRepository = claimRepository;
}

public Evidence uploadEvidence(Long claimId, Evidence evidence) {
DamageClaim claim = claimRepository.findById(claimId)
.orElseThrow(() -> new ResourceNotFoundException("claim not found"));
evidence.setClaim(claim);
return evidenceRepository.save(evidence);
}

public List<Evidence> getEvidenceForClaim(Long claimId) {
return evidenceRepository.findByClaim_Id(claimId);
}
}
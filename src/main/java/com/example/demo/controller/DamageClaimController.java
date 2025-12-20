package com.example.demo.controller;

import com.example.demo.model.DamageClaim;
import com.example.demo.service.DamageClaimService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/claims")
public class DamageClaimController {

private final DamageClaimService damageClaimService;

public DamageClaimController(DamageClaimService damageClaimService) {
this.damageClaimService = damageClaimService;
}

@PostMapping("/{parcelId}")
public DamageClaim file(@PathVariable Long parcelId,
@RequestBody DamageClaim claim) {
return damageClaimService.fileClaim(parcelId, claim);
}

@GetMapping("/{id}")
public DamageClaim get(@PathVariable Long id) {
return damageClaimService.getClaim(id);
}
}
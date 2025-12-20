package com.example.demo.controller;

import com.example.demo.model.DamageClaim;
import com.example.demo.service.DamageClaimService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/claims")
public class DamageClaimController {

private final DamageClaimService service;

public DamageClaimController(DamageClaimService service) {
this.service = service;
}

@PostMapping("/{parcelId}")
public DamageClaim file(@PathVariable Long parcelId,
@RequestBody DamageClaim claim) {
return service.file(parcelId, claim);
}

@GetMapping("/{id}")
public DamageClaim get(@PathVariable Long id) {
return service.get(id);
}
}
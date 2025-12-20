package com.example.demo.controller;

import com.example.demo.model.ClaimRule;
import com.example.demo.service.ClaimRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Claim Rules")
public class ClaimRuleController {

private final ClaimRuleService claimRuleService;

public ClaimRuleController(ClaimRuleService claimRuleService) {
this.claimRuleService = claimRuleService;
}

@PostMapping
public ClaimRule addRule(@RequestBody ClaimRule rule) {
return claimRuleService.addRule(rule);
}

@GetMapping
public List<ClaimRule> getRules() {
return claimRuleService.getAllRules();
}
}
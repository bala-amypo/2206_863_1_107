package com.example.demo.service.impl;

import com.example.demo.model.ClaimRule;
import com.example.demo.repository.ClaimRuleRepository;
import com.example.demo.service.ClaimRuleService;
import com.example.demo.exception.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimRuleServiceImpl implements ClaimRuleService {

private final ClaimRuleRepository repo;

public ClaimRuleServiceImpl(ClaimRuleRepository repo) {
this.repo = repo;
}

public ClaimRule addRule(ClaimRule rule) {
if (rule.getWeight() < 0) {
throw new BadRequestException("weight");
}
return repo.save(rule);
}

public List<ClaimRule> getAllRules() {
return repo.findAll();
}
}
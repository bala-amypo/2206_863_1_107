package com.example.demo.service;

import com.example.demo.model.ClaimRule;
import java.util.List;

public interface ClaimRuleService {

    ClaimRule createRule(ClaimRule rule);

    List<ClaimRule> getAllRules();
}

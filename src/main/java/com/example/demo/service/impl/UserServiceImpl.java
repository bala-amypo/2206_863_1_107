package com.example.demo.service.impl;

import com.example.demo.exception.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

public class UserServiceImpl implements UserService {

private final UserRepository userRepository;

public UserServiceImpl(UserRepository userRepository) {
this.userRepository = userRepository;
}

public User register(User user) {
if (userRepository.existsByEmail(user.getEmail())) {
throw new BadRequestException("Email already exists");
}
if (user.getRole() == null) {
user.setRole("AGENT");
}
return userRepository.save(user);
}

public User findByEmail(String email) {
return userRepository.findByEmail(email)
.orElseThrow(() -> new ResourceNotFoundException("User not found"));
}
}
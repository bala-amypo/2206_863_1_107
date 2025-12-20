package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelServiceImpl implements ParcelService {

private final ParcelRepository repo;

public ParcelServiceImpl(ParcelRepository repo) {
this.repo = repo;
}

@Override
public Parcel add(Parcel parcel) {
if (parcel.getWeightKg() == null || parcel.getWeightKg() <= 0) {
throw new BadRequestException("weight invalid");
}

if (repo.existsByTrackingNumber(parcel.getTrackingNumber())) {
throw new BadRequestException("tracking exists");
}

return repo.save(parcel);
}

@Override
public Parcel getByTracking(String tracking) {
return repo.findByTrackingNumber(tracking)
.orElseThrow(() -> new ResourceNotFoundException("parcel not found"));
}

@Override
public List<Parcel> getAll() {
return repo.findAll();
}
}
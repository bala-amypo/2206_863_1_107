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

private final ParcelRepository parcelRepository;

public ParcelServiceImpl(ParcelRepository parcelRepository) {
this.parcelRepository = parcelRepository;
}

@Override
public Parcel create(Parcel parcel) {
if (parcel.getWeightKg() <= 0) {
throw new BadRequestException("weight invalid");
}

if (parcelRepository.existsByTrackingNumber(parcel.getTrackingNumber())) {
throw new BadRequestException("tracking exists");
}

return parcelRepository.save(parcel);
}

@Override
public Parcel getByTracking(String trackingNumber) {
return parcelRepository.findByTrackingNumber(trackingNumber)
.orElseThrow(() -> new ResourceNotFoundException("parcel not found"));
}

@Override
public List<Parcel> getAll() {
return parcelRepository.findAll();
}

@Override
public void delete(Long id) {
Parcel parcel = parcelRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("parcel not found"));
parcelRepository.delete(parcel);
}
}
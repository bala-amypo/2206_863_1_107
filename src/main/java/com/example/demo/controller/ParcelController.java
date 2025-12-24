package com.example.demo.controller;

import com.example.demo.model.Parcel;
import com.example.demo.service.ParcelService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parcels")
public class ParcelController {

private final ParcelService parcelService;

public ParcelController(ParcelService parcelService) {
this.parcelService = parcelService;
}

@PostMapping
public Parcel add(@RequestBody Parcel parcel) {
return parcelService.addParcel(parcel);
}

@GetMapping("/tracking/{trackingNumber}")
public Parcel getByTracking(@PathVariable String trackingNumber) {
return parcelService.getByTrackingNumber(trackingNumber);
}
}
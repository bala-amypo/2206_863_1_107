package com.example.demo.controller;

import com.example.demo.model.Parcel;
import com.example.demo.service.ParcelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parcels")
public class ParcelController {

private final ParcelService parcelService;

public ParcelController(ParcelService parcelService) {
this.parcelService = parcelService;
}

@PostMapping
public Parcel create(@RequestBody Parcel parcel) {
return parcelService.create(parcel);
}

@GetMapping("/{tracking}")
public Parcel get(@PathVariable String tracking) {
return parcelService.getByTracking(tracking);
}

@GetMapping
public List<Parcel> getAll() {
return parcelService.getAll();
}

@DeleteMapping("/{id}")
public void delete(@PathVariable Long id) {
parcelService.delete(id);
}
}
package com.example.demo.controller;

import com.example.demo.model.Parcel;
import com.example.demo.service.ParcelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parcels")
public class ParcelController {

private final ParcelService service;

public ParcelController(ParcelService service) {
this.service = service;
}

@PostMapping
public Parcel add(@RequestBody Parcel parcel) {
return service.add(parcel);
}

@GetMapping("/{tracking}")
public Parcel get(@PathVariable String tracking) {
return service.getByTracking(tracking);
}

@GetMapping
public List<Parcel> all() {
return service.getAll();
}
}
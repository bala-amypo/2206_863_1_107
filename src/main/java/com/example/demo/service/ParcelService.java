package com.example.demo.service;

import com.example.demo.model.Parcel;
import java.util.List;

public interface ParcelService {

Parcel add(Parcel parcel);

Parcel getByTracking(String tracking);

List<Parcel> getAll();
}
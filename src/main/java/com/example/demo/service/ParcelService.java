package com.example.demo.service;

import com.example.demo.model.Parcel;

import java.util.List;

public interface ParcelService {

    Parcel create(Parcel parcel);

        Parcel getByTracking(String trackingNumber);

            List<Parcel> getAll();

                void delete(Long id);
                }
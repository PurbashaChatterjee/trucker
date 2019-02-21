package io.egen.service;

import io.egen.entity.Reading;

import java.util.List;

public interface ReadingService {

    List<Reading> findAll();
    
    List<Reading> findReadings(String vin);

    Reading findOne(String id);

    Reading create(Reading reading);

}

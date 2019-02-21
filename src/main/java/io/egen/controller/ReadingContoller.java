package io.egen.controller;

import io.egen.entity.Alert;
import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import io.egen.repository.ReadingsRepository;
import io.egen.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readings")
@CrossOrigin(origins = {"http://mocker.egen.io", "http://mocker.ennate.academy"})
public class ReadingContoller {

    private final ReadingService service;

    @Autowired
    public ReadingContoller(ReadingService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Reading> findAll() {
        return service.findAll();
    }
    
    @GetMapping(path = "/{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading findOne(@PathVariable String vin) {
        return service.findOne(vin);
    }
    

    @GetMapping(path = "/vin/{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Reading> findReadings(@PathVariable String vin) {
        return service.findReadings(vin);
    }
    
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading create(@RequestBody Reading reading) {
        System.out.println("Creating Reading record");
        return service.create(reading);
    }
}

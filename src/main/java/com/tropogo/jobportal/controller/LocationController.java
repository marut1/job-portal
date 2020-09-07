package com.tropogo.jobportal.controller;

import com.tropogo.jobportal.model.Location;
import com.tropogo.jobportal.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1")
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping(value = "/location/all")
    public ResponseEntity<List<Location>> getAllLocations() {
        return ResponseEntity.ok(locationService.getLocationList());
    }
}

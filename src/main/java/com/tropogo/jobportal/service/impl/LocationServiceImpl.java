package com.tropogo.jobportal.service.impl;

import com.tropogo.jobportal.model.Location;
import com.tropogo.jobportal.respository.LocationRepository;
import com.tropogo.jobportal.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    LocationRepository locationRepository;

    public LocationServiceImpl() {
    }

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getLocationList() {
        return locationRepository.findByOrderByCityAsc();
    }
}

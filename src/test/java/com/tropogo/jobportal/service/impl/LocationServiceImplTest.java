package com.tropogo.jobportal.service.impl;

import com.tropogo.jobportal.model.Location;
import com.tropogo.jobportal.respository.LocationRepository;
import com.tropogo.jobportal.service.LocationService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LocationServiceImplTest {

    @InjectMocks
    LocationService locationService;

    @Test
    void getLocationList() {
        LocationRepository locationRepositoryMock = Mockito.mock(LocationRepository.class);
        List<Location> locationList = new ArrayList<>();
        Location location = new Location(UUID.randomUUID(), "address", "city",
                "state", "country", "zip");
        locationList.add(location);

        when(locationRepositoryMock.findByOrderByCityAsc()).thenReturn(locationList);

        locationService = new LocationServiceImpl(locationRepositoryMock);
        List<Location> response = locationService.getLocationList();

        verify(locationRepositoryMock, times(1)).findByOrderByCityAsc();
        assertEquals(location, response.get(0));
    }
}
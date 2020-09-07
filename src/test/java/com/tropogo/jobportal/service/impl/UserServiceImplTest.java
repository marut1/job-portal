package com.tropogo.jobportal.service.impl;

import com.tropogo.jobportal.exception.ResourceNotFoundException;
import com.tropogo.jobportal.model.Company;
import com.tropogo.jobportal.model.Location;
import com.tropogo.jobportal.model.UserAccount;
import com.tropogo.jobportal.respository.UserRepository;
import com.tropogo.jobportal.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @InjectMocks
    UserService userService;

    @Test
    void getUserDetailsTest() throws ResourceNotFoundException {
        Company company = new Company(UUID.randomUUID(), "Tropogo");
        Location location = new Location(UUID.randomUUID(), "address", "city",
                "state", "country", "zip");
        UserAccount user = new UserAccount(UUID.randomUUID(), "First", "Last",
                "abc@gmail.com", "9876543210",company, location);

        UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);

        when(userRepositoryMock.findByEmail(anyString())).thenReturn(user);

        userService = new UserServiceImpl(userRepositoryMock);
        UserAccount response = userService.getUserDetails(anyString());

        verify(userRepositoryMock, times(1)).findByEmail(anyString());
        assertEquals(user, response);
    }

    @Test
    void getUserDetailsTestWhenNoRecordExist() {
        UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);

        when(userRepositoryMock.findByEmail(anyString())).thenReturn(null);

        userService = new UserServiceImpl(userRepositoryMock);

        assertThrows(ResourceNotFoundException.class, ()->userService.getUserDetails(anyString()));

    }
}
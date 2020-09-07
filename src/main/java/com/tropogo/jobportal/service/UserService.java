package com.tropogo.jobportal.service;

import com.tropogo.jobportal.exception.ResourceNotFoundException;
import com.tropogo.jobportal.model.UserAccount;
import org.apache.catalina.User;

import java.util.UUID;

public interface UserService {

    UserAccount getUserDetails(String email) throws ResourceNotFoundException;

}

package com.tropogo.jobportal.service.impl;

import com.tropogo.jobportal.exception.ResourceNotFoundException;
import com.tropogo.jobportal.model.UserAccount;
import com.tropogo.jobportal.respository.UserRepository;
import com.tropogo.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserAccount getUserDetails(String email) throws ResourceNotFoundException {
        UserAccount user = userRepository.findByEmail(email);
        if(user == null){
            throw new ResourceNotFoundException("Resource does not exist for the entered email");
        }

        return user;
    }
}

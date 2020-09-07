package com.tropogo.jobportal.controller;

import com.tropogo.jobportal.exception.ResourceNotFoundException;
import com.tropogo.jobportal.model.Location;
import com.tropogo.jobportal.model.UserAccount;
import com.tropogo.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.websocket.server.PathParam;


@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/user/{email}")
    public ResponseEntity<UserAccount> getUserDetails(@PathVariable("email") @NotBlank String email)
            throws ResourceNotFoundException {

        return ResponseEntity.ok(userService.getUserDetails(email));

    }
}

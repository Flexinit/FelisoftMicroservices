package com.felisofttaxi.registrationservice.controller;

import com.felisofttaxi.registrationservice.kafka.UserDetailsProducer;
import com.felisofttaxi.registrationservice.model.UserDetails;
import com.felisofttaxi.registrationservice.sevice.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@Slf4j
public class UserContoller {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsProducer userDetailsProducer;


    @PostMapping
    public UserDetails saveUser(@RequestBody UserDetails userDetails){
        log.info("User being Saved at Controller from Request Body  ->{}", userDetails);

        userDetailsProducer.sendMessage(userDetails);
        return userService.saveUser(userDetails);
    }


}

package com.felisofttaxi.registrationservice.sevice;

import com.felisofttaxi.registrationservice.model.UserDetails;
import com.felisofttaxi.registrationservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public UserDetails saveUser(UserDetails userDetails){
        log.info("User being registered at Service level ->{}", userDetails);

        return userRepository.save(userDetails);
    }



}

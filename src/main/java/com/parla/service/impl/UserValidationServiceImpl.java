package com.parla.service.impl;

import com.parla.pojo.front.LoginUser;
import com.parla.pojo.validation.ValidationStatus;
import com.parla.service.UserValidationService;
import org.springframework.stereotype.Service;

@Service
public class UserValidationServiceImpl implements UserValidationService {

    //todo add validation on email and existing user
    public ValidationStatus validateUser(LoginUser user){
        return ValidationStatus.OK;
    }

}

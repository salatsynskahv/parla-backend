package com.parla.service;

import com.parla.pojo.front.LoginUser;
import com.parla.pojo.validation.ValidationStatus;

public interface UserValidationService {
    ValidationStatus validateUser(LoginUser user);
}

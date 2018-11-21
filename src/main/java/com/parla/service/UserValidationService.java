package com.parla.service;

import com.parla.pojo.User;
import com.parla.pojo.validation.ValidationStatus;

public interface UserValidationService {
    ValidationStatus validateUser(User user);
}

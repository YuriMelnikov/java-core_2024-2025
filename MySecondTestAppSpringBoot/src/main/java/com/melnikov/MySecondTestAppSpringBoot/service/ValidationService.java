package com.melnikov.MySecondTestAppSpringBoot.service;

import com.melnikov.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
}

package com.melnikov.MySecondTestAppSpringBoot.service;

import com.melnikov.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class RequestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException{
        if(bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }
}

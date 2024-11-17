package com.melnikov.MySecondTestAppSpringBoot.service;

import com.melnikov.MySecondTestAppSpringBoot.model.Request;
import org.springframework.stereotype.Service;

@Service
public interface ModifyRequestService {
    void modify(Request request);
}

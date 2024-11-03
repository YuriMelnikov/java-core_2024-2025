package com.melnikov.MyThirdTestAppSpringBoot.service;

import com.melnikov.MyThirdTestAppSpringBoot.model.Request;
import org.springframework.stereotype.Service;

@Service
public interface ModifyRequestService {
    void modify(Request request);
}

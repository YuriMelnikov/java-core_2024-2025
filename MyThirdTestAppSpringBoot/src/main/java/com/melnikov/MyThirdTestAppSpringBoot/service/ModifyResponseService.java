package com.melnikov.MyThirdTestAppSpringBoot.service;

import com.melnikov.MyThirdTestAppSpringBoot.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ModifyResponseService {
    Response modify(Response response);
}

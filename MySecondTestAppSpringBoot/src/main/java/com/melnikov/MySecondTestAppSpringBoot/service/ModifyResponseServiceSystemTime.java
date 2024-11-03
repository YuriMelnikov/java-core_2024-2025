package com.melnikov.MySecondTestAppSpringBoot.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.melnikov.MySecondTestAppSpringBoot.model.Response;
import com.melnikov.MySecondTestAppSpringBoot.util.DateTimeUtil;

import java.util.Date;


@Service("ModifyResponseServiceSystemTime")
public class ModifyResponseServiceSystemTime implements ModifyResponseService{
    @Override
    public Response modify(Response response) {
        response.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));
        return response;
    }
}

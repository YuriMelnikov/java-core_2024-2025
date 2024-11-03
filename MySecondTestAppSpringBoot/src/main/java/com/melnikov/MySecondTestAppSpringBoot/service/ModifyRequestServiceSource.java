package com.melnikov.MySecondTestAppSpringBoot.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.melnikov.MySecondTestAppSpringBoot.model.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service("ModifyRequestServiceSource")
public class ModifyRequestServiceSource implements ModifyRequestService {
    private static final Logger log = LoggerFactory.getLogger(ModifyRequestServiceSource.class);

    @Override
    public void modify(Request request) {
        String originalSource = request.getSource();
        request.setSource("Melnikov changed source");

        log.info("Modified source from '{}' to '{}'", originalSource, request.getSource());

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);
        new RestTemplate().exchange(
                "http://localhost:8084/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<Void>() {
                }
        );
    }
}
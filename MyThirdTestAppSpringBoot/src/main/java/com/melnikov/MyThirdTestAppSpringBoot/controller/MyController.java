package com.melnikov.MyThirdTestAppSpringBoot.controller;

import com.melnikov.MyThirdTestAppSpringBoot.exception.UnsupportedCodeException;
import com.melnikov.MyThirdTestAppSpringBoot.exception.ValidationFailedException;
import com.melnikov.MyThirdTestAppSpringBoot.model.*;
import com.melnikov.MyThirdTestAppSpringBoot.service.ModifyRequestService;
import com.melnikov.MyThirdTestAppSpringBoot.service.ModifyResponseService;
import com.melnikov.MyThirdTestAppSpringBoot.service.ValidationService;
import com.melnikov.MyThirdTestAppSpringBoot.util.DateTimeUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class MyController {
    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifyOperationUidResponseService") ModifyResponseService modifyResponseService,
                        @Qualifier("ModifyRequestServiceSystemTime") ModifyRequestService modifyRequestService) {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult){

        log.info("Received request: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        log.info("Initial response created: {}", response);

        try {
            if (bindingResult.hasErrors()) {
                log.error("BindingResult has errors: {}", bindingResult.getAllErrors());
                throw new ValidationFailedException("Validation failed", "ValidationFailedException");
            }

            if(request.getUid().equals("123")){
                log.info("Unsupported UID detected: {}", request.getUid());
                throw new UnsupportedCodeException("Uid = 123 не поддерживается");
            }
            log.info("Validating request...");
            validationService.isValid(bindingResult);
            if (bindingResult.hasErrors()) {
                log.info("Validation errors detected: {}", bindingResult.getAllErrors());
            }
        } catch (UnsupportedCodeException e){
            log.error("UnsupportedCodeException: {}", e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.info("Response modified after UnsupportedCodeException: {}", response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (ValidationFailedException e){
            log.error("ValidationFailedException: {}", e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.info("Response modified after ValidationFailedException: {}", response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            log.error("Unexpected error: {}", e.getMessage(), e);
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.info("Response modified after unexpected error: {}", response);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        modifyRequestService.modify(request);
        //log.info("Final response: {}", response);
        //log.info("Final request: {}", request);
        //modifyResponseService.modify(response);
        //modifyRequestService.modify(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

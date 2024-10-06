package com.melnikov.MySecondTestAppSpringBoot.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @NotBlank
    @Size(max = 32, message = "Длина не может превышать 32 символа")
    private String uid;

    @NotBlank
    @Size(max = 32, message = "Длина не может превышать 32 символа")
    private String operationUid;

    @NotBlank
    private String systemName;

    private String systemTime;
    private String source;

    @Min(value = 1, message = "Минимальное значение — 1")
    @Max(value = 100000, message = "Максимальное значение — 100000")
    private int communicationId;

    private int templateId;
    private int productCode;
    private int smsCode;
}

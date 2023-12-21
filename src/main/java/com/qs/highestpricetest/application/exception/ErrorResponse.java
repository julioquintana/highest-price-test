package com.qs.highestpricetest.application.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private List<String> errors;
}

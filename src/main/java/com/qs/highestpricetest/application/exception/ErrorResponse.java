package com.qs.highestpricetest.application.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qs.highestpricetest.infrastructure.util.Mapper;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorResponse extends Mapper {
    private int status;
    private List<String> errors;

    @Override
    public String toString() {
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

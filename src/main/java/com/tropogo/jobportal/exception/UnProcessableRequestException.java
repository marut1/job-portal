package com.tropogo.jobportal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnProcessableRequestException extends Exception{

    private static final long serialVersionUID = 1L;

    public UnProcessableRequestException(String message) {
        super(message);
    }
}

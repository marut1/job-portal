package com.tropogo.jobportal.exception;

import java.util.Date;

public class ErrorResponse {
    private Date timestamp;
    private String message;
    private String details;
    private int errorCode;

    public ErrorResponse(Date timestamp, String message, String details, int errorCode) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.errorCode = errorCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
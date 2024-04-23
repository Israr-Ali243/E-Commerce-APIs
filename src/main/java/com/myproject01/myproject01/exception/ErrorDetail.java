package com.myproject01.myproject01.exception;

import java.time.LocalDateTime;

public class ErrorDetail {
    private LocalDateTime localDateTime;
    private String message;
    private String details;

    public ErrorDetail(LocalDateTime localDateTime, String message, String details) {
        this.localDateTime = localDateTime;
        this.message = message;
        this.details = details;
    }

    public ErrorDetail() {
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ErrorDetail{" +
                "localDateTime=" + localDateTime +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}

package com.javacourse.javacourse.models;

import java.util.Date;

public class Error {
    private String message;
    private String error;
    private int status;
    private Date timestamp;

    // Constructor

    public Error(String message, String error, int status, Date timestamp) {
        this.message = message;
        this.error = error;
        this.status = status;
        this.timestamp = timestamp;
    }

    // Getters and setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

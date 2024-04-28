package com.javacourse.javacourse.exceptions;

import com.javacourse.javacourse.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<Error> divisionByZero(Exception ex) {
        Error error = new Error(
                ex.getMessage(),
                "500 - Division by zero",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    // Take care of using @ResponseStatus because it applies in Spring, not Java
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, Object>> numberFormatExceptionHandler(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("message", ex.getMessage());
        error.put("error", "500 - Bad Request");
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("timestamp", new Date());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundException(Exception ex) {
        Error error = new Error(
                ex.getMessage(),
                "404 - Not Found Exception",
                HttpStatus.NOT_FOUND.value(),
                new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    @ExceptionHandler(NullPointerException.class)
    // Take care of using @ResponseStatus because it applies in Spring, not Java
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> nullPointerException(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("message", ex.getMessage());
        error.put("error", "500 - Null Pointer Exception");
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("timestamp", new Date());
        return error;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> userNotFoundException(Exception ex) {
        Error error = new Error(
                ex.getMessage(),
                "404 - User Not Found Exception",
                HttpStatus.NOT_FOUND.value(),
                new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }
}

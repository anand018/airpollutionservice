package com.airpollution.core.exception.handler;

import com.airpollution.core.error.Error;
import com.airpollution.core.exception.AirVisualServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(AirVisualServiceException.class)
    public ResponseEntity<Object> airVisualExceptionHandler() {

        Error error = new Error();
        error.setErrorCode(100);
        error.setMessage("Downstream service error");
        error.setTime(LocalDateTime.now());
        ResponseEntity<Object> responseEntity = new ResponseEntity(error,HttpStatus.BAD_REQUEST);

        return responseEntity;
    }
}

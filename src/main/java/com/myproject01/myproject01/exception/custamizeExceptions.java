package com.myproject01.myproject01.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDateTime;

@ControllerAdvice
public class custamizeExceptions extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(Exception.class)
// public final ResponseEntity<Object>  handlException(Exception ex, WebRequest request) throws  Exception{
//
//        ErrorDetail errorDetail = new ErrorDetail(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
//
//        return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
//  }


    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Object>  handlUserNotFoundException(Exception ex, WebRequest request) throws  Exception{

        ErrorDetail errorDetail = new ErrorDetail(LocalDateTime.now(),  ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ErrorDetail errorDetail = new ErrorDetail(LocalDateTime.now(),((FieldError)ex.getFieldError()).getDefaultMessage() , request.getDescription(false));

        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }
}

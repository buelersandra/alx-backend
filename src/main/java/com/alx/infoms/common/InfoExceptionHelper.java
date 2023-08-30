package com.alx.infoms.common;

import com.alx.infoms.dto.BaseResponseDTO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.ServletException;
import java.io.IOException;

/** The Class ExceptionHelper. */
@ControllerAdvice
public class InfoExceptionHelper  extends ResponseEntityExceptionHandler {
    /** The Constant LOGGER. */
    private static final Logger LOGGERLOGS = LoggerFactory.getLogger(InfoExceptionHelper.class);


    @ExceptionHandler (value = { UserNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleUserNotFoundException(
            UserNotFoundException ex) {
        return new ResponseEntity<>(new BaseResponseDTO<Object>(ApiPaths.FAILED_MSG,ex.getMessage()), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler (value = { InvalidFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleInvalidFormatException(
            InvalidFormatException ex) {
        LOGGERLOGS.error("InvalidFormatException", ex);
        return new ResponseEntity<>(new BaseResponseDTO<Object>(ApiPaths.FAILED_MSG,ex.getMessage()), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = { JsonParseException.class, IllegalArgumentException.class, PropertyReferenceException.class })
    public ResponseEntity<Object> handleException(Exception ex) {
        LOGGERLOGS.error("Exception", ex);
        return new ResponseEntity<Object>(new BaseResponseDTO<Object>(ApiPaths.FAILED_MSG,ex.getMessage()), HttpStatus.BAD_REQUEST);
    }




    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOGGERLOGS.error("HttpMessageNotReadableException", ex);
        return new ResponseEntity<>(new BaseResponseDTO<Object>(ApiPaths.FAILED_MSG,ex.getMessage()), HttpStatus.BAD_REQUEST);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOGGERLOGS.error("MethodArgumentNotValidException", ex);
        return new ResponseEntity<>(new BaseResponseDTO<Object>(ApiPaths.FAILED_MSG,ex.getBindingResult().getAllErrors().get(0).getDefaultMessage()), HttpStatus.BAD_REQUEST);

    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOGGERLOGS.error("HttpRequestMethodNotSupportedException", ex);
        return new ResponseEntity<Object>(HttpStatus.METHOD_NOT_ALLOWED);
    }


}

package com.playground.oauth2.authorizationserver;

import org.springframework.http.HttpStatus;
import org.springframework.security.jwt.crypto.sign.InvalidSignatureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({InvalidSignatureException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleInvalidSignatureException(InvalidSignatureException ex) {
        //must log exception msg or something useful
        return "RSA Signature did not match content";
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public String handleExceptionLoggingFilter(Exception ex) {
        //must log exception msg or something useful
        return ex.getMessage();
    }

}

package com.sachet.AuthService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Email Already in Use, please try with different Email!")
public class EmailAlreadyInUse extends RuntimeException{

  private final HttpStatusCode status;
  private final String errorMessage;
  public EmailAlreadyInUse(String message, HttpStatusCode status) {
    super(message);
    this.errorMessage = message;
    this.status = status;
  }

  public Integer getStatus() {
    return status.value();
  }


  public String getErrorMessage() {
    return errorMessage;
  }
}

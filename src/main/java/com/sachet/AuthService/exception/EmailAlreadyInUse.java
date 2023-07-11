package com.sachet.AuthService.exception;

import org.springframework.http.HttpStatusCode;

public class EmailAlreadyInUse extends RuntimeException{

  private final HttpStatusCode status;
  public EmailAlreadyInUse(String message, HttpStatusCode status) {
    super(message);
    this.status = status;
  }

  public HttpStatusCode getStatus() {
    return status;
  }
}

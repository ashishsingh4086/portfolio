package com.ashish.portfolio.common.core.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class EndPointResponse<T> {

  private ResponseEntity<T> entity;
  private T response;
  private HttpStatus status;

  public EndPointResponse(T response, HttpStatus status) {
    this.response = response;
    this.status = status;
  }

  public EndPointResponse(HttpStatus status) {
    this.status = status;
  }

  public T getResponse() {
    return response;
  }

  public void setResponse(T response) {
    this.response = response;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }
}

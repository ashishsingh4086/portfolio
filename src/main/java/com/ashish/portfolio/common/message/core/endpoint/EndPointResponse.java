package com.ashish.portfolio.common.message.core.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class EndPointResponse<T> {

    public  static<T> ResponseEntity<T> getSuccessStatus(T body) {
        return new ResponseEntity<T>(body, HttpStatus.valueOf(HttpStatus.OK.value()));
    }

    public  static<T> ResponseEntity<T> getSuccessStatus() {
        return new ResponseEntity<T>(HttpStatus.valueOf(HttpStatus.OK.value()));
    }

    public static<T> ResponseEntity<T> getBadRequestStatus(T body) {
        return new ResponseEntity<T>(body, HttpStatus.valueOf(HttpStatus.BAD_REQUEST.value()));
    }

}

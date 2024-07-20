package com.bravuthon.skillmatrix.exception;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException() {}

    public NoDataFoundException(String message) {
        super(message);
    }

    public NoDataFoundException(String message, Throwable cause) {
        super(message, cause);
    }


}

package com.board.global.exception.user;

public class UserNotFoundException extends IllegalArgumentException{

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String s) {
        super(s);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}

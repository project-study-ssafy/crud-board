package com.board.global.exception.user;

public class DuplicatedLoginIdException extends IllegalArgumentException{
    public DuplicatedLoginIdException() {
        super();
    }

    public DuplicatedLoginIdException(String s) {
        super(s);
    }

    public DuplicatedLoginIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicatedLoginIdException(Throwable cause) {
        super(cause);
    }
}

package com.board.global.exception.user;

public class DuplicatedNicknameException extends IllegalArgumentException{

    public DuplicatedNicknameException() {
        super();
    }

    public DuplicatedNicknameException(String s) {
        super(s);
    }

    public DuplicatedNicknameException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicatedNicknameException(Throwable cause) {
        super(cause);
    }
}

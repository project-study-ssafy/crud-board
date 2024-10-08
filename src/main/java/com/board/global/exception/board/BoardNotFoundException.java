package com.board.global.exception.board;

public class BoardNotFoundException extends Exception {

    public BoardNotFoundException() { super(); }

    public BoardNotFoundException(String message) { super(message); }

    public BoardNotFoundException(String message, Throwable cause) { super(message, cause); }
    
    public BoardNotFoundException(Throwable cause) { super(cause); }
}

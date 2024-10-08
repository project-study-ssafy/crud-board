package com.board.global.exception.reply;

public class ReplyNotFoundException extends Exception {
    public ReplyNotFoundException() { super(); }

    public ReplyNotFoundException(String message) { super(message); }

    public ReplyNotFoundException(String message, Throwable cause) { super(message, cause); }

    public ReplyNotFoundException(Throwable cause) { super(cause); }
}

package com.example.dians_proba.model.exceptions;

public class NotLoggedInException extends RuntimeException{
    public NotLoggedInException() {super("First you must login!");
    }
}

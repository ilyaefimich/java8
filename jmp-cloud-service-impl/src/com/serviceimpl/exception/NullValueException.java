package com.serviceimpl.exception;

/**
 * Custom exception for getSubscriptionByBankCardNumber() method
 */
public class NullValueException extends RuntimeException {

    public NullValueException(String message) {
        super(message);
    }
}


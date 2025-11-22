package com.java.study;

class UnknownException extends RuntimeException {
    public UnknownException(String message) {
        super(message);
    }
}

class UnknownNameException extends Exception {
    public UnknownNameException(String message) {
        super(message);
    }
}

public class CustomException {

    public static void main(String[] args) {
//        throw new UnknownException("Unknownnn Exception");
        try {
            throw new UnknownNameException("Unknownnn Name Exception");
        } catch (UnknownNameException e) {
            throw new RuntimeException(e);
        }
    }

}

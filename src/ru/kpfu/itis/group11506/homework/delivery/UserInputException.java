package ru.kpfu.itis.group11506.homework.delivery;

public class UserInputException extends Exception {

    public UserInputException(String message) {
        super(message);
    }

    public UserInputException(String massage, Exception cause) {

    }
}
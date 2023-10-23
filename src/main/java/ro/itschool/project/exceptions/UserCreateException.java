package ro.itschool.project.exceptions;

public class UserCreateException extends RuntimeException {

    public UserCreateException(String message) {
        super(message);
    }
}
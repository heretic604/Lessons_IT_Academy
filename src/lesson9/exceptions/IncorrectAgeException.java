package lesson9.exceptions;

public class IncorrectAgeException extends Exception {

    private String message;

    public IncorrectAgeException() {
        this.message = "Вы слишком молоды для пива";
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

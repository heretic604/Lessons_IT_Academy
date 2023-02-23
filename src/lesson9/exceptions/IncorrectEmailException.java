package lesson9.exceptions;

public class IncorrectEmailException extends Exception {

    private String message;

    public IncorrectEmailException() {
        this.message = "Неверный email";
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package lesson9.exceptions;

public class OutOfStorageException extends Exception {

    private String message;

    public OutOfStorageException() {
        this.message = "У нас нет столько пива";
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}

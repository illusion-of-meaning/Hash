package exceptions;

public class IllegalProductException extends RuntimeException{
    public IllegalProductException() {
    }

    public IllegalProductException(String message) {
        super(message);
    }
}

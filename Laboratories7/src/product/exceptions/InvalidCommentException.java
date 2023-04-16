package product.exceptions;

public class InvalidCommentException extends Exception {

    public InvalidCommentException() {
        super("Invalid comment");
    }

    public InvalidCommentException(String message) {
        super(message);
    }
}

package product.exceptions;

public class InvalidPriceException extends Exception {

    public InvalidPriceException() {
        super("Invalid price");
    }

    public InvalidPriceException(String message) {
        super(message);
    }

}
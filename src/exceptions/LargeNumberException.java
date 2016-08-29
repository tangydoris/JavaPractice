package src.exceptions;

/**
 * Exception thrown when {@link Integer#MAX_VALUE} or {@link Integer#MIN_VALUE} hsa been surpassed and overflow or
 * underflow occurs.
 */
public class LargeNumberException extends RuntimeException {

    public LargeNumberException(final String message) {
        super(message);
    }

    public LargeNumberException() {
        super("Maximum or minimum Integer supported reached.");
    }

}
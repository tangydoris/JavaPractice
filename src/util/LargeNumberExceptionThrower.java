package src.util;

import src.exceptions.LargeNumberException;

import java.util.logging.Logger;

/**
 * This class throws a {@link LargeNumberException} with the name of the calling class in the logged message.
 */
public class LargeNumberExceptionThrower {

    public static void throwException(final Logger log) {
        final LargeNumberException exception = new LargeNumberException();
        log.severe(exception.getMessage());
        throw exception;
    }

    public static void throwException(final Logger log, final String message) {
        final LargeNumberException exception = new LargeNumberException(message);
        log.severe(exception.getMessage());
        throw exception;
    }
}

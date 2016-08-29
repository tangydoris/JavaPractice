package src;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.Objects.requireNonNull;

public class BitonicMaxFinder {

	/*
	 * Find a maximum in a bitonic array.
	 * eg 1 2 3 4 5 4 3 2 1 
	 * output 5.
	 */

	/*
     * Method 1
	 * Iterate through the array and compare each integer with
	 * the one to the right of it
	 * If it is larger, increment the pointer
	 * If it is smaller, we found our maximum
	 * Stop the pointer when we have reached the end of the array
	 * or when we have found our maximum
	 * (to take care of arrayindexoutofbounds exception)
	 */

	private static Logger log = Logger.getLogger("BitonicMaxFinder.class");

    public static int findMax(final int[] array) throws IllegalArgumentException {
        requireNonNull(array);

        if (array.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two integers.");
        }

        int prev = Integer.MIN_VALUE;
        for (final int i : array) {
            if (prev <= array[i]) {
                prev = array[i];
            } else {
                break;
            }
        }

        System.out.println(prev);
        return prev;
    }

    public static void main(final String[] args) {
        int[] a = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        try {
            findMax(a);
        } catch (RuntimeException e) {
            log.log(Level.WARNING, "Could not run findMax(int[]).", e);
        }
    }

}

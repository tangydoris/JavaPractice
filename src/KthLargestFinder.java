package src;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

/**
 * Finder for the Kth largest integer in an unsorted array.
 *
 * Created by DTang on 9/6/16.
 */
public class KthLargestFinder {

    public static int findKthLargest(final int[] array, final int k) {
        // input validation
        requireNonNull(array);

        if (k >= array.length) {
            throw new IllegalArgumentException("K cannot be greater than the input array size.");
        }

        final Map<Integer, Map<Integer, Boolean>> encounteredMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            final int element = array[i];

            encounteredMap.computeIfAbsent(element, map -> new HashMap<>());
            final Map<Integer, Boolean> currentEncounteredMap = encounteredMap.get(element);

            int numberOfElementsGreater = 0;

            // look for previously compared elements
            for (final int encounteredSoFar : encounteredMap.keySet()) {
                // subsequent elements must appear as a key in the value of the current entry since we are processing
                // the array elements in order
                final Map<Integer, Boolean> comparisonMap = encounteredMap.get(encounteredSoFar);
                if (!comparisonMap.isEmpty()) {
                    final boolean isGreater = comparisonMap.get(element);
                    if (!isGreater) {
                        numberOfElementsGreater++;
                    }
                }
            }

            for (int j = i + 1; j < array.length; j++) {
                final int elementCompared = array[j];

                // map comparison of the two elements
                currentEncounteredMap.put(elementCompared, elementCompared > element);
            }

            for (final boolean isGreater : encounteredMap.get(element).values()) {
                if (isGreater) {
                    numberOfElementsGreater++;
                }
            }
            System.out.println(numberOfElementsGreater + " elements greater than " + element);
            if (numberOfElementsGreater == k) {
                return element;
            }
        }

        // can find better way to handle this
        return Integer.MIN_VALUE;
    }

    public static void main(final String[] args) {
        final int[] array = new int[] {5, 3, 9, 1};
        final int k = 0;

        System.out.println(findKthLargest(array, k));
    }

}

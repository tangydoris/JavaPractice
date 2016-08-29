package src;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Logger;

import static java.util.Objects.requireNonNull;
import static src.util.LargeNumberChecker.isOverflowSum;
import static src.util.LargeNumberExceptionThrower.throwException;

public class TwoIntSumFinder {

	/*
     * Given an array of integers & an integer find two numbers
	 * in the array such that they add up to the given integer.
	 * 
	 * a[] = {1,4,3,4,6,3,5}; K=10
	 * output = 4, 6.
	 */

    private static Logger log = Logger.getLogger("TwoIntSumFinder.class");

    public static Addends findSumBySort(final int[] array, final int targetSum) {

        requireNonNull(array);

        if (array.length < 2) {
            throw new IllegalArgumentException("Input array must be of at least length 2.");
        }

        final int[] copy = Arrays.copyOf(array, array.length);

        Arrays.sort(copy);
        int i = 0;
        int j = copy.length - 1;
        while (i < j) {

            final int low = copy[i];
            final int high = copy[j];

            if (isOverflowSum(low, high)) {
                throwException(log);
            }

            final int tempSum = low + high;

            if (tempSum < targetSum) {
                // needs to be larger, increment left pointer
                i++;
            } else if (tempSum > targetSum) {
                // needs to be less, decrement right pointer
                j--;
            } else {
                return new Addends(low, high, targetSum);
            }
        }

        return null;
    }

    /**
     * Retrieves the two numbers in an array that add up to a target sum by hashing. The array is iterated through,
     * and at every new element encountered its complement, or target sum minus that element, is hashed as the key
     * with that element as its value. When that complement is encountered and it is a key in the map, the two
     * addends are found.
     *
     * @param array
     *         array from which to find two addends for a target sum
     * @param targetSum
     *         the target sum
     *
     * @return integer array of size 2 containing the two numbers that add
     */
    public static Addends findSumByHash(final int[] array, final int targetSum) {
        requireNonNull(array);

        if (array.length < 2) {
            throw new IllegalArgumentException("Input array must be of at least length 2.");
        }

        final int[] copy = Arrays.copyOf(array, array.length);

        final Map<Integer, Integer> table = new Hashtable<>();

        for (final int i : copy) {
            if (isOverflowSum(targetSum, -i)) {
                throwException(log);
            }
            final int complement = targetSum - i;

            if (table.containsKey(complement)) {
                return new Addends(complement, i, targetSum);
            } else {
                table.put(complement, i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 1, 4, 1, 9, 6, 1, 1, 3, 1};

        final Addends answer1 = findSumBySort(null, 5);
        System.out.println(answer1);

        final Addends answer2 = findSumByHash(a, 5);
        System.out.println(answer2);
    }

    private static class Addends {

        private final int addend1;

        private final int addend2;

        private final int sum;

        public Addends(final int addend1, final int addend2, final int sum) {
            if (isOverflowSum(addend1, addend2)) {
                throwException(log);
            }

            if (addend1 + addend2 != sum) {
                throw new IllegalArgumentException("Two addends do not add up to the target sum: "
                        + addend1
                        + " + "
                        + addend2
                        + " != "
                        + sum);
            }

            this.addend1 = addend1;
            this.addend2 = addend2;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Addends{" +
                    "addend1=" + addend1 +
                    ", addend2=" + addend2 +
                    ", sum=" + sum +
                    '}';
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Addends addends = (Addends) o;

            return addend1 == addends.addend1 && addend2 == addends.addend2 && sum == addends.sum;

        }

        @Override
        public int hashCode() {
            int result = addend1;
            result = 31 * result + addend2;
            result = 31 * result + sum;
            return result;
        }
    }

}


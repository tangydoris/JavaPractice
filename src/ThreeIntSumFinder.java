package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.logging.Logger;

import static src.util.LargeNumberChecker.isOverflowSum;
import static src.util.LargeNumberExceptionThrower.throwException;

public class ThreeIntSumFinder {

	/*
	 * Given an array of integers & an integer find three numbers in the array 
	 * such that they add up to the given integer.
	 * 
	 * a[] = {1,4,3,4,6,3,5}; K=14
	 * output = 4, 4, 6.
	 */

	/*
     * Method one:
	 * brute force, iterate through array to test every possible combination
	 * of three ints that add up to the sum
	 */

	/*
	 * Method two:
	 * sort then use three pointers
	 * one starting from left moving to the right, one from right moving to the left
	 * one in the middle that starts from the left that moves to the right
	 * if the sum is too big, move right pointer to the left
	 * if sum is too small, move the middle pointer to the right
	 * when these pointers cross, move the left pointer to the right and reset the other two
	 * (all the way at the end and one to the right of that leftmost one)
	 */

    // implement method two first
	
	/*
	 * given an array, want to find the three numbers that form a right triangle
	 * solve using implemented method
	 */


    private static Logger log = Logger.getLogger("ThreeIntSumFinder.class");

    public static Triplet findThreeAddends(final int[] array, final int targetSum) {
        if (array == null || array.length < 3) {
            throw new IllegalArgumentException("Input array cannot be null and must contain at least 3 integers.");
        }

        final int[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);

        for (int lowerBound = 0; lowerBound < copy.length - 2; lowerBound++) {
            final int lowest = copy[lowerBound];

            if (isOverflowSum(targetSum, -lowest)) {
                throwException(log);
            }
            final int localTargetSum = targetSum - lowest;

            int upperBound = copy.length - 1;
            int middleIndex = lowerBound + 1;

            while (middleIndex < upperBound) {
                final int middle = copy[middleIndex];
                final int highest = copy[upperBound];

                if (isOverflowSum(middle, highest)) {
                    throwException(log);
                }

                final int localSum = middle + highest;
                if (localSum < localTargetSum) {
                    middleIndex++;
                } else if (localSum > localTargetSum) {
                    upperBound--;
                } else {
                    return new Triplet(lowest, middle, highest, targetSum);
                }
            }
        }

        return null;
    }

    /*
     * Find integers that can make up the sides of a right triangle
     * Square all numbers in array
     */
    public static Triplet findPythagoreanTriplets(final int[] array) {
        final int maxRoot = (int) Math.sqrt(Integer.MAX_VALUE);

        // only process positive integers in the input array that are less than the square root of the maximum integer
        ArrayList<Integer> copy = new ArrayList<>(array.length);
        for (final int i : array) {
            if (i > 0 && i < maxRoot) {
                copy.add(i * i);
            }
        }

        Collections.sort(copy);

        Triplet out = null;
        final int targetSum = 0;
        for (int i = copy.size() - 1; i > 0; i--) {

            if (out != null) {
                int addend1 = getSquareRootOfMagnitude(out.getTriplet1());
                int addend2 = getSquareRootOfMagnitude(out.getTriplet2());
                int addend3 = getSquareRootOfMagnitude(out.getTriplet3());
                return new Triplet(addend1, addend2, addend3, targetSum);
            }

            final int[] temp = new int[copy.size()];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = copy.get(j);
            }
            temp[i] *= -1;
            out = findThreeAddends(temp, targetSum);
        }

        return null;
    }

    private static int getSquareRootOfMagnitude(final int x) {
        final int magnitude = Math.abs(x);
        return (int) Math.sqrt(magnitude);
    }

    public static void main(String[] args) {
        final int[] input = {1, 3, 4, 3, 5, 9, 10, 16, 25, 20, 15};
        final int sum = 14;

        final Triplet addends1 = findThreeAddends(input, sum);
        if (addends1 == null) {
            System.out.println("Could not find three addends for the sum " + sum);
        } else {
            System.out.println(addends1.toString());
        }

        final Triplet addends2 = findPythagoreanTriplets(input);
        if (addends2 == null) {
            System.out.println("Could not find pythagorean triplets in array.");
        } else {
            System.out.println("Found pythagorean triplets: "
                    + addends2.getTriplet1()
                    + ", "
                    + addends2.getTriplet2()
                    + ", "
                    + addends2.getTriplet3());
        }
    }

    private static class Triplet {

        private final int triplet1;

        private final int triplet2;

        private final int triplet3;

        private final int sum;

        public Triplet(final int triplet1, final int triplet2, final int triplet3, final int sum) {
            if (isOverflowSum(triplet1, triplet2, triplet3)) {
                throwException(log);
            }

            this.triplet1 = triplet1;
            this.triplet2 = triplet2;
            this.triplet3 = triplet3;
            this.sum = sum;
        }

        public int getTriplet1() {
            return triplet1;
        }

        public int getTriplet2() {
            return triplet2;
        }

        public int getTriplet3() {
            return triplet3;
        }

        public int getSum() {
            return sum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Triplet triplet = (Triplet) o;
            return triplet1 == triplet.triplet1 &&
                    triplet2 == triplet.triplet2 &&
                    triplet3 == triplet.triplet3 &&
                    sum == triplet.sum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(triplet1, triplet2, triplet3, sum);
        }

        @Override
        public String toString() {
            return "Triplet{" +
                    "triplet1=" + triplet1 +
                    ", triplet2=" + triplet2 +
                    ", triplet3=" + triplet3 +
                    ", sum=" + sum +
                    '}';
        }
    }

}

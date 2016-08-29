package src;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import static src.util.LargeNumberExceptionThrower.throwException;

public class MajorityFinder {

	/*
	 * Given an array of size n, find the majority element.
	 * The majority element is the element that appears more than ⌊ n/2 ⌋ times. 
	 * (assume that the array is non-empty and the majority element always exist in the array.)
	 */

	/*
	 * Method 1:
	 * Keep HashMap (because HashTable is synchronized and is slower)
	 * 	where key is integer in array and value is its frequency
	 * Return the key from hashmap occurs whose value is greater than n/2
	 * O(n)
	 */
	
	/*
	 * Method 2:
	 * Sort array
	 * Iterate through array and keep count of the frequency of the current integer
	 * When frequency reaches n/2, return the current integer
	 * O(nlogn)
	 */
	
	/*
	 * Method 3:
	 * The majority element must be one away from or at the midpoint of the sorted array
	 * Sort array
	 * Inspect the integer at index floor of n/2
	 * 	if array has odd length then return integer at index floor of n/2, +1
	 * 	if array has even length, see if integers at indices n/2 and n/2 -1 are equals
	 * 		if they are, return integer
	 * 		if they arent, there is no majority element
	 */
	
	/*
	 * Method 4:
	 * Median of medians (research) O(n):
	 * find median, iterate through array to check frequency of median
	 * if there are two medians then there is no majority anyway
	 */
	
	/*
	 * Method 5:
	 * Moore's Voting Algorithm
	 * keep counts of majority index and count
	 * WRITE PERFECT CODE FOR THIS
	 * O(n)
	 */
	
	/*
	 * Method 6:
	 * probability (randomized)
	 * Choosing an eleent at random, we have a 50% chance of getting it right
	 * (if there does exist a majority element).
	 * Should we take in the probability that there is no majority element?
	 * (does this even matter?)
	 * We assume that there is always a majority element in the array
	 * 
	 * WRITE CODE
	 * O(n)
	 */

    // FOUR MORE METHODS THAT REQUIRE OUT OF THE BOX THINKING
	
	/*
	 * Method 7:
	 * 
	 */

    private static Logger log = Logger.getLogger("MajorityFinder.class");

    public static int probabilityMethod(int[] a, int tries) {
        // We do not use this way of calculating probability because
        // of possible overflow
        //double probability = 1/(Math.pow(2, tries);
        Map<Integer, Integer> map = new HashMap<>();
        double probability = 1d;

        for (int i = 0; i < tries; i++) {
            Random random = new Random();
            int index = random.nextInt(a.length);
            int elem = a[index];
            if (map.containsKey(elem)) {
                if (map.get(elem) + 1 < 0) {
                    throwException(log);
                }
                map.put(elem, map.get(elem) + 1);
            } else {
                map.put(elem, 1);
            }

            probability /= 2;
        }
        probability = 100 * (1d - probability);

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        Map.Entry<Integer, Integer> entry = iterator.next();
        int majority = entry.getKey();
        int count = entry.getValue();
        while (iterator.hasNext()) {
            entry = iterator.next();
            if (entry.getValue() > count) {
                count = entry.getValue();
                majority = entry.getKey();
            }
        }

        System.out.println("The majority element is " + majority + " with " + probability + "% chance of"
                + " being correct");
        return majority;
    }

    public static int mooreVoting(int[] a) {
        int majIndex = 0;
        int count = 1;
        for (int i = 1; i < a.length; ++i) {
            if (a[i] != a[majIndex]) {
                --count;
            } else {
                ++count;
            }
            if (count == 0) {
                count = 1;
                majIndex = i;
            }
        }
        return majIndex;
    }

    public static int mooresAlgorithm(int[] a) {
        int majIndex = 0;
        int count = 0;

        // iterate through array to find possible majority
        for (int i = 1; i < a.length; i++) {
            count++;
            if (a[i] != a[majIndex]) {
                count--;
                majIndex = i;
            } else {
                if (count + 1 < 0) {
                    throwException(log);
                }
                count++;
            }

        }

        // scan array for correctness
        int elementsNeeded = (int) Math.floor(a.length / 2);
        int elements = 0;
        for (final int i : a) {
            if (i == a[majIndex]) {
                elements++;
            }
        }

        if (elements > elementsNeeded) {
            System.out.println(a[majIndex]);
            return a[majIndex];
        }
        // The following depends on the function of the application.
        // One possible way to handle an array with no majority element is
        // to throw an exception.
        else {
            log.severe("No majority element in array");
            throw new NoMajorityException("No majority element in array");
        }

    }

    public static void main(String[] args) {
        int[] a = {1, 6, 3, 6, 6, 3, 4, 6, 6, 6, 1, 3, 6, 6, 6, 6, 8, 2, 4, 5, 6, 6, 6, 1, 2, 5, 6, 6, 6};
        mooresAlgorithm(a);
        probabilityMethod(a, 10);
    }

    public static class NoMajorityException extends RuntimeException {
        public NoMajorityException() {
            super();
        }

        public NoMajorityException(String msg) {
            super(msg);
        }
    }
}
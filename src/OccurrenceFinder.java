package src;

import src.exceptions.LargeNumberException;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class OccurrenceFinder {

	
	/*
     * #1
	 * Given an array of integers & an integer find the number of occurrences 
	 * of that integer and display the results.
	 * 
	 * a[] = {1,4,3,4,6,3,5}; K=3
	 * output = 2. 
	 */

    // Hashtable is synchronized, slower (have to access the lock then unlock it)
    // Always put interface in front

    private static Map<int[], Map<Integer, Integer>> map = new HashMap<>();
    private static Logger logger = Logger.getLogger("OccurrenceFinder.class");

    public static int getOccurrence(int[] array, int num) {
        if (array == null || array.length == 0) {
            return 0;
        }

        if (array.length >= Math.pow(2, 64)) {
            System.out.println("cannot handle array of that size");
            return 0;
        }

        if (!map.containsKey(array)) {
            Map<Integer, Integer> newTable = new HashMap<>();
            // Hash number of occurrences to the occurring value
            for (final int i : array) {
                if (!newTable.containsKey(i)) {
                    newTable.put(i, 1);
                } else {
                    if (newTable.get(i) + 1 > 0) {
                        newTable.put(i, newTable.get(i) + 1);
                    } else {
                        logger.severe("Maximum number of occurrences for integer reached");
                        throw new LargeNumberException("Maximum number of occurrences for integer reached");
                    }
                }
            }

            map.put(array, newTable);
        }

        Map<Integer, Integer> table = map.get(array);
        if (table.containsKey(num)) {
            System.out.println(table.get(num));
            return table.get(num);
        } else {
            System.out.println("0");
            return 0;
        }
    }


    public static void main(String[] args) {
        int[] a1 = {1, 1, 2, 4, 5, 2, 35, 52, 2, 3};
        int[] a2 = {3, 3, 3, 3, 3, 3, 5};
        getOccurrence(a1, 1);
        getOccurrence(a1, 4);
        getOccurrence(a2, 3);
    }
}


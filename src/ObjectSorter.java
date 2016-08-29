package src;


import java.util.Arrays;

import static java.util.Objects.requireNonNull;
import static src.util.ArrayPrinter.printArray;

public class ObjectSorter {

	/*
	 * Given `N' objects Numbered 0, 1 or 2, sort them so that objects of the same 
	 * numbers are adjacent, with the numbers in the sorted order.
	 * For e.g.
	 * input
	 * 1,2,0,1,2,2,1,0
	 * output
	 * 0,0,1,1,1,2,2,2
	 */

	/*
     * Method one:
	 * Counting sort (Counting Algorithm)
	 * keep array of size 3
	 * increment each index according to whether we encounter a 0,1 or 2
	 */
	
	/*
	 * Method two:
	 * Keep three pointers in the array
	 * One pointer (left) starts at the first index, another (right) starts at the last
	 * Middle pointer starts also at the first index
	 *
	 * The left pointer indicates where the subset of sorted low elements should end
	 * The middle pointer indicates where the subset of sorted middle elements should begin
	 * The right pointer indicates where the subset of sorted high elements should begin
	 *
	 * Look at the element at the middle pointer. If it is low, swap it with the element at the low pointer index and
	 * advance both the low and middle pointers. If it is a middle element, it is in place so simply advance the
	 * middle pointer. If it is a high element, swap it with the element at the high pointer index and decrement the
	 * high pointer.
	 *
	 * CODE THIS
	 */

    public static int[] sortWith3Pointers(final int[] array) {
        requireNonNull(array);

        final int[] copy = Arrays.copyOf(array, array.length);

        // no need to sort anything for an empty array or array of one element
        if (copy.length == 0 || copy.length == 1) {
            return copy;
        }

        int low = 0;
        int mid = 0;
        int high = copy.length - 1;
        // used for swapping elements in the array
        int temp;

        while (mid <= high) {
            switch (copy[mid]) {

                case 0:
                    // low object encountered: swap with element at the lowest pointer index and advance the lowest and
                    // middle pointers
                    temp = copy[low];
                    copy[low] = copy[mid];
                    copy[mid] = temp;
                    low++;
                    mid++;
                    break;

                case 1:
                    // middle object encountered: element is already is already in place, advance middle pointer
                    mid++;
                    break;

                case 2:
                    // high object encountered: swap with element at the highest pointer index and decrement the
                    // highest pointer. Do not advance the middle pointer here since we are not sure if the element
                    // we just swapped into the middle index is low, medium, or high.
                    temp = copy[mid];
                    copy[mid] = copy[high];
                    copy[high] = temp;
                    high--;
                    break;
            }
        }

        return copy;
    }

    public static void main(String[] args) {
        final int[] a = {0, 2, 1, 0, 1, 1, 0, 0, 0, 2, 2};
        printArray(a);

        final int[] sorted = sortWith3Pointers(a);
        printArray(sorted);
    }

}
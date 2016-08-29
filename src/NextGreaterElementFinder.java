package src;

public class NextGreaterElementFinder {

	/*
	 * Given an array, print the Next Greater Element (NGE) for every element. 
	 * The Next greater Element for an element x is the first greater element 
	 * on the right side of x in array. Elements for which no greater element 
	 * exist, consider next greater element as -1.
	 *
	 * Examples:
	 * For any array, rightmost element always has next greater element as -1.
	 * For an array which is sorted in decreasing order, all elements have 
	 * next greater element as -1.
	 * For the input array {4, 5, 2, 25}, the next greater elements for 
	 * each element are as follows.{5,25,25,-1}
	 */

	/*
	 * Method 1
	 * Create array of the same size (output array)
	 * Have one pointer pointing to end of the input array (current number)
	 * Have one pointer pointing to end of the output array
	 * Keep track of the current next greater number which starts at -1
	 * 	(for the last integer in the input array)
	 * and the next number in the array which is initialized to the minimum integer
	 * If the current number is less than or equal to the next number
	 * 	set the next greater number to the next number
	 * Set the position at the pointer in the output array to the next greater number
	 * Continue until we reach the first element in the array
	 */

    public static int[] computeNextGreater(int[] a) {
        // print input
        for (final int i : a) {
            System.out.println(i + "\t");
        }
        System.out.println("");

        int[] out = new int[a.length];
        int nextInt = Integer.MIN_VALUE;
        int nextGreater = -1;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] <= nextInt) {
                nextGreater = nextInt;
            }
            nextInt = a[i];
            out[i] = nextGreater;
        }

        // print output
        for (final int i : a) {
            System.out.print(i + "\t");
        }

        return out;
    }

    public static void main(String[] args) {
        int[] a = {-100, 0, 55, 57, 1, 7, 10, 3, 2, 1, 7, 3};
        computeNextGreater(a);
    }

}

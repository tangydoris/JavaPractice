
public class LargestProductFinder {
	
	/*
	 * #7
	 * Find the product of contiguous subarray within a one-dimensional 
	 * array of numbers which has the largest product.
	 * For eg: {2,4,-4,2,5}
	 * Output 10.
	 */
	
	/*
	 * We know that the magnitude of product can only get larger with each
	 * additional integer we include the in the subarray.
	 * If the subarray contains an even number of negative integers, we 
	 * have a larger product than if it contains an odd number (making the
	 * product negative.
	 * 
	 */
	
	/*
	 * Method one:
	 * brute force
	 * record the product of every subarray
	 * return the largest product
	 */
	
	/*
	 * Method two:
	 * Look at all subarrays that contain only positive integers
	 * Imagine a new array that contains the products of those subarrays
	 * and the negatives left over (now we have an array with alternating
	 * positives and negatives)
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

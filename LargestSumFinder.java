import java.util.logging.Logger;

public class LargestSumFinder {

	/*
	 * Find the sum of contiguous subarray within a one-dimensional array 
	 * of numbers which has the largest sum.
	 *
	 * For eg:
	 * {6, -3, -5, 5, 3}
	 * Output 8
	 */
	
	/*
	 * Method one:
	 * brute force, store all sums of all contiguous subarrays
	 * fetch the largest sum from the recorded sums
	 */
	
	/*
	 * Method two:
	 * Keep references to current sum and largest sum
	 * Start from beginning of the array with a subarray length 1
	 * Store that first integer as the current and largest sum
	 * Increase the subarray length by 1 to include the next integer
	 * 	if the sum is positive, store the current sum and update largest sum as necessary
	 * 	if the sum is negative, start looking at the subarray of 1 element that starts
	 * 	1 index to the right of the end of the first one
	 * 
	 * O(n)
	 */
	
	static Logger logger = Logger.getLogger("LargestSumFinder.class");
	
	public static int findLargestSum(int[] a) {
		if (a == null) {
			System.out.println("cannot find sum for null array");
			return 0;
		}
		if (a.length == 0) {
			System.out.println("0");
			return 0;
		}
		
		int currentSum = 0;
		int largestSum = 0;
		
		for (int i = 0; i < a.length; i ++) {
			
			if ((currentSum+a[i]) >= Math.pow(2, 64)-1) {
				logger.severe("Maximum integer sum that can be supported reached");
				throw new LargeNumberException("Maximum integer sum that can be supported reached");
			}
			
			currentSum += a[i];
			
			if (largestSum < currentSum)
				largestSum = currentSum;
			
			if (currentSum <= 0)
				currentSum = a[i];
		}
		
		System.out.println(largestSum);
		return largestSum;
	}
	
	public static void main(String[] args) {
		int[] a = {6, -1, -2, 5, 3};
		findLargestSum(a);
	}

}

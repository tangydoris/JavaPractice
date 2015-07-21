import java.util.logging.Logger;

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
	 * Keep track of the current product, global maximum product,
	 * 	current maximum product, current minimum product
	 * With this we do not have to keep track of the number of negatives
	 * 	or worry about signs
	 * CODE THIS
	 */
	
	static Logger logger = Logger.getLogger("LargestProductFinder.class");
	
	public static int findLargestProduct(int[] a) {
		// This null case handling depends on what the application calls for
		if (a == null) {
			logger.severe("Input cannot be null.");
			throw new RuntimeException("Input cannot be null.");
		}
		// Also depends on application specs
		if (a.length == 0) {
			logger.severe("Input array cannot be empty");
			throw new RuntimeException("Input array cannot be empty");
		}
		
		int currMax, currMin, globalMax, prevMax, prevMin;
		currMax = currMin = globalMax = prevMax = prevMin = 1;
		for (int i = 0; i < a.length; i++) {
			if (((prevMax > 0 && a[i] > 0) || (prevMax < 0 && a[i] < 0)) & prevMax*a[i] < 0) {
				logger.severe("Maximum integer supported reached.");
				throw new LargeNumberException("Maximum integer supported reached.");
			}
			if (((prevMax > 0 && a[i] < 0) || (prevMax < 0 && a[i] > 0)) & prevMax*a[i] > 0) {
				logger.severe("Minimum integer supported reached.");
				throw new LargeNumberException("Minimum integer supported reached.");
			}
				
			currMax = Math.max(Math.max(a[i], prevMax*a[i]), prevMin*a[i]);
			currMin = Math.min(Math.min(a[i], prevMax*a[i]), prevMin*a[i]);
			globalMax = Math.max(globalMax, currMax);
			prevMax = currMax;
			prevMin = currMin;
		}
		System.out.println(globalMax);
		return globalMax;
	}

	public static void main(String[] args) {
		int[] a = {1,0,-7,-4,0,4,5,-2,3,1,5};
		findLargestProduct(a);
	}

}

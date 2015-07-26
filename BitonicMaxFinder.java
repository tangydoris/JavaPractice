
public class BitonicMaxFinder {

	/*
	 * #11
	 * Find a maximum in a bitonic array.
	 * eg 1 2 3 4 5 4 3 2 1 
	 * output 5.
	 */
	
	/*
	 * Method 1
	 * Iterate through the array and compare each integer with
	 * the one to the right of it
	 * If it is larger, increment the pointer
	 * If it is smaller, we found our maximum
	 * Stop the pointer when we have reached the end of the array
	 * or when we have found our maximum
	 * (to take care of arrayindexoutofbounds exception)
	 */
	
	public static int findMax(int[] a) {
		if (a==null)
			throw new NullPointerException("Input cannot be null.");
		if (a.length==0)
			throw new IllegalArgumentException("Array cannot be empty.");
		
		int prev = Integer.MIN_VALUE;
		for (int i=0; i<a.length; i++) {
			if (prev<=a[i]) {
				prev=a[i];
			}
			else
				break;
		}
		
		System.out.println(prev);
		return prev;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 4, 3, 2, 1};
		findMax(a);
	}

}

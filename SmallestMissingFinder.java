import java.util.logging.Logger;

public class SmallestMissingFinder {

	/*
	 * #12
	 * Find the smallest missing number in the sorted array.
	 * eg. 1 2 3 4 5 6 7 9 10 12
	 * output 8.
	 */
	
	/*
	 * Method 1
	 * Iterate through array until you find a number that is
	 * not one greater than the number right before it
	 * take one from the greater number and we have found
	 * our missing number
	 */
	
	/*
	 * Method 2
	 * Iterate through the array and negate the number at the
	 * position one less than the number
	 */
	
	static Logger logger = Logger.getLogger("SmallestMissingFinder.class");
	
	public static int findSmallestMissingBruteForce(int[] a) {
		if (a==null || a.length==0) {
			logger.severe("Invalid input.");
			throw new IllegalArgumentException("Invalid input.");
		}
		
		int out = 1;
		
		for (int i=0; i<a.length-1; i++) {
			if (a[i]!=out) {
				System.out.println(out);
				return out;
			}
			out++;
		}
		
		return out;
	}
	
	public static int findSmallestMissingByIndexing(int[] A) {
		if (A==null || A.length==0) {
			logger.severe("Invalid input.");
			throw new IllegalArgumentException("Invalid input.");
		}
		
		for (int i=0; i<A.length; i++) {
			int indexToNegate;
			if (A[i]<0)
				indexToNegate = (-1*A[i])-1;
			else
				indexToNegate = A[i]-1;
			if (indexToNegate<0 || indexToNegate>=A.length)
				continue;
			A[indexToNegate]*=-1;
		}

		int i=0;
		while (i<A.length) {
			if (A[i]>0) {
				System.out.println(i+1);
				return i+1;
			}
			i++;
		}
		
		System.out.println(i);
		return i;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3, 4, 5, 6, 7, 10, 12};
		findSmallestMissingBruteForce(a);
		findSmallestMissingByIndexing(a);
	}

}

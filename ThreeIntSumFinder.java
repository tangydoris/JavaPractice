import java.util.logging.Logger;

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
	 * if the sum is too big, more right pointer to the left
	 * if sum is too small, move the middle pointer to the right
	 * when these pointers cross, move the left pointer to the right and reset the other two
	 * (all the way at the end and one to the right of that leftmost one)
	 */

	// implement method two first
	
	/*
	 * given an array, want to find the three numbers that form a right triangle
	 * solve using implemented method
	 */
	
	
	static Logger logger = Logger.getLogger("ThreeIntSumFinder.class");
	
	public static void findThreeAddends(int[] a, int s) {
		if (a == null) {
			System.out.println("cannot find addends for null array");
			return;
		}
		if (a.length < 3) {
			System.out.println("array must contain at least three integers");
			return;
		}
		
		int lasti = a.length-1;
		for (int i = 0; i < lasti-1; i++) {
			int ai = Math.abs(a[i]);
			for (int j = i+1, k = lasti; j < k; ) {
				int aj = Math.abs(a[j]);
				int ak = Math.abs(a[k]);
				
				int sum = a[i]+a[j]+a[k];
				int sumij = a[i] + a[j];
				int sumik = a[i] + a[k];
				int sumjk = a[j] + a[k];
				
				// test every possible case for negatives, positives, and integer wrap-around
				// +ai
				if (a[i] > 0) {
					// + ai, +aj
					if (a[j] > 0) {
						if (sumik < 0)
							throwException();
						// +ai, +aj, +ak
						if (a[k] > 0) {
							if (sum < 0 | sumij < 0 | sumjk < 0)
								throwException();
						}
						// +ai, +aj, -ak
						else {
							if (ak < sumij & sum < 0)
								throwException();
						}
					}
					// +ai, -aj
					else {
						if (aj < ai & sumij < 0)
							throwException();
						else if (aj > ai & sumij > 0)
							throwException();
						
						// +ai, -aj, +ak
						if (a[k] > 0) {
							if (sumik < 0)
								throwException();
							else if (aj < ak & sumjk < 0)
								throwException();
						}
						// +ai, -aj, -ak
						else {
							if (sumjk > 0)
								throwException();
							else if (ak < ai & sumik < 0)
								throwException();
							else if (ak > ai & sumij > 0)
								throwException();
						}
					}
						
				}
				//-ai
				else {
					// -ai, +aj
					if (a[j] > 0) {
						if (ai < aj & sumij < 0)
							throwException();
						else if (ai > ai & sumij > 0)
							throwException();
						
						// -ai, +aj, +ak
						if (a[k] > 0) {
							if (sumjk < 0)
								throwException();
							else if (ai < ak & sumij < 0)
								throwException();
							else if (ai < ak & sumij > 0)
								throwException();
						}
						// -ai, +aj, -ak
						else {
							if (sumik > 0)
								throwException();
							else if (ak < aj & sumjk < 0)
								throwException();
							else if (ak < aj & sumjk > 0)
								throwException();
						}
					}
					// -ai, -aj
					else {
						if (sumij > 0)
							throwException();
						
						// -ai, -aj, +ak
						if (a[k] > 0) {
							if (ai < ak & sumik < 0)
								throwException();
							else if (ai > ak & sumik > 0)
								throwException();
							else if (aj < ak & sumjk < 0)
								throwException();
							else if (aj > ak & sumjk > 0)
								throwException();
						}
						// -ai, -aj, -ak
						else {
							if (sum > 0)
								throwException();
						}
					}
				}
				
				// large numbers taken care of
				// onto actual algorithm
				if (sum < s)
					j++;
				else if (sum > s)
					k--;
				
				else {
					// we got it!
					System.out.println(a[i]+" + "+a[j]+" + "+a[k]+" = "+s);
					return;
				}
			}
		}
	}
	
	public static void throwException() {
		logger.severe("Maximum/minimum supported integer reached");
		throw new LargeNumberException("Maximum/minimum supported integer reached");
	}
	
	public static void main(String[] args) {
		int[] a = {1,4,3,4,6,3,5};
		findThreeAddends(a, 14);
	}

}

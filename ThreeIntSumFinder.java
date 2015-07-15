
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

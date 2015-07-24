
public class MissingTwoFinder {
	
	/*
	 * #9
	 * Given an array of number when each number is repeated twice except the two number.
	 * Find the two numbers.
	 * eg: 10 10 12 12 13 12 12 13 6 6 3 4 4 2.
	 * output 3, 2
	 */
	
	/*
	 * XOR together all integers in the array
	 * All duplicates XOR'ed together yield 0 and XOR
	 * is communitive, so we are left with the XOR'ed
	 * value of the two exceptions
	 * We XOR together the numbers where the result's
	 * bits are on, then we get the first exception
	 * We then XOR together the numbers where the result's
	 * bits are off, then we get the second exception
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

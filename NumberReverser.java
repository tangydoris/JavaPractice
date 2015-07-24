import java.util.logging.Logger;

public class NumberReverser {
	
	/*
	 * #8
	 * Given a Number reverse the digit of that number
	 * input: 34532 -> output 23543
	 */
	
	/*
	 * Method 1
	 * Use loop
	 * Keep a sum that starts at zero
	 * have x start at 1 and y start at 0
	 * Record modulus of number by 10^(number of digits-x)
	 * 	multiply modulus by 10^y
	 * Divide number by 10^(number of digits-x)
	 * Decrement x and increment y
	 * Repeat until x reaches (number of digits-1)
	 * CODE THIS
	 */
	
	static Logger logger = Logger.getLogger("NumberReverser.class");
	
	public static int reverseWithLoop(int a) {
		boolean negative = a<0;
		if (negative)
			a*=-1;
		
		int sum = 0;
		while (a>=1) {
			sum = (sum*10) + (a%10);
			if (sum<0) {
				logger.severe("Largest supported integer reached");
				throw new LargeNumberException("Largest supported integer reached");
			}
			a/=10;
		}
		
		if (negative)
			sum*=-1;
		
		System.out.println(sum);
		return sum;
	}
	
	/*
	 * Method 2
	 * Convert integer into string where each character is
	 * a digit in the integer, in their original left-to-right
	 * order
	 * Create an empty output string
	 * Have a pointer to the last character in the string
	 * Concatenate  this character with the output string
	 * Decrement the pointer
	 * Repeat until the pointer reaches the beginning of the
	 * input string
	 */

	public static void main(String[] args) {
		int a = -23;
		reverseWithLoop(a);
	}

}

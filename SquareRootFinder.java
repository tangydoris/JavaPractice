
public class SquareRootFinder {
	
	/*
	 * #15
	 * Write a code to find a square root of a number without 
	 * using libraries.
	 */
	
	/*
	 * Method 1
	 * Find square root using the averge, the square factors
	 * should be equidistant from zero.
	 * Start from 1 (our number) and divide the input by that
	 * number.
	 * If the factors are close enough, then return our number
	 * Otherwise set our number to the average of the two
	 * factors and repeat.
	 */
	
	private static double epsilon = 0.0000001d;
	
	public static double findSquareRootByAverage(double a) {
		if (a<0)
			throw new IllegalArgumentException("Cannot find square root"+
												"of negative number");
		// we want to start the testing at 1, making 0 a special case
		if (a==0)
			return 0;
		
		return testRoot(a, 1);
	}
	
	private static double testRoot(double a, double x1) {
		double x2=a/x1;
		double difference = x2-x1;
		if (difference<0)
			difference*=-1;
		
		if (difference<=epsilon) {
			System.out.printf("%.2f\n", x1);
			return x1;
		}
		else
			return testRoot(a, (x1+x2)/2);
	}

	public static void main(String[] args) {
		findSquareRootByAverage(25);
		findSquareRootByAverage(55);
	}

}

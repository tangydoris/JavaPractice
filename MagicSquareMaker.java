
public class MagicSquareMaker {
	
	/*
	 * #17 
	 * Write code to build a magic square.
	 */
	
	/*
	 * Odd: De la Loubere's Algorithm, up and to the right.
	 * Even: 
	 */
	
	public static int[][] makeMagicSquare(int len) {
		if (len<=0)
			throw new IllegalArgumentException("Length must be positive.");
		
		// odd order
		if (len%2 != 0)
			return makeOddOrder(len);
		else
			return makeEvenOrder(len);
	}
	
	public static int[][] makeOddOrder(int len) {
		
	}
	
	public static int[][] makeEvenOrder(int len) {
		return new int[0][0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

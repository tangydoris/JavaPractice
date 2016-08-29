package src;

public class MagicSquareMaker {

	/*
	 * Write code to build a magic square.
	 */
	
	/*
	 * Odd: De la Loubere's Algorithm, up and to the right.
	 * Even: 
	 */

    public static int[][] makeMagicSquare(final int len) {
        if (len <= 0) {
            throw new IllegalArgumentException("Length must be positive.");
        }

        // odd order
        if (len % 2 != 0) {
            return makeOddOrder(len);
        } else {
            return makeEvenOrder(len);
        }
    }

    public static int[][] makeOddOrder(final int len) {
        return new int[0][0];
    }

    public static int[][] makeEvenOrder(final int len) {
        return new int[0][0];
    }

    public static void main(String[] args) {

    }

}

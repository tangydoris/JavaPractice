package src;

public class MissingTwoFinder {

	/*
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

    public static int[] findTwoMissing(int[] array) {
        int xor = 0;

        for (final int i : array) {
            xor ^= i;
        }
        int mask = xor & (-1 * xor);

        int missing1 = 0;
        int missing2 = 0;

        for (final int i : array) {
            if ((array[i] & mask) != 0) {
                missing1 ^= array[i];
            } else {
                missing2 ^= array[i];
            }
        }
        System.out.println(missing1);
        System.out.println(missing2);

        return new int[]{missing1, missing2};
    }

    public static void main(String[] args) {
        int[] a = {10, 10, 12, 12, 13, 12, 12, 13, 6, 6, 3, 4, 4, 2};
        findTwoMissing(a);
    }

}

package src.util;

/**
 * Checker to see if integer overflow or underflow occurs.
 */
public class LargeNumberChecker {

    public static boolean isOverflowSum(final int a, final int b) {
        boolean isOverflow = false;
        if (a > 0 && b > 0 && a > Integer.MAX_VALUE - b) {
            isOverflow = true;
        } else if (a < 0 && b < 0 && a < Integer.MIN_VALUE - b) {
            isOverflow = true;
        }
        return isOverflow;
    }

    public static boolean isOverflowSum(final int a, final int b, final int c) {
        boolean isOverflow = true;
        if (!isOverflowSum(a, b)
                && !isOverflowSum(a, c)
                && !isOverflowSum(b, c)
                && !isOverflowSum(a + b, c)) {
            isOverflow = false;
        }
        return isOverflow;
    }
}

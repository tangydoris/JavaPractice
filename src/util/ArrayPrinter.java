package src.util;

/**
 * Utility class that prints an array.
 */
public class ArrayPrinter {

    public static void printArray(final int[] array) {
        final StringBuilder builder = new StringBuilder("{");

        boolean isFirstElement = true;
        for (final int element : array) {
            if (isFirstElement) {
                isFirstElement = false;
            } else {
                builder.append(", ");
            }
            builder.append(element);
        }
        builder.append("}");

        System.out.println(builder.toString());
    }

}

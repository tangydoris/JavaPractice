/*
Given a sorted array of 0’s and 1’s. Find out the number of 0’s in it.
Write recursive, iterative versions of the code.
 */

public class Zeros {

    private static final int testArrayA[] = {0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1};
    private static final int testArrayB[] = {0,1,1,1,1};
    private static final int testArrayC[] = {1,1,1};
    private static final int testArrayD[] = {0,0,0,0,0};

    // Iterative solution
    public static int zeros_iter(int array[]) {
        int start = 0;
        int end = array.length-1;

        // If array is empty, return 0
        if (end < 1) {
            return 0;
        }

        // If array begins with a 1, it contains all 1's
        // There are no 0's
        if (array[start] == 1) {
            return 0;
        }

        // If array ends with a 0, it contains all 0's
        // There are no 1's
        if (array[end] == 0) {
            return end+1;
        }

        while (start < end-1) {
            if (array[end] == 0) {
                break;
            }
            else {
                int mid = (Integer)((start+end)/2);
                if (array[mid] == 0) {
                    start = mid;
                }
                else {
                    end = mid;
                }
            }
        }
        return end;
    }


    // Recursive solution
    public static int zeros_recur(int array[]) {
        return zeros_recur_helper(array, 0, array.length-1);
    }
    // Resursion helper
    public static int zeros_recur_helper(int array[], int start, int end) {
        // Find index of first 1 and return index as number of 0's
        // Empty or null array
        if (array == null || array.length <= 0)
            return 0;

        // Array of all 1's
        if (start > end)
            return 0;

        if (start == end) {
            if (array[end] == 1)
                return end;
            else
                return end+1;
        }
        int mid = (start+end)/2;
        if (array[mid] == 1)
            return zeros_recur_helper(array, start, mid);
        else
            return zeros_recur_helper(array, mid+1, end);
    }


    public static void main (String[] args) {
        System.out.println("Iterative:");
        System.out.println(zeros_iter(testArrayA) + "\t"
                + zeros_iter(testArrayB) + "\t"
                + zeros_iter(testArrayC) + "\t"
                + zeros_iter(testArrayD));

        //System.out.println(zeros_recur(testArrayD));

        System.out.println("Recursive:");
        System.out.println(zeros_recur(testArrayA) + "\t"
                + zeros_recur(testArrayB) + "\t"
                + zeros_recur(testArrayC) + "\t"
                + zeros_recur(testArrayD));

    }

}
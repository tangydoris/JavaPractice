import java.util.Arrays;
import java.util.logging.Logger;

public class ObjectSorter {
	
	/*
	 * #6
	 * Given `N' objects Numbered 0, 1 or 2, sort them so that objects of the same 
	 * numbers are adjacent, with the numbers in the sorted order.
	 * For e.g.
	 * input
	 * 1,2,0,1,2,2,1,0
	 * output
	 * 0,0,1,1,1,2,2,2
	 */
	
	/*
	 * Method one:
	 * Counting sort (Counting Algorithm)
	 * keep array of size 3
	 * increment each index according to whether we encounter a 0,1 or 2
	 */
	
	/*
	 * Method two:
	 * Keep three pointers in the array
	 * One pointer (left) starts at the first index, another (right) starts at the last
	 * Middle pointer starts also at the first index
	 * If the left pointer points to a zero, increment the pointer
	 * If the right pointer points to a two, decrement the pointer
	 * The middle pointer is one index to the left of the left pointer
	 * The middle pointer moves to the left until it encounters a 0 or 2
	 * If it sees a 0, it swaps with the element that the left pointer is pointing to
	 * 	increment the left pointer
	 * If it sees a 2, it swaps with the element that the right pointer is pointing to
	 * 	decrement the right pointer
	 * After that is done, increment the middle pointer
	 * CODE THIS
	 */
	
	static Logger logger = Logger.getLogger("ObjectSorter.class");
	
	public static int[] sortWith3Pointers(int[] b) {
		int[] a = Arrays.copyOf(b, b.length);
		
		if (a == null) {
			logger.severe("Input array cannot be null.");
			throw new NullPointerException("Input array cannot be null.");
		}
		
		// Print original array
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println("");
		
		// No need to sort anything for an empty array or array of one element
		if (a.length == 0 || a.length == 1)
			return a;
		
		for (int i = 0, j = 1, k = a.length-1; j <= k; ) {
			if (a[i] == 0) {
				i++;
				if (j == i)
					j++;
				continue;
			}
			if (a[k] == 2) {
				k--;
				continue;
			}
			
			if (a[j] == 0) {
				int temp = a[i];
				a[i++] = a[j];
				a[j] = temp;
			}
			else if (a[j] == 2) {
				int temp = a[k];
				a[k--] = a[j];
				a[j] = temp;
			}
			else j++;
		}
		
		// Print sorted array
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]+" ");	
		
		return a;
	}

	public static void main(String[] args) {
		int[] a = {0,2,1,0,1,1,0,0,0,2,2};
		sortWith3Pointers(a);
	}

}
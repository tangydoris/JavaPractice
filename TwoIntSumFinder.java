import java.util.Arrays;
import java.util.Hashtable;
import java.util.logging.Logger;

public class TwoIntSumFinder {
	
	/*
	 * #2
	 * Given an array of integers & an integer find two numbers
	 * in the array such that they add up to the given integer.
	 * 
	 * a[] = {1,4,3,4,6,3,5}; K=10
	 * output = 4, 6.
	 */
	
	static Logger logger = Logger.getLogger("TwoIntSumFinder.class");
	
	public static void findSumBySort(int[] array, int sum) {
		if (array == null || array.length == 0) {
			System.out.println("unable to find sum");
			return;
		}
		
		Arrays.sort(array);
		int i = 0;
		int j = array.length-1;
		while (i < j) {
			int tempSum = array[i] + array[j];
			if (tempSum < sum) {
				// needs to be larger, move left pointer
				i++;
			}
			else if (tempSum > sum) {
					// needs to be less, move right pointer
				j--;
			}
			else if (tempSum == sum) {
				// we got it!
				System.out.println(array[i]+" + "+array[j]+" = "+sum);
				break;
			}
		}
		if (i == j)
			System.out.println("cannot find addends for "+sum);
	}
	
	// Second method: hash the complements of each value in the array
	public static void findSumByHash(int[] array, int sum) {
		if (array == null || array.length == 0) {
			System.out.println("unable to find sum");
			return;
		}
		
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			
			/*
			 * If the sum is a large positive and one of the integers in the array
			 * is a large negative, we could have a problem
			 */
			int comp = sum - array[i];
			int magA = Math.abs(array[i]);
			int magSum = Math.abs(sum);
			if (sum > 0) {
				if (array[i] < 0 & comp < 0)
					throwException();
				else if (array[i] > 0) {
					if (magA < sum & comp < 0)
						throwException();
					else if (Math.abs(array[i]) > sum & comp > 0)
						throwException();
				}
			}
			else if (sum >= 0) {
				if (array[i] > 0 & comp > 0)
					throwException();
				else if (array[i] < 0) {
					if (magA < magSum & comp > 0)
						throwException();
					if (magA > magSum & comp < 0)
						throwException();
				}
			}
			else {
				if (table.containsValue(array[i])) {
					System.out.println(array[i]+" + "+comp+" = "+sum);
					return;
				}
				else {
					table.put(array[i], comp);
				}
			}
			
		}
		System.out.println("cannot find addends for "+sum);
	}
	
	public static void throwException() {
		logger.severe("Maximum integer that can be supported reached");
		throw new LargeNumberException("Maximum integer that can be supported reached");
	}
	
	public static void main(String[] args) {
		int[] a = {1,1,2,1,4,1,9,6,1,1,3,1};
		findSumBySort(null, 5);
		findSumByHash(a, 5);
	}

}


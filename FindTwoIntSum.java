import java.util.Arrays;
import java.util.Hashtable;

public class FindTwoIntSum {
	
	private int[] array;
	
	/*
	 * Given an array of integers & an integer find two numbers
	 * in the array such that they add up to the given integer.
	 * 
	 * a[] = {1,4,3,4,6,3,5}; K=10
	 * output = 4, 6.
	 */
	
	public FindTwoIntSum(int[] array) {
		this.array = array;
	}
	
	// First method: sort then seek from two ends
	public void findBySort(int sum) {
		int[] copy = Arrays.copyOf(array, array.length);
		Arrays.sort(copy);
		int i = 0;
		int j = copy.length-1;
		while (i < j) {
			int tempSum = copy[i] + copy[j];
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
				System.out.println(copy[i]+" + "+copy[j]+" = "+sum);
				break;
			}
		}
		if (i == j)
			System.out.println("cannot find addends for "+sum);
	}
	
	// Second method: hash the complements of each value in the array
	public void findByHash(int sum) {
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			int comp = sum - array[i];
			if (table.containsValue(array[i])) {
				System.out.println(array[i]+" + "+comp+" = "+sum);
				return;
			}
			else {
				table.put(array[i], comp);
			}
		}
		System.out.println("cannot find addends for "+sum);
	}

	public static void main(String[] args) {
		
	}

}

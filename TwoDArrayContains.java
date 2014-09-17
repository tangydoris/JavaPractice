/*
 * Given an ordered 2-D array, where every element is greater than the element in the row above it or the column to its left, 
 * write a contains method.
 */

public class TwoDArrayContains {
	public static final int[][] myIntArray= {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};

	public static String myArrayToString() {
		String ans = "\n";
		for (int i = 0; i < myIntArray.length; i++) {
			ans += "[ ";
			for (int j = 0; j < myIntArray[i].length; j++) {
				ans += myIntArray[i][j] + " ";
			}
			ans += "]\n";
		}
		return ans;
	}

	public static Boolean contains(int x) {
		/*
		Game Plan: binary-search-inspired algorithm
		*/

		return containsHelper(x, 0, myIntArray.length-1);
	}

	public static Boolean containsHelper(int x, int start, int end) {
		/*
		Game Plan: Find the array in which x should be (binary search-eque implementation)
		Binary search in that array for x
		*/

		if (x < myIntArray[start][0])
			return false;

		// Found the inner array to search
		if (x >= myIntArray[end][0])
			return searchInnerArray(x, myIntArray[end]);
		// Keep looking for the inner array in which x could be
		else {
			int mid = (start+end)/2;
			if (x >= myIntArray[mid][0])
				return containsHelper(x, mid, end);
			else
				return containsHelper(x, start, mid);
		}
	}

	public static Boolean searchInnerArray(int x, int[] intArray) {
		return searchInnerArrayHelper(x, intArray, 0, intArray.length-1);
	}

	public static Boolean searchInnerArrayHelper(int x, int[] intArray, int start, int end) {
		if (start > end) {
			return false;
		}

		if (x == intArray[start] || x == intArray[end])
			return true;

		int mid = (start+end)/2;
		if (x < intArray[mid])
			return searchInnerArrayHelper(x, intArray, start, mid);
		else
			return searchInnerArrayHelper(x, intArray, mid+1, end);
	}

	/*
	Or you can concatenate the inner int arrays into one big ordered one-D int array
	Then implement binary search on the big array
	*/

	// The long way
	public static Boolean containsArduous(int x) {
		for (int i = 0; i < myIntArray.length; i ++) {
			for (int j = 0; j < myIntArray[i].length; j++) {
				if (myIntArray[i][j] == x)
					return true;
			}
		}
		return false;
	}

	public static void main (String[] args) {
		System.out.println(myArrayToString());
		System.out.println("Contains "+7+"?\t"+contains(7));
	}
}
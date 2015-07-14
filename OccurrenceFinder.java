import java.util.Hashtable;

public class OccurrenceFinder {
	
	
	/*
	 * Given an array of integers & an integer find the number of occurrences 
	 * of that integer and display the results.
	 * 
	 * a[] = {1,4,3,4,6,3,5}; K=3
	 * output = 2. 
	 */
	
	
	public int getOccurrence(int[] array, int num) {
		if (array == null || array.length == 0)
			return 0;
		
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		
		// Hash number of occurrences to the occurring value
		for (int i = 0; i < array.length; i++) {
			int x = array[i];
			if (!table.containsKey(x))
				table.put(x, 1);
			else
				table.replace(x, table.get(x)+1);
		}
		
		if (table.containsKey(num))
			return table.get(num);
		else
			return 0;
	}
	
	public static void main(String[] args) {
		
	}
}

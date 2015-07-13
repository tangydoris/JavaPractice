import java.util.Hashtable;

public class OccurrenceFinder {
	
	
	/*
	 * Given an array of integers & an integer find the number of occurrences 
	 * of that integer and display the results.
	 * 
	 * a[] = {1,4,3,4,6,3,5}; K=3
	 * output = 2. 
	 */
	
	private Hashtable<Integer, Integer> table;
	
	public OccurrenceFinder(int[] array) {
		table = new Hashtable<Integer, Integer>();
		
		// Hash number of occurrences to the occurring value
		for (int i = 0; i < array.length; i++) {
			int x = array[i];
			if (!table.containsKey(x))
				table.put(x, 1);
			else
				table.replace(x, table.get(x)+1);
		}
	}

	public int findOccurrences(int x) {
		if (table.containsKey(x))
			return table.get(x);
		else
			return 0;
	}
	
	public static void main(String[] args) {
		
	}
}

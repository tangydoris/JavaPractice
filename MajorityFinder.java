
public class MajorityFinder {
	
	/*
	 * Given an array of size n, find the majority element.
	 * The majority element is the element that appears more than ⌊ n/2 ⌋ times. 
	 * (assume that the array is non-empty and the majority element always exist in the array.)
	 */
	
	/*
	 * Method one:
	 * Keep HashMap (because HashTable is synchronized and is slower)
	 * 	where key is integer in array and value is its frequency
	 * Return the key from hashmap occurs whose value is greater than n/2
	 * O(n)
	 */
	
	/*
	 * Method two:
	 * Sort array
	 * Iterate through array and keep count of the frequency of the current integer
	 * When frequency reaches n/2, return the current integer
	 * O(nlogn)
	 */
	
	/*
	 * Method three:
	 * The majority element must be one away from or at the midpoint of the sorted array
	 * Sort array
	 * Inspect the integer at index floor of n/2
	 * 	if array has odd length then return integer at index floor of n/2, +1
	 * 	if array has even length, see if integers at indices n/2 and n/2 -1 are equals
	 * 		if they are, return integer
	 * 		if they arent, there is no majority element
	 */
	
	public static void main(String[] args) {
		
	}
}

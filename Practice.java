import java.util.*;

public class Practice {

	/*
	Write  a  program  to  determine  whether  an  input  string x  is  a  substring  of  another 
	input  string y.   (For  example,  "bat"  is  a  substring  of  "abate",  but  not  of  "beat".)
	*/
	public static Boolean isSubstring(String substr, String str) {
		// Invalid inputs: return false
		if (substr == null || str == null) {
			System.out.println("Invalid input");
			return false;
		}
		// Empty strings: return false
		if (substr.length() <= 0 || str.length() <= 0)
			return false;

		// Split strings into character arrays for easy comparison
		String[] subStrArray = substr.split("");
		String[] strArray = str.split("");
		
		// Index of the substring array on range [1, subStrArray.length-1]
		// For some reason the String.split("") method pads the zeroth index with an empty string
		int j = 1;
		// Index to keep track of each round of checking after matching the first character
		int iPrime = 1;

		for (int i = 1; i < strArray.length; i ++) {
			while (j < subStrArray.length && subStrArray[j].equals(strArray[iPrime])) {
				iPrime++;
				j++;
			}
			if (j >= subStrArray.length-1)
				return true;
			
			// Reset j for the next round of comparisons
			j = 1;
			iPrime = i+1;
		}
		return false;
	}

	/*
	Write  a  function  to  remove  a  single  occurrence  of  an  integer  from  a  doubly  linked 
	list  if  it  is  present. 
	*/
	// Won't compile because DoubleLinkedList doesn't actually exist in the Java library...
	// Assume list is not circular
	/*
	public Boolean removeInteger(LinkedList<Integer> list, int x) {
		Node current = list.getFirst();
		while (current != null) {
			if (current.getValue() == x) {
				if (current.previous == null)
					current.next.previous = null;
				else if (current.next == null)
					current.previous.next = null;
				else
					current.previous.next = current.getNext();
					
				return true;
			}
			current = current.getNext();
		}

		// Integer was not in list
		return false;
	}
	*/


	/*
	Remove all repeated characters in a string
	*/
	public static String removeRepeatedChars(String str) {
		/*
		Game Plan: At each char in the string, put it into a HashSet
		If the character is in the set, then do not put it into the answer string
		If it isn't, add it to the answer string
		What if two chars collide? (Might not have to deal with this since there are only so many characters
		and collison with a good hash function is unlikely anyway...But do I have a good hash function?)
		
		Don't forget null check
		No need to waste time with algorithm
		*/

		if (str == null || str.equals(""))
			return "";
		
		String ans = "";

		// Don't specify size of HashSet because I want there to be enough room so that collision is highly unlikely
		HashSet<Character> hash = new HashSet<Character>();
		//char is a primitive type. generics need objects
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!hash.contains(c)) {
				hash.add(c);
				ans += c;
			}
		}
		return ans;
	}


	/*
	Given a list/set of whatever, return a list/array of all possible subsets
	*/
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static ArrayList<ArrayList> allPossibleSubsets(ArrayList<Integer> list) {
		/*
		Game Plan: Return all sublists of sizes in range [1, input list length]
		I'm going to assume that the list argument is already a set (contains no repeats)
		REMEMBER: order doesn't matter
		
		Should I use recursion?
		I'll definitely need a helper function
		*/

		/*
		Input: {1, 2, 3, 4}
		Output: {{} ... {1} .... {2}, {2, 1} ... {3} ,{3,2} ,{3,2,1},
			{4}, {4,3}, {4,2}, {4,1}, {4,2,1}, {4,3,2} {4,3,2,1}}
		Add each successive element to the subsets already established
		*/

		// For an empty list, don't need to do anything
		ArrayList<ArrayList> ans = new ArrayList<ArrayList>();
		// Always add the empty set as a subset of input list
		ans.add(new ArrayList<Integer>());

		// For an empty input list, we're done
		if (list.isEmpty())
			return ans;

		ArrayList<ArrayList> listOfNewSubsets;

		for (int i = 0; i < list.size(); i++) {
			allPossibleSubsetsHelper(ans, list.get(i));
		}
		return ans;
	}

	// Adds another element to the subsets already created
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static void allPossibleSubsetsHelper(ArrayList<ArrayList> list, Integer x) {
		// Make a clone of the old list
		ArrayList<ArrayList> newList = new ArrayList<ArrayList>(list.size());
		for (int i = 0; i < list.size(); i++) {
			newList.add((ArrayList<Integer>)list.get(i).clone());
			newList.get(i).add(x);
		}

		for (int i = 0; i < newList.size(); i++)
			list.add((ArrayList<ArrayList>)newList.get(i).clone());
	}

	/*
	Reverse a LinkedList
	*/
	public static LinkedList<Integer> reverseLinkedList (LinkedList<Integer> list) {
		/*
		Game Plan: Is this a doubly LinkedList? I'll assume it isn't
		(for a doubly LinkedList this would be easy)
		Start at the beginning of the list
		Push each Integer into a stack (I'll use ArrayStack)
		When done, pop each Integer off the stack and put it into a new LinkedList

		What do we do with a null element in the list?
		I'll assume that since we just want to reverse the list, I'll keep the null in the
		returned reversed as well
		*/

		// Answer LinkedList to be returned
		LinkedList<Integer> ans = new LinkedList<Integer>();

		// Instantiate an ArrayStack to keep Integers from input list
		Stack<Integer> stack = new Stack<Integer>();

		// Go through the input list, pushing each Integer into a stack
		for (int i = 0; i < list.size(); i++)
			stack.push(list.get(i));
		
		// Done with transferring elements from input list to stack
		// Pop each element off the stack and put into ans LinkedList
		/*
		I go against my previous assumtion that the null's are kept in the original list
		I'll assume now that the original list contains no null's because it would give a
		false positive that I've reached the bottom of the stack
		*/
		while (stack.size() > 0)
			ans.add(stack.pop());

		return ans;
	}

	/*
	You have stairs with N number of steps
	You can take either one step steps or two step steps; 
	how many ways can you climb the stairs?
	*/


	/*
	Find the length of the longest chain of consecutive integers
	in an unsorted set in linear time
	*/


	/*
	Write an algorithm to insert a new value into a circular sorted linked list
	Commenting this function out because there is no CircularLinkedList in the Java library
	and I don't feel like implementing it haha
	*/
	public static void insertIntoCircularLinkedList (CircularLinkedList<Integer> list, int x) {
		/*
		Game Plan: Start searching for x's appropriate position at index 0
		(which may or may not be the least/greatest element, we don't know)
		If x is greater than the value, we move over one direction
		If x is smaller than the value, we move over in the other direction
		We have found x's position when x is between two neighboring values
		We modify the list to insert x
		*/

		Integer currentNode = list.get(0);
		while (x)
	}


	public static void main (String[] args) {
		// check isSubString()
		String subStr = "que";
		String subStr2 = "cat";
		String str = "baroque";
		System.out.println(subStr+" is a substring of "+str+":\t"+isSubstring(subStr, str));
		System.out.println(subStr2+" is a substring of "+str+":\t"+isSubstring(subStr2, str));
	
		// check removeRepeatedChars
		String str2 = "aaabbbbbbbcdefeaawepewvdsk;kjjkdfddd";
		System.out.println("Remove repeated characters in "+str2+":\t"+removeRepeatedChars(str2));

		// check allPossibleSubsets
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		intArray.add(1);
		intArray.add(2);
		intArray.add(3);
		intArray.add(5);
		ArrayList<Integer> intArray2 = new ArrayList<Integer>();
		System.out.println("All subsets of "+intArray2+":\t"+allPossibleSubsets(intArray2));
		System.out.println("All subsets of "+intArray+":\t"+allPossibleSubsets(intArray));

		LinkedList<Integer> emptyLinkedList = new LinkedList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (int i = 0; i < 21; i += 5)
			linkedList.add(i);
		System.out.println("Reverse "+emptyLinkedList+":\t"+reverseLinkedList(emptyLinkedList));
		System.out.println("Reverse "+linkedList+":\t"+reverseLinkedList(linkedList));
	}
}
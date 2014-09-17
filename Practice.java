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
	Write an algorithm to insert a new value into a circular sorted linked list
	Commenting this function out because there is no CircularLinkedList in the Java library
	and I don't feel like implementing it haha

	Doesn't have a return value: the input list in memory is modified
	*/
	
	// public static void insertIntoCircularLinkedList (CircularLinkedList<Integer> list, int x) {
		/*
		Game Plan: Start searching for x's appropriate position at index 0
		(which may or may not be the least/greatest element, we don't know)
		If x is greater than the value, we move over one direction
		If x is smaller than the value, we move over in the other direction
		We have found x's position when x is between two neighboring values
		We modify the list to insert x

		How do we know which direction to go in?
		I'll assume going with the direction of the node pointers is toward larger numbers

		What happens when we try to insert into a list with one element?
		An empty list?
		*/

		// Empty input list
		/*
		if (list.size() == 0)
			list.add(new CircularLinkedListNode<Integer>(x);

		CircularLinkedListNode<Integer> currentNode = list.get(0);
		CircularLinkedListNode<Integer> newNode = new CircularLinkedListNode<Integer>(x);
		// Input list with one element
		if (list.size() == 1) {
			currentNode.setNext(newNode);
			newNode.setNext(currentNode);
		}

		Circulat LinkedListNode<Integer> nextNode = currentNode.getNext();
		while (!(x >= currentNode.getValue() x < nextNode.getValue())) {
			currentNode = nextNode;
			nextNode = nextNode.getNext();
		}

		currentNode.setNext(newNode);
		newNode.setNext(nextNode);
		*/
	// }



	/*
	You have stairs with N number of steps
	You can take either one step steps or two step steps; 
	how many ways can you climb the stairs?
	*/
	/*
	To go up a staircase of 0 steps, you take 0 steps. That is 1 way.
	For a staircase of 1 step, you take 1 step. That is 1 way.

	For however many steps (n) here on out, you can take 1 step to begin with
	and the rest of the problem is an n-1 problem.
	You can take 2 steps to begin with and the rest of the problem is an n-2 problem.

	This is the Fibonacci sequece!
	The number of ways to climb an N-steps staircase is the (N+1)th Fibonacci number
	where Fib(0)=0 and Fib(1)=1.
	*/


	/*
	Find the length of the longest chain of consecutive integers
	in an unsorted set in linear time

	I'll assume that the input ArrayList is already a set
	*/
	public static int findLongestConsecutiveChain (ArrayList<Integer> set) {
		/*
		Game Plan: iterate through input set
		When the next number if 1 greater than the current number, increment counter (ans)
		If not, then reset counter
		*/

		// Empty input set
		if (set.size() == 0)
			return 0;

		int longestStreak = 1;
		int ans = 1;
		for (int i = 0; i < set.size()-1; i++) {
			// If the next number is consecute to the one at this index, increment counter
			if (set.get(i+1) == (set.get(i)+1))
				ans++;

			// If the next number breaks consecutive chain
			else
				if (ans > longestStreak)
					longestStreak = ans;
				else
					ans = 1;
		}

		return longestStreak;
	}


	/*
	Write a function to return the longest common prefix between two strings
	*/
	public static String longestCommonPrefix (String str1, String str2) {
		/*
		Game Plan: Look at the characters in each string starting from the beginning
		Compare the characters
		Once the characters don't match, end program because there is no need to look
		at the rest of the strings

		If either string is empty, return an empty string
		*/

		String ans = "";
		if (str1.length()==0 || str2.length()==0)
			return ans;

		for (int i = 0; i < str1.length() && i < str2.length(); i++) {
			// I use == instead of .equals() because char is primitive
			if (str1.charAt(i) == str2.charAt(i))
				ans += str1.charAt(i);
			else
				break;
		}

		return ans;
	}


	public static void main (String[] args) {
		System.out.println(" ");

		// test isSubString()
		String subStr = "que";
		String subStr2 = "cat";
		String str = "baroque";
		System.out.println(subStr+" is a substring of "+str+":\t"+isSubstring(subStr, str));
		System.out.println(subStr2+" is a substring of "+str+":\t"+isSubstring(subStr2, str));
	
		// test removeRepeatedChars
		String str2 = "aaabbbbbbbcdefeaawepewvdsk;kjjkdfddd";
		System.out.println("Remove repeated characters in "+str2+":\t"+removeRepeatedChars(str2));

		// test allPossibleSubsets
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		intArray.add(1);
		intArray.add(2);
		intArray.add(3);
		intArray.add(5);
		ArrayList<Integer> intArray2 = new ArrayList<Integer>();
		System.out.println("All subsets of "+intArray2+":\t"+allPossibleSubsets(intArray2));
		System.out.println("All subsets of "+intArray+":\t"+allPossibleSubsets(intArray));

		// test reverseLinkedList
		LinkedList<Integer> emptyLinkedList = new LinkedList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (int i = 0; i < 21; i += 5)
			linkedList.add(i);
		System.out.println("Reverse "+emptyLinkedList+":\t"+reverseLinkedList(emptyLinkedList));
		System.out.println("Reverse "+linkedList+":\t"+reverseLinkedList(linkedList));

		// test findLongestConsecutiveChain
		intArray.add(8);
		intArray.add(9);
		intArray.add(3);
		System.out.println("Longest streak of consecutive integers in "+intArray2+":\t"
				+findLongestConsecutiveChain(intArray2));
		System.out.println("Longest streak of consecutive integers in "+intArray+":\t"
				+findLongestConsecutiveChain(intArray));

		// test longestCommonPrefix
		String str1 = "baronesque";
		String str3 = "";
		System.out.println("Longest common prefix of "+str3+" and "+str1+":\t"+longestCommonPrefix(str3, str1));
		System.out.println("Longest common prefix of "+str+" and "+str1+":\t"+longestCommonPrefix(str, str1));
	}
}
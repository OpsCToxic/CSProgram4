
/**
 * Program 4
 *  This program uses generic methods, LinkedLists, ArrayLists, and Integer arrays to initialize and compare elements of each type of list, such as finding the max, shuffling, removing duplicates, and linearly searching 1-d,2-d,ArrayLists and arrays.
 *  These reference types utilizes instance methods and genertic types to accomplish this goal.
 *  3/14/22
 *  @author  Cameron Cobb
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Random;

public class GenMethods {

	/**
	 * @return
	 */
	public static String getIdentificationString() {
		return "Program 4, Cameron Cobb";
	}
	
	/**
	 * This method removes duplicates from an ArrayList passed from the main method by using nested for loops to determine the equality of each element.
	 * @param <E>
	 * @param list
	 * @return
	 */
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		
		for (int i = 0; i < list.size(); ++i) {
			for (int j = list.size() - 1; j >= 0; --j) {
				if (i != j) {
					if (list.get(i).equals(list.get(j))) {
						list.remove((j));
					}
				}
				
		
				
			}
		}
		return list;
	}
	
	/**
	 * This method shuffles an ArrayList by swapping two random indices 30 times and using ArrayList instance methods such as set() and get().
	 * @param <E>
	 * @param list
	 */
	public static <E> void shuffle(ArrayList<E> list) {
		Random rand = new Random(340L);
		
		for (int i = 0; i < 30; ++i) {
			int position1 = rand.nextInt(list.size());
			int position2 = rand.nextInt(list.size());
			E temp = list.get(position1);
			list.set(position1, list.get(position2));
			list.set(position2, temp);
		}
		
	}
	
	
	/**
	 * This method finds the max element in an ArrayList by using compareTo() method and setting the initial max variable of generic type to the first element of the ArrayList.
	 * @param <E>
	 * @param list
	 * @return
	 */
	public static <E extends Comparable<E>> E max(ArrayList<E> list) {
		E max = list.get(0);
		
		for (int i = 0; i < list.size(); ++i) {
			if (max.compareTo(list.get(i)) < 0) {
				max = list.get(i);
			}
		}
		return max;
		
	}
	
	/**
	 * This method linearly searches an array of generic type by checking each element of the list chronologically through a list and comparing each element to the search key.
	 * @param <E>
	 * @param list
	 * @param key
	 * @return
	 */
	public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
		for (int i = 0; i < list.length; ++i) {
			if (list[i].equals(key)) {
				return i;
			}
		}
		return -1;
	
	}
	
	/**
	 * This method finds the max element in an array list of generic type by using compareTo() method and setting the initial max variable to the first element of the list array.
	 * @param <E>
	 * @param list
	 * @return
	 */
	public static <E extends Comparable<E>> E max(E[] list) {
		E max = list[0];
		for (int i = 0; i < list.length; ++i) {
			if (list[i].compareTo(max) > 0) {
				max = list[i];
			}
		}
		return max;
	}
	
	/**
	 * This method finds the max of a 2 dimensional array of generic type by iterating throug hthe rows and columns and comparing the max value to each element.
	 * @param <E>
	 * @param list
	 * @return
	 */
	public static <E extends Comparable<E>> E max(E[][] list) {
		E max = list[0][0];
		for (int i = 0; i < list.length; ++i) {
			for (int j = 0; j < list[i].length; ++j) {
				if (max.compareTo(list[i][j]) < 0) {
					max = list[i][j];
				}
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int length;
		Integer userVal;
		int m;
		int p;
		Integer[] list;
		LinkedList<Integer> linked;
		ListIterator<Integer> listIterator;
		String studentResult;
		
		Integer[][] list2;
		ArrayList<Integer> aList = new ArrayList<Integer>();
		
		
		Scanner scan = new Scanner(System.in);
		
		length = scan.nextInt();
		
		list = new Integer[length];
		linked = new LinkedList<Integer>();
		
		
		
		for (int i = 0; i < length; ++i) {
			Integer a = scan.nextInt();
			list[i] = a;
			linked.add(a);
			
		}
		
		System.out.println(Arrays.toString(list));
		System.out.println(linked);
	
		
		userVal = scan.nextInt();
		
		if (linearSearch(list, userVal) != -1) {
			System.out.println("Key " + userVal+ " was found at position " + linearSearch(list, userVal));
		}
		else {
			System.out.println("Key " + userVal + " was not found");
		}
		
		System.out.println(max(list) + " is the max element");
		
		m = scan.nextInt();
		p = scan.nextInt();
		list2 = new Integer[m][p];
	
		for(int i = 0; i < list2.length; ++i) {
			for (int j = 0; j < list2[i].length; ++j) {
				list2[i][j] = scan.nextInt();
				System.out.print(list2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println(max(list2) + " is the max element");
		
		listIterator = linked.listIterator();
		
		for (int i = 0; i < linked.size(); ++i) {
			aList.add(linked.get(i));
		}
		
		System.out.println(aList);
		
		aList = removeDuplicates(aList);
		
		System.out.println(aList);
		
		shuffle(aList);
		
		System.out.println(aList);
		
		System.out.println(max(aList) + " is the max element");
		
		studentResult = getIdentificationString();
	}

}

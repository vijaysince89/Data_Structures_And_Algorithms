package search.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BinarySearch {

	public static void main(String[] args) {
		// Number of input integers involved in the binary search
		int numberOfInputs = 100;
		// Maximum Random number that will be generated from 0 to n
		int maxRandomNumber = 1000;
		// Target Search Element
		int searchElement = 200;

		// Random Input Generation
		List<Integer> integerInputs = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < numberOfInputs; i++) {
			integerInputs.add(random.nextInt(maxRandomNumber));
		}

		// Sorting the input integer list
		long startTime = System.nanoTime();
		Collections.sort(integerInputs);
		long elapsedTime = System.nanoTime() - startTime;

		System.out.println("Time taken to sort the input elements = " + elapsedTime + " Nano Seconds");
		System.out.println("Input List of Integers \n" + integerInputs);
		System.out.println("Search for " + searchElement);

		// Binary Search operation
		startTime = System.nanoTime();
		int index = binarySearch(integerInputs, searchElement);
		elapsedTime = System.nanoTime() - startTime;

		System.out.println("Time taken to Search = " + elapsedTime + " Nano Seconds");
		if (index != -1) {
			System.out.println("Element found in index = " + index + " Considering indices as [0,1,2,...,n]");
		} else {
			System.out.println("Element Not found");
		}

	}

	/**
	 * Binary Search operation using Iterative method
	 * 
	 * @param integerInputs
	 * @param searchElement
	 * @return index of searchElement from the input Integer List
	 */
	private static int binarySearch(List<Integer> integerInputs, int searchElement) {
		int inputLength = integerInputs.size();
		int min = 0, max = inputLength - 1, mid;
		int compare;
		while (min <= max) {
			mid = (min + max) / 2;
			compare = integerInputs.get(mid).compareTo(searchElement);
			if (compare == 0) {
				return mid;
			} else if (compare < 0) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		// If searchElement Not found
		return -1;
	}

}

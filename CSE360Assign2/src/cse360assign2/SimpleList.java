package cse360assign2;
/*------------------------------------------------------------------------//
//                                                                        //
//  Nhan Huynh                                                            //
//  Class ID: 209                                                         //
//  Assignment 1                                                          //
//  SimpleList class create and process list of up to 10 data.            //
//                                                                        //
//------------------------------------------------------------------------*/

/**
 * The SimpleList class creates an array of size 10 to emulate a list.
 * Its data includes: 
 * 		* list : an array of size 10 of integers to store data 
 * 		* count : the number of data currently in the list 
 * 
 * It also contains various ways to process such list, such as:
 * 		* add data to the beginning of the list (add) 
 * 		* remove first instant of specified data from list (remove) 
 * 		* display number of data currently in the list (count)
 * 		* display all data currently in the list (toString) 
 * 		* search for the position of a specified data in the list (search)
 * 		* append data to the end of the list (append)
 * 		* display the first element of the list (first)
 * 		* display the last element of the list (last)
 * 		* display the size of the array maintaining the list (size)
 */
public class SimpleList {
	public static final int SIZE = 10; // constant for ease of testing
	private int[] list;
	private int count;

	/**
	 * The constructor automatically initialized the array of integer to 
	 * size 10 and the count to 0. 
	 */
	public SimpleList() {
		list = new int[SIZE];
		count = 0;

	}

	/**
	 * add (int): void method move all existing data down the list, then add
	 * the parameter to the beginning of the list (index 0). If the list is 
	 * full, increase the size of the list by 50%. 
	 * 
	 * @param value The value to be inserted into the list.
	 */
	public void add(int value) {
		// if list if full
		if (count == size()) {
			// create new list 50% larger
			double newSize = list.length * 1.5;
			int[] tempList = new int[(int) newSize];
			// copy data to new list
			for (int index = 0; index < count; index++) {
				tempList[index] = list[index];
			}
			list = tempList;
		}

		if (count == 0) // if array is empty
		{
			list[0] = value; // insert at index 0
			count++; // increment size of list
		} else // if array is not empty
		{
			// copy data down the array
			for (int index = count; index > 0; index--) {
				list[index] = list[index - 1];
			}
			list[0] = value; // insert at index 0
			count++; // increment size of list
		}

	}

	/**
	 * remove (int): void method checks if the parameter is in the list, and
	 * if it is, remove the first instance of it in the list. 
	 * 
	 * If it is in the last position, simply remove it by decrement the count 
	 * by 1. If it is not in the last position, remove it by moving all data
	 * after it up by 1 index, and decrement the count by 1.
	 * 
	 * If the list has more than 25% empty space. Decrease the size of the 
	 * list by 25%. 
	 * 
	 * @param value The value to be remove from the list.
	 */
	public void remove(int value) {
		// determine if parameter is in the list
		int position = search(value);

		if (position != -1) // if yes, process the list
		{
			if (position < size() - 1) // if it is not in last position
			{
				// move data up to "remove" data at current position
				for (int index = position + 1; index < count; index++) {
					list[index - 1] = list[index];
				}
			}
			// if it is in the last position,
			// just decrease count to "remove" last data

			count--; // decrement count by 1
		}

		// calculate the percent of empty space
		double emptyRatio = ((double) list.length - count) / list.length;

		if (emptyRatio > 0.25 && size() > 1) // if bigger than 25%
		{
			// create new list 25% smaller
			double newSize = list.length * 0.75;
			int[] tempList = new int[(int) newSize];

			// copy data to new list
			for (int index = 0; index < count; index++) {
				tempList[index] = list[index];
			}
			list = tempList;
		}

	}

	/**
	 * count (): int method returns the number of data currently in the list.
	 * 
	 * @return count The number of data currently in the list 
	 */
	public int count() {
		return count;
	}

	/**
	 * toString (): String method returns the data in the list as a String.
	 * 
	 * @return myString The data in the list as a String
	 */
	public String toString() {
		String myString = "";

		// concatenate myString with value from the list array
		for (int index = 0; index < count; index++) {
			myString += list[index];

			// print out 'space' except for last data
			if (index < count - 1)
				myString += " ";
		}

		return myString;
	}

	/**
	 * search (int): int method search for the position of the parameter and
	 * return the value of the position. If the parameter is not in the list,
	 * then the value return is -1.
	 * 
	 * @param value The value need to be search
	 * @return position The position of the parameter in the array
	 */
	public int search(int value) {
		boolean found = false;
		int position = -1;

		// process through loop to find index of paramater
		for (int index = 0; index < count && !found; index++) {
			if (list[index] == value) {
				position = index;
				found = true; // to exit the loop when parameter is found.
			}
		}
		return position;

	}

	/**
	 * append (int): void method add parameter value at the end of the list.
	 * If the list is full, increase the size of the list by 50%. Then
	 * increment the count by 1.
	 * 
	 * @param value The value to be inserted into the list.
	 */

	public void append(int value) {
		// if list if full
		if (count == size()) {
			// create new list 50% larger
			double newSize = list.length * 1.5;
			int[] tempList = new int[(int) newSize];
			// copy data to new list
			for (int index = 0; index < count; index++) {
				tempList[index] = list[index];
			}
			list = tempList;
		}
		list[count] = value; // append data at the end of the list
		count++; // increment the size of list
	}

	/**
	 * first (): int method returns the first element of the list (index 0).
	 * If the list is empty, return -1.
	 * 
	 * @return The first element of the list at index 0.
	 */
	public int first() {
		// if the list is empty
		if (count == 0)
			return -1;
		else
			return list[0];
	}

	/**
	 * last (): int method returns the last element of list (index count-1)
	 * If the list is empty, return -1.
	 * 
	 * @return The last element of the list at index (count-1).
	 */
	public int last() {
		// if the list is empty
		if (count == 0)
			return -1;
		else
			return list[count - 1];
	}

	/**
	 * size (): int method returns the length of the array used to maintain
	 * the list.
	 * 
	 * @return The length of the array used to maintain list
	 */
	public int size() {
		return list.length;
	}
}
package cse360assign2;

/*  Nhan Huynh
Class ID: 209
Assignment 1
SimpleList class create and process list of up to 10 data.
*/

/**-----------------------------------------------------------------------//
// The SimpleList class creates an array of size 10 to emulate a list.    //
//                                                                        //
// Its data includes:                                                     //
//    * list : an array of size 10 of integers to store data              //
//    * count : the number of data it current has                         //
//    	                                                                  //
// It also contains various ways to process such list, such as:           //
//    * add data to list (add)                                            //
//    * remove first instant of specified data from list (remove)         //
//    * display number of data currently in the list (count)              //
//    * display all data currently in the list (toString)                 //
//    * search for the position of a specified data in the list (search)  //
//    	                                                                  //
//------------------------------------------------------------------------//*/ 
public class SimpleList {
	public static final int SIZE = 10; // constant for ease of testing
	private int[] list;
	private int count;

	/**-----------------------------------------------------------------------//
	//																		  //
	// The constructor automatically initialized the array of integer to      //
	// size 10 and the count to 0.                                            //
	//																		  //
	//------------------------------------------------------------------------//*/ 
	public SimpleList() {
		list = new int[SIZE];
		count = 0;

	}

	/**-----------------------------------------------------------------------//
	//  																	  //
	// add (int): void method move all existing data down the list, then add  //
	// the parameter to the beginning of the list (index 0). If the list is   //
	// full, simply overwrite the last data. Then increment the count by 1.   //
	// 																		  //
	// @param value The value to be inserted into the list.                   //
	//																		  //
	//------------------------------------------------------------------------//*/ 
	public void add(int value) {
		// copy data down the array for full list
		// simply overwrite data from the 8th index onto 9th index.
		if (count == list.length) {
			for (int index = count - 1; index > 0; index--) {
				list[index] = list[index - 1];
			}
			list[0] = value;
			// size of list is not incremented because list if full
		}
		// if empty array, insert value directly into list[0]
		// and increment size of list.
		else if (count == 0) {
			list[0] = value;
			count++;
		}
		// copy data down the array for list size less than 10
		else {
			for (int index = count; index > 0; index--) {
				list[index] = list[index - 1];
			}
			list[0] = value;
			count++; // increment size of list if less than 10.
		}

	}

	/**-----------------------------------------------------------------------//
	// 																		  //
	// remove (int): void method checks if the parameter is in the list, and  //
	// if it is, remove the first instance of it in the list.                 //
	// 																		  //
	// If it is in the last position, simply remove it by decrement the count //
	// by 1. If it is not in the last position, remove it by moving all data  //
	// after it up by 1 index, and decrement the count by 1.                  //
	// 																		  //
	// @param value The value to be remove from the list.                     //
	//  																	  //
	//------------------------------------------------------------------------//*/ 
	public void remove(int value) {
		// determine if parameter is in the list
		int position = search(value);
		// if yes, process the list
		if (position != -1) {
			// if position is the last, decrease count to "remove" last data
			// if it is not, move data up to "remove" data at current position.
			if (position < list.length - 1) {
				for (int index = position + 1; index < count; index++) {
					list[index - 1] = list[index];
				}
			}
			// decrement count by 1
			count--;
		}

	}

	/**-----------------------------------------------------------------------//
	// 																		  //
	// count (): int method returns the number of data currently in the list. //
	//  																	  //
	// @return count The number of data currently in the list                 //
	//  																	  //
	//------------------------------------------------------------------------//*/ 
	public int count() {
		return count;
	}

	/**-----------------------------------------------------------------------//
	//  																	  //
	// toString (): String method returns the data in the list as a String    //
	//                      											 	  //
	// @return myString The data in the list as a String                      //
	//  																	  //
	//------------------------------------------------------------------------//*/   
	public String toString() {
		String myString = "";

		// concatenate myString with value from the list array.
		for (int index = 0; index < count; index++) {
			myString += list[index];
			if (index < count - 1) // print out 'space' except for last data
				myString += " ";
		}

		return myString;
	}

	/**-----------------------------------------------------------------------//
	// 																		  //
	// search (int): int method search for the position of the parameter and  //
	// return the value of the position. If the parameter is not in the list, //
	// then the value return is -1.											  //
	//  																	  //
	// @param value The value need to be search.                              //
	// @return position The position of the parameter in the array            //
	//  																      //
	//------------------------------------------------------------------------//*/  
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
	
	/**-----------------------------------------------------------------------//
	// 																		  //
	// size (): int method returns the length of the array used to maintain   //
	// the list.                                                              //
	//                             											  //
	// @return The length of the array used to maintain list                  //
	// 	 																	  //
	//------------------------------------------------------------------------//*/       
	public int size () 
	{
			return list.length;
	}
}
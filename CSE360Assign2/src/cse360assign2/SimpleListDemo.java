package cse360assign2;

/*------------------------------------------------------------------------//
//																		  //
//  Nhan Huynh                                                            //
//  Class ID: 209                                                         //
//  Assignment 1                                                          //
//  SimpleListDemo to demonstrate and test SimpleList class.              //
//  																	  //
//------------------------------------------------------------------------*/

/**
 * 
 * @author Nhan Huynh
 * 
 *
 */
public class SimpleListDemo {

	public static void main(String[] args) {

		SimpleList myList = new SimpleList();

		myList.append(13);
		myList.append(11);
		myList.append(42);
		myList.append(4);
		myList.add(7);
		myList.append(99);
		myList.add(5);
		myList.add(3);
		myList.add(12);
		myList.add(13);

		System.out.println("My count: " + myList.count());
		System.out.println("My array size: " + myList.size());

		myList.append(100);
		System.out.println(myList);
		System.out.println("My count: " + myList.count());
		System.out.println("My array size: " + myList.size());

		myList.remove(4);
		System.out.println(myList);
		System.out.println("My count: " + myList.count());
		System.out.println("My array size: " + myList.size());
		myList.remove(42);
		System.out.println(myList);
		System.out.println("My count: " + myList.count());
		System.out.println("My array size: " + myList.size());
		myList.remove(11);
		System.out.println(myList);
		System.out.println("My count: " + myList.count());
		System.out.println("My array size: " + myList.size());
		myList.remove(13);
		System.out.println(myList);
		System.out.println("My count: " + myList.count());
		System.out.println("My array size: " + myList.size());

		myList.remove(100);
		System.out.println(myList);
		System.out.println("My count: " + myList.count());
		System.out.println("My array size: " + myList.size());
		
		System.out.println("First element: " + myList.first());
		System.out.println("Last element: " + myList.last());

	}

}

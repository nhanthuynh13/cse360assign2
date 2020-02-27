package cse360assign2;

public class SimpleListDemo {

	public static void main(String[] args) {

		SimpleList myList = new SimpleList();

		myList.add(13);
		myList.add(11);
		myList.add(42);
		myList.add(4);
		myList.add(7);
		myList.add(99);
		myList.add(5);
		myList.add(3);
		myList.add(12);
		myList.add(13);

		System.out.println("My count: " + myList.count());
		System.out.println("My array size: " + myList.size());

		myList.add(100);
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

	}

}

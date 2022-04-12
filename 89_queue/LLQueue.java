// Team Not Gonna Lie (Nafiz Labib, Gabriel Thompson, Lauren Lee)
// APCS
// HW89 -- Queue Two Ways
// 2022-04-11
// time spent: 0.3hrs

/***
 * DISCO
 *  - Nodes need not be involved in a Queue, only through a LinkedList
 *  - All LLQueue methods are constant time
 *  - When using a method like removeFirst() or getFirst() which returns the cargo at one node, you must typecast the output to the generic type.
 * 
 * QCC
 *  - Why must we typecast such as at line 29?
 ***/

import java.util.LinkedList;

public class LLQueue<T> implements Queue<T> {

	LinkedList queue;

	public LLQueue() {
		this.queue = new LinkedList<T>();
	}

	// O(1)
	public T dequeue() {
		return (T) this.queue.removeFirst();
	}

	// O(1)
	public void enqueue( T x ) {
		this.queue.addLast(x);
	}

	// O(1)
	public boolean isEmpty() {
		return this.queue.size() == 0;
	}

	// O(1)
	public T peekFront() {
		return (T) this.queue.getFirst();
	}
	
	public static void main(String[] args) {
		LLQueue<String> q = new LLQueue<String>();
		q.enqueue("Hello");
		q.enqueue("There");
		System.out.println(q.peekFront()); // "Hello"
		q.dequeue();
		System.out.println(q.isEmpty());   // false
		System.out.println(q.peekFront()); // "There"
		System.out.println(q.isEmpty());   // true
	}
	
}

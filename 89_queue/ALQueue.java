// Team Not Gonna Lie (Nafiz Labib, Gabriel Thompson, Lauren Lee)
// APCS
// HW89 -- Queue Two Ways
// 2022-04-11
// time spent: 0.3hrs

/***
 * DISCO
 *  - If you're trying to add to the end of an ArrayList, you should add at ArrayList.size(),
 *    not ArrayList.size() - 1
 *
 * QCC
 *  - Why are ArrayLists able to access any index in O(1) time whereas Linked Lists aren't?
 *  - Should we prioritize memory or runtime? David Deng's reply to @750 is a way of making
 *    ArrayList-based queues run in O(1) time. However, it would be very memory-intensive.
 ***/

import java.util.ArrayList;

public class ALQueue<T> implements Queue<T> {

	ArrayList queue;

	public ALQueue() {
		this.queue = new ArrayList<T>();
	}

	public T dequeue() {
		return (T) this.queue.remove(0);
	}

	public void enqueue( T x ) {
		this.queue.add(queue.size(), x);
	}

	public boolean isEmpty() {
		return this.queue.size() == 0;
	}

	public T peekFront() {
		return (T) this.queue.get(0);
	}

	public static void main(String[] args) {
		ALQueue<String> q = new ALQueue<String>();
		q.enqueue("Hello");
		q.enqueue("There");
		System.out.println(q.peekFront()); // "Hello"
		q.dequeue();
		System.out.println(q.isEmpty());   // false
		System.out.println(q.peekFront()); // "There"
		System.out.println(q.isEmpty());   // true
	}

}

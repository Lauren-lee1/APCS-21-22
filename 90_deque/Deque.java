// TNPG: NGL -- Nafiz Labib, Gabriel Thompson, Lauren Lee
// APCS pd8
// HW91: Deque the Halls
// 2022-04-13
// time spent: 0.3 hr

/***
 * interface Deque
 * Includes only methods listed in AP subset of Java
 * (Local version, to override built-in Java implementation.)
 **/

public interface Deque<QUASAR>
{
  //~~~~~~~~~~~~~~~~~~begin AP subset~~~~~~~~~~~~~~~~~~
  //means of removing an element from collection:

  //Dequeues and returns the first element of the queue.
  public QUASAR removeFirst();
  //Dequeues and returns the last element of the queue.
  public QUASAR removeLast();


  //means of adding an element to collection:

  //Enqueue an element onto the back of this queue.
  public void addFirst( QUASAR x );
  //Enqueue an element onto the back of this queue.
  public void addLast( QUASAR x );

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty();

  //Returns the first element of the queue without dequeuing it.
  public QUASAR getFirst();
  //Returns the last element of the queue without dequeuing it.
  public QUASAR getLast();

  //Retrieves and removes the first element of this deque, or returns null if this deque is empty.
  public QUASAR pollFirst();
  //Retrieves and removes the last element of this deque, or returns null if this deque is empty.
  public QUASAR pollLast();
  /***
***/


  //~~~~~~~~~~~~~~~~~~~end AP subset~~~~~~~~~~~~~~~~~~~

}//end interface Deque

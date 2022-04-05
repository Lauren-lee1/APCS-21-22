// Gabriel Thompson
// APCS
// HW88 -- BPC Kiddies Do Not Wait in Line Either
// 2022-04-04
// time spent: 2.0hrs (yes, I know)

/***
 * class RQueue
 * SKELETON
 * A node-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 **/

/**
 *
 * DISCO
 *  - Diagramming is helpful, kinda
 *
 * QCC
 * - Why do we set pointers instead of swapping the cargo values?
 * - Why is our shuffling algo only printing out dread?
 * - For shuffling, is it better to do the array method of picking two random
 *   elements and swapping them, or repeatedly choosing random indexes and
 *   pushing them to the beginning of the queue
 * - We spent two hours on this but still weren't able to get it to work, and
 *   eventually decided that we were being irrational and decided to give it
 *   a rest™
 *
 **/

public class RQueue<T> implements Queue<T>
{
  //instance variables
  private LLNode<T> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
  {
    _front = null;
    _end = null;
    _size = 0;
  }

  public T dequeue()
  {
    this.sample();
    T retVal = _front.getCargo();
    _front = _front.getNext();

    if ( _front == null ) //just moved past last node
      _end = null;      //update _end to reflect emptiness

    _size--;

    return retVal;
  }

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( T enQVal )
  {
    //special case: when enqueuing to an empty list, 
    //make _front && _end point to same node
    if ( isEmpty() ) {
      _front = _end = new LLNode<T>( enQVal, null );
    }
    else {
      _end.setNext( new LLNode<T>( enQVal, null ) );
      _end = _end.getNext();
    }
    _size++;
    System.out.println("enqueued " + enQVal);
  }

  public T peekFront()
  {
    return _front.getCargo();
  }//O(?)


  /***
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   *   1. Generate a random number.
   *   2. Move the first item in the queue to that index
   *   3. Go back to (1) and repeat "size" times.
   **/
  public void sample ()
  {
   System.out.println(this);
   _front.setNext(_end);
   _end.setNext(_front);
   /*LLNode<T> middle = _front;
   for (int i = 0 ; i < _size / 2 - 1 ; i++) {
     middle = middle.getNext();
   }
   _front.setNext(middle.getNext());
   middle.setNext(middle.getNext().getNext());*/
   /*
    for (int i = 0; i < _size; i++) {
      int index = 1 + (int) (Math.random() * (_size - 2));
      LLNode<T> temp;
      LLNode<T> before = _front;

      for (int j = 0; j < index - 1; j++) {
        System.out.println(before + " " + before.getNext());
	before = before.getNext();
      }
      temp = before.getNext();

      before.setNext(_front);
      _front.setNext(temp);

      //a -> b -> c -> d -> e -> f

      temp.getNext().setNext(before);

      System.out.println(this);
      for (int k = index ; k < _size ; k++) {
        _front = _front.getNext();
      }
    }
    */
  }//O(?)


  public boolean isEmpty()
  {
    return _front == null;
  } //O(?)


  // print each node, separated by spaces
  public String toString()
  {
    String out = "";
    LLNode<T> current = _front;

    out += "[";
    for (int i = 0 ; i < _size ; i++) {
      out += current.getCargo();
      current = current.getNext();

      if (i < _size - 1)
        out += ", ";
    }
    return out + "]";
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {
    Queue<String> PirateQueue = new RQueue<String>();

    System.out.println("\nnow enqueuing..."); 
    PirateQueue.enqueue("Dread");
    PirateQueue.enqueue("Pirate");
    PirateQueue.enqueue("Roberts");
    PirateQueue.enqueue("Blackbeard");
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");

    System.out.println("\nnow testing toString()..."); 
    System.out.println( PirateQueue ); //for testing toString()...

    System.out.println("\nnow dequeuing..."); 
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );

    System.out.println("\nnow dequeuing fr empty queue...\n" +
                       "(expect NPE)\n"); 
    System.out.println( PirateQueue.dequeue() );

      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue

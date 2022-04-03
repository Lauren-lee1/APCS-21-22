/*
Team Not Gonna Lie (Nafiz Labib, Gabriel Thompson, Lauren Lee)
APCS
HW87 -- The English Do Not Wait in Line for Soup
2022-04-01
time spent: 1.0 hrs

DISCO --
  - Must assign the cargo and next of the _queue to be null upon declaration
  - the computer sees the type variable QUASAR in LLNode and NodeQueue as different variables/types and refers to them as QUASAR#1 and QUASAR#2

QCC --
  - Is there a benefit to dequeuing from the right and enqueuing from the left
  - Would using DLLNode give us constant runtime for our dequeue method (removing _tail instead of going through all nodes until we find one whose next is null)?

*/
public class NodeQueue<QUASAR> implements Queue<QUASAR>{

  private LLNode<QUASAR> _queue; //considered first

  public NodeQueue(){
    _queue = new LLNode<QUASAR>(null, null);
  }
  //means of removing an element from collection:
  //Dequeues and returns the first element of the queue.
  //from left
  //O(1)
  public QUASAR dequeue(){
    if(_queue==null){
      return null;
    } else if (_queue.getNext() == null){
      QUASAR retVal = _queue.getCargo();
      _queue.setCargo(null);
      return retVal;
    } else {
      QUASAR retval = _queue.getCargo();
      _queue = _queue.getNext();
      return retval;
    }
  }

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  //from right
  //O(n)
  public void enqueue( QUASAR x ){
    if(_queue.getCargo() == null){
      _queue.setCargo(x);
    } else {
      LLNode temp = _queue;
      while(temp.getNext()!=null){
        temp=temp.getNext();
      }
      LLNode<QUASAR> addition = new LLNode<QUASAR>(x, null);
      temp.setNext(addition);
    }
  }

  //Returns true if this queue is empty, otherwise returns false.
  //O(1)
  public boolean isEmpty(){
    boolean retVal = false;
    if(_queue.getCargo() == null){
      retVal = true;
    }
    return retVal;
  }

  //Returns the first element of the queue without dequeuing it.
  //O(1)
  public QUASAR peekFront(){
    QUASAR retVal = _queue.getCargo();
    return retVal;
  }



/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

private class LLNode<QUASAR>
{
    //instance vars
    private QUASAR _cargo;    //cargo may only be of type String
    private LLNode _nextNode; //pointer to next LLNode

    // constructor -- initializes instance vars
    public LLNode( QUASAR value, LLNode next ) {
    	_cargo = value;
    	_nextNode = next;
    }


    //--------------v  ACCESSORS  v--------------
    public QUASAR getCargo() { return _cargo; }

    public LLNode getNext() { return _nextNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public QUASAR setCargo( QUASAR newCargo ) {
    	QUASAR foo = getCargo();
    	_cargo = newCargo;
    	return foo;
    }

    public LLNode setNext( LLNode newNext ) {
    	LLNode foo = getNext();
    	_nextNode = newNext;
    	return foo;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() { return _cargo.toString(); }

  }// end class LLNode
    //main method for testing
    public static void main( String[] args )
    {
      NodeQueue<String> starbucks = new NodeQueue<String>();

      starbucks.enqueue("james");
      System.out.println(starbucks.isEmpty());
      starbucks.enqueue("kevin");
      starbucks.enqueue("lauren");
      starbucks.enqueue("gabriel");
      starbucks.enqueue("nafiz");

      System.out.println(starbucks.peekFront());
      starbucks.dequeue();
      System.out.println(starbucks.peekFront());
      starbucks.dequeue();
      System.out.println(starbucks.peekFront());
      starbucks.dequeue();
      System.out.println(starbucks.peekFront());
      starbucks.dequeue();
      System.out.println(starbucks.peekFront());
      starbucks.dequeue();

      System.out.println(starbucks.isEmpty());



    }//end main


}//end NodeQueue.java

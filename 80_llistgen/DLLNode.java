// Team Not Gonna Lie (Nafiz Labib, Gabriel Thompson, Lauren Lee)
// APCS
// HW80 -- Generically Speaking
// 2022-03-24 
// time spent: 0.7hrs

/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class DLLNode<T>
{
    //instance vars
    private T _cargo;    //cargo may only be of type String
    private DLLNode<T> _tailNode; //pointer to next LLNode
    private DLLNode<T> _headNode;

    // constructor -- initializes instance vars
    public DLLNode( T value, DLLNode head, DLLNode tail ) {
    	_cargo = value;
    	_tailNode = tail;
      _headNode = head;

    }


    //--------------v  ACCESSORS  v--------------
    public T getCargo() { return _cargo; }

    public DLLNode<T> getTail() { return _tailNode; }

    public DLLNode<T> getHead() { return _headNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public T setCargo( T newCargo ) {
    	T foo = getCargo();
    	_cargo = newCargo;
    	return foo;
    }

    public DLLNode<T> setHead( DLLNode<T> newHead ) {
    	DLLNode<T> foo = getHead();
    	_headNode = newHead;
    	return foo;
    }

    public DLLNode<T> setTail( DLLNode<T> newTail ) {
    	DLLNode<T> foo = getTail();
    	_tailNode = newTail;
    	return foo;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() { return _cargo.toString(); }

  //
  //   //main method for testing
  //
  //   public static void main( String[] args )
  //   {
  //
	// //Below is an exercise in creating a linked list...
  //
	// //Create a node
	// LLNode first = new LLNode( "cat", null );
  //
	// //Create a new node after the first
	// first.setNext( new LLNode( "dog", null ) );
  //
	// //Create a third node after the second
	// first.getNext().setNext( new LLNode( "cow", null ) );
  //
	// /* A naive list traversal, has side effects.... ??
	//    while( first != null ) {
	//    System.out.println( first );
	//    first = first.getNext();
	//    }
	// */
  //
	// //Q: when head ptr moves to next node in list, what happens to the node it just left?
  //
	// //...so better: ?
	// //
	// //
	// //
  //
  //   }//end main
  //

}//end class LLNode

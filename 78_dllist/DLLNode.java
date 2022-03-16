/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class DLLNode
{
    //instance vars
    private String _cargo;    //cargo may only be of type String
    private DLLNode _tailNode; //pointer to next LLNode
    private DLLNode _headNode;

    // constructor -- initializes instance vars
    public DLLNode( String value, DLLNode head, DLLNode tail ) {
    	_cargo = value;
    	_tailNode = tail;
      _headNode = head;

    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo() { return _cargo; }

    public DLLNode getTail() { return _tailNode; }

    public DLLNode getHead() { return _headNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo ) {
    	String foo = getCargo();
    	_cargo = newCargo;
    	return foo;
    }

    public DLLNode setHead( DLLNode newHead ) {
    	DLLNode foo = getHead();
    	_headNode = newHead;
    	return foo;
    }

    public DLLNode setTail( DLLNode newTail ) {
    	DLLNode foo = getTail();
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

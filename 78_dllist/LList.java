// Team Not Gonna Lie (Nafiz Labib, Gabriel Thompson, Lauren Lee)
// APCS pd8
// HW78 -- Double Up
// 2022-03-16w
// time spent: 0.5 hrs
//kts -- 1
/*
    DISCO
      *
    QCC
      * How can we utilize the tail? Right now, the list is a double link list, yet tail takes no functionality
      * How do we represent tail on a diagram?
    ALGO ADD
      1. If the index you want to add in is 0, just add the new node at the front of the List by creating tmp that contains the newval and linking it to _head
      2. If not :
          1) Create a new DLLNode tmp to take the value of _head and a new DLLNode newNode that contains the newVal
          2) iterate through tmp until you reach one before your desired index
          3) Link the rest of tmp's list to newNode
          4) Link tmp to newNode
          5) Increment the size
    ALGO REM
      1. If the index is 0, just set the _head to the next head to remove the first value and return it
      2. else:
        1) create a new DLLNode tmp to take the value of head
        2) iterate through tmp until one below your desire index
        3) Store the desired index in a variable to return later
        4) set the next head of tmp to the head of the original next head over, skipping the cargo of the desired index of removal
        5) decrement the size
*/

/*****************************************************
 * class LList
 * Implements a linked list of DLLNodes, each containing String data
 * new in v2: add-at-index, remove
 *****************************************************/

public class LList implements List //your List interface must be in same dir
{

  //instance vars
  private DLLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    DLLNode tmp = new DLLNode( newVal, _head, null );
    _head = tmp;
    _size++;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    String retVal;
    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
	    tmp = tmp.getHead();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
	    tmp = tmp.getHead();

    //store target node's cargo
    String oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }


  //insert a node containing newVal at position index
  public void add( int index, String newVal ) {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    DLLNode newNode = new DLLNode( newVal, null, null );

    //if index==0, insert node before head node
    if ( index == 0 )
	    add( newVal );
    else {
	    DLLNode tmp = _head; //create alias to head

	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
        tmp = tmp.getHead();

	    //insert new node
	    newNode.setHead( tmp.getHead() );
	    tmp.setHead( newNode );

	    //increment size attribute
	    _size++;
    }
  }


  //remove node at pos index, return its cargo
  public String remove( int index ) {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    String retVal;
    DLLNode tmp = _head; //create alias to head

    //if index==0, remove head node
    if ( index == 0 ) {
	    //check target node's cargo hold
	    retVal = _head.getCargo();

	    //remove target node
	    _head = _head.getHead();
    }
    else {
	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
        tmp = tmp.getHead();

	    //check target node's cargo hold
	    retVal = tmp.getHead().getCargo();

	    //remove target node
	    tmp.setHead( tmp.getHead().getHead() );
    }

    //decrement size attribute
    _size--;

    return retVal;
  }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    DLLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getHead();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {

    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
    System.out.println( james );

    james.add(0,"whut");
    System.out.println( "...after add(0,whut): " );
    System.out.println( james );

    james.add(4,"phat");
    System.out.println( "...after add(4,phat): " );
    System.out.println( james );

    System.out.println( "...after remove last: "
                        + james.remove( james._size-1) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );
  }

}//end class LList

// Team Not Gonna Lie (Nafiz Labib, Gabriel Thompson, Lauren Lee)
// APCS
// HW80 -- Generically Speaking
// 2022-03-24 
// time spent: 0.7hrs
//kts -- 1

/*****************************************************
 * class LList
 * Implements a linked list of DLLNodes, each containing String data
 * new in v2: add-at-index, remove
 *****************************************************/

public class LList<T> implements List<T> //your List interface must be in same dir
{

  //instance vars
  private DLLNode<T> _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  @Override
  public boolean add( T newVal )
  {
    DLLNode<T> tmp = new DLLNode<T>( newVal, _head, null );
    _head = tmp;
    _size++;
    return true;
  }

  @Override
  public T get( int index )
  {
    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    T retVal;
    DLLNode<T> tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
	    tmp = tmp.getHead();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }

  @Override
  public T set( int index, T newVal )
  {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    DLLNode<T> tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
	    tmp = tmp.getHead();

    //store target node's cargo
    T oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  @Override
  public int size() { return _size; }


  //insert a node containing newVal at position index
  @Override
  public void add( int index, T newVal ) {

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
  @Override
  public T remove( int index ) {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    T retVal;
    DLLNode<T> tmp = _head; //create alias to head

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
    DLLNode<T> tmp = _head; //init tr
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

    LList<String> james = new LList<String>();

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

    System.out.println("\n---------------------------------------\n");

    LList<Integer> madison = new LList<Integer>();

    System.out.println( madison );
    System.out.println( "size: " + madison.size() );

    madison.add(1);
    System.out.println( madison );
    System.out.println( "size: " + madison.size() );

    madison.add(2);
    System.out.println( madison );
    System.out.println( "size: " + madison.size() );

    madison.add(3);
    System.out.println( madison );
    System.out.println( "size: " + madison.size() );

    madison.add(4);
    System.out.println( madison );
    System.out.println( "size: " + madison.size() );

    System.out.println( "2nd item is: " + madison.get(1) );

    System.out.println( "...and now 2nd item is: " + madison.set(1,5) );
    System.out.println( madison );

    madison.add(0,6);
    System.out.println( "...after add(0,6): " );
    System.out.println( madison );

    madison.add(4,7);
    System.out.println( "...after add(4,7): " );
    System.out.println( madison );

    System.out.println( "...after remove last: "
                        + madison.remove( madison._size-1) );
    System.out.println( madison );

    System.out.println( "...after remove(0): " + madison.remove(0) );
    System.out.println( madison );

    System.out.println( "...after remove(0): " + madison.remove(0) );
    System.out.println( madison );

    System.out.println( "...after remove(0): " + madison.remove(0) );
    System.out.println( madison );

  }

}//end class LList

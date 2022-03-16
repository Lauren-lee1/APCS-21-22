// Team Not Gonna Lie (Nafiz Labib, Gabriel Thompson, Lauren Lee)
// APCS pd8
// HW77 -- Insert|Remove
// 2022-03-15m
// time spent: 0.5 hrs
//kts -- 1

/*

DISCO
* when removing an item, don't need to shift over the rest of the list, just change linkage
QCC
* Is there a way we can code add at index to handle all cases with the same algorithm and how
ALGO ADD
1. Create a temp variable that takes the value of the memory address of the head node
2. If we're NOT at the end of the array...
    a. Traverse the array, so that temp is equal to the index'th node
    b. Create a new Node, which has the cargo of the temp and the "next" value of temp's following Node
    c. Set temp's cargo to the new value
    d. Set temp's next node to be the new node defined in 2b.
3. If (2) is not true AND the array has a length of 0...
    a. Add the new value to the start using the add method
4. If (1) and (2) are both false...
    a. Traverse the array until the last node.
    b. Create a new node whose cargo is the new value to add and "next" node is null
    c. Set the "next" node of the last node calculated in (a) to the node created in b.
ALGO REM
*Set _head to a temporary variable.
Loop through the nodes until you arrive at the index where you want to remove.
Then, change linkage by setting the next of temp to the node that's after the desired index node,
thereby removing the node at intended index.


*/

/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/


public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
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
    LLNode tmp = new LLNode( newVal, _head );
    _head = tmp;
    _size++;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    String retVal;
    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }

  //insert at specified index
  public void add( int index, String newVal ){
    LLNode tmp = _head;
    if(index < _size){
        for (int i = 0; i < index; i++){
          tmp = tmp.getNext();
        }
        LLNode addition = new LLNode(tmp.getCargo(), tmp.getNext());
        tmp.setCargo(newVal);
        tmp.setNext(addition);
    } else if (_size == 0){
      add(newVal);
    } else {
      for (int i = 0; i < _size-1; i++){
        tmp = tmp.getNext();
      }
      LLNode addition = new LLNode(newVal, null);
      tmp.setNext(addition);

    }

      _size++;

  //  }
  }

  //remove node from list, return its data
  public String remove( int index ){
    LLNode tmp = _head;
    for (int i = 0; i < index-1; i++){
      tmp = tmp.getNext();
    }
    String ret = tmp.getNext().getCargo();
    tmp.setNext(tmp.getNext().getNext());
    _size--;
    return ret;
  }

  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //store target node's cargo
    String oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    LLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
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

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println( james );

    james.add(0,"happy");
    System.out.println(james);
    james.add(5, "hello");
    System.out.println(james);
    james.add(6,"end");
    System.out.println(james);

    LList zero = new LList();
    zero.add(3,"good");
    System.out.println(zero);

    System.out.println(james.remove(3));
    System.out.println(james);

  }

}//end class LList

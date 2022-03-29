// Team Not Gonna Lie (Nafiz Labib, Gabriel Thompson, Lauren Lee)
// APCS
// HW83 -- Stacks on Stacks
// 2022-03-28
// time spent: 1
//
//
//     DISCO
//      * Adding at front has time complexity of O(n) in every increase
//      * Adding at back has time complexity of O(1) in best case and O(n) in worse case
//     QCC
//      * Is adding in the front/back a matter of perspective like in our formal definition of ADT, or does it make more sense to add in the front to imitate the "pushing" of the elements down

/***
 * class Latkes
 * v1
 * SKELETON
 * Implements a stack of Strings using an encapsulated array
 **/

/***
    DISCO

    QCC

 **/


public class Latkes
{
  private String [] _stack;
  private int _stackSize;


  //constructor
  public Latkes( int initCapacity )
  {
    _stack = new String[initCapacity];
    _stackSize = 0;
  }// O(?)


  //means of insertion
  public void push( String s )
  {
      if (isFull()){
          String[] newArray = new String[this._stackSize + 1];
          for (int i = 1; i <= this._stackSize; i++)
              newArray[i] = this._stack[i - 1];

          newArray[0] = s;
          this._stack = newArray;
      } else {
          // System.out.println(_stackSize);
          for (int i = (_stackSize - 1); i > -1; i--){
              // System.out.println("this is i => " + i);
              _stack[i+1] = _stack[i];
          }
          _stack[0] = s;
      }
      this._stackSize++;

      System.out.println(this);

  }
  // O(n)
  //adding at end will make O(1) unless you need increase the size of the array, then it would be O(n)


  //means of removal
  public String pop( )
  {
      String retVal = _stack[0];
      if (isEmpty()){
          return "is empty";
      } else{
          for (int i = 1; i < _stackSize; i++){
              _stack[i-1] = _stack[i];
          }

          _stack[_stackSize - 1] = null;
      }
      _stackSize--;
      System.out.println(this);
      return retVal;

  }// O(n)
  //If we remove at end, is O(1)


  //chk for emptiness
  public boolean isEmpty()
  {
    return _stackSize < 1;
  }// O(?)


  //chk for fullness
  public boolean isFull()
  {
    return _stackSize == _stack.length;
  }// O(?)

  public String toString(){
    String retVal = "{" + _stack[0];
    for (int i = 1; i < _stack.length; i++){
      retVal = retVal + "," +  _stack[i];
    }
    retVal = retVal + "}";
    return retVal;
  }

  //main method for testing
  public static void main( String[] args )
  {
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v*/

    Latkes tastyStack = new Latkes(10);

    tastyStack.push("aoo");
    tastyStack.push("boo");
    tastyStack.push("coo");
    tastyStack.push("doo");
    tastyStack.push("eoo");
    tastyStack.push("foo");
    tastyStack.push("goo");
    tastyStack.push("hoo");
    tastyStack.push("ioo");
    tastyStack.push("joo");
    tastyStack.push("coocoo");
    tastyStack.push("cachoo");

    //cachoo
    System.out.println( tastyStack.pop() );
    //coocoo
    System.out.println( tastyStack.pop() );
    //joo
    System.out.println( tastyStack.pop() );
    //ioo
    System.out.println( tastyStack.pop() );
    //hoo
    System.out.println( tastyStack.pop() );
    //goo
    System.out.println( tastyStack.pop() );
    //foo
    System.out.println( tastyStack.pop() );
    //eoo
    System.out.println( tastyStack.pop() );
    //doo
    System.out.println( tastyStack.pop() );
    //coo
    System.out.println( tastyStack.pop() );
    //boo
    System.out.println( tastyStack.pop() );
    //aoo
    System.out.println( tastyStack.pop() );

    //stack empty by now; SOP(null)
    System.out.println( tastyStack.pop() );
    /*  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main()

}//end class Latkes

// Perfect Purple Petunias (John Gupta-She, Emily Ortiz, Lauren Lee)
// APCS pd8
// HW43 -- encapsulation (basic SuperArray functionality)
// 2021-12-07
// time spent:0.3

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 QCC: Why is expand() private while the others are public?
 DiSCO: Put array values into a new array, then initialize a new array of desired size, then replace values.
 ***************************/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new int[10];
    _size = 10;
  }


  //output SuperArray in [a,b,c] format
  public String toString(){
    String output = "[";
    for (int i = 0; i < _size - 1; i++){
      output += _data[i] + ",";
    }
    output += _data[_size-1] + "]";
    return output;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] old = _data;
    _data = new int[_size * 2];
    for (int i = 0; i < _size; i++) {
      _data[i] = old[i];
    }
    _size *= 2;
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    int old = _data[index];
    _data[index] = newVal;
    return old;
  }


  //main method for testing
  public static void main( String[] args )
  {
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );
      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }
      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);
      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      }
  }//end main()


}//end class

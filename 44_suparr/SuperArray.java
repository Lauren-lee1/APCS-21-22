// Perfect Purple Petunias (John Gupta-She, Emily Ortiz, Lauren Lee)
// APCS pd8
// HW44: Array of Grade 316
// 2021-12-08
// time spent: .4

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 QCC: Should we be more careful with the values to the right of the _size index? Should unassigned values be set to 0, even if they don't matter?
 DISCO: Make sure methods handle various types of input values.
Stuff to the right of the _size index doesn't matter.
 ***************************/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new int[10];
    _size = 0;
  }


  //output SuperArray in [a,b,c] format
  public String toString(){
    if (_size == 0){
      return "[]";
    }
    else {
      String output = "[";
      for (int i = 0; i < _size - 1; i++){
        output += _data[i] + ",";
      }
      output += _data[_size-1] + "]";
      return output;
    }
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] old = _data;
    _data = new int[_data.length * 2];
    for (int i = 0; i < _size; i++) {
      _data[i] = old[i];
    }
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

  public void add(int value){
    add_at_index(_size, value);
  }

  public void add_at_index(int index, int value){
    if (index > _size || index < 0) {
      System.out.println("Selected index outside of range.");
    }
    else {
      if (_size >= _data.length){
        expand();
      }
      for(int i = _size; i > index; i--){
        _data[i] = _data[i-1];
      }
      _data[index] = value;
      _size += 1;
    }
  }

  public void remove(int index){
    if (index > _size || index < 0) {
      System.out.println("Selected index outside of range.");
    }
    else {
      for(int i = index; i < _size; i++){
        _data[i] = _data[i+1];
      }
      _size -= 1;
    }
  }

  //main method for testing
  public static void main( String[] args )
  {
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );
      curtis._size = 10;
      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }
      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);
      curtis.add(5);
      System.out.println("Printing SuperArray curtis + 5...");
      System.out.println(curtis);
      curtis.add_at_index(2, 20);
      System.out.println("Printing SuperArray curtis + 20 at index 2...");
      System.out.println(curtis);
      System.out.println("Printing SuperArray curtis + 20 at index 20 (should fail)...");
      curtis.add_at_index(20, 20);
      System.out.println(curtis);
      curtis.remove(2);
      System.out.println("Printing SuperArray curtis removing index 2...");
      System.out.println(curtis);
      curtis.remove(10);
      System.out.println("Printing SuperArray curtis removing index 10...");
      System.out.println(curtis);
  }//end main()


}//end class

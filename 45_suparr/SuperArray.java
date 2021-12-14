public class SuperArray implements ListInt
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new int[10];
    _size = 0;
  }

  public int size(){
    return _size;
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

  public boolean add(int value){
    return add_at_index(_size, value);
  }

  public boolean add_at_index(int index, int value){
    if (index > _size || index < 0) {
      return false;
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
      return true;
    }
  }

  public boolean remove(int index){
    if (index > _size || index < 0) {
      return false;
    }
    else {
      for(int i = index; i < _size; i++){
        _data[i] = _data[i+1];
      }
      _size -= 1;
      return true;
    }
  }

  //main method for testing
  public static void main( String[] args )
  {
      SuperArray curtis = new SuperArray();
      curtis._size = 10;
      System.out.println( "Printing out _size..." + curtis.size() + " should be 10" );
      System.out.println("Printing add()..." + curtis.add(5) + " should be true");
      System.out.println("Printing add_at_index..." + curtis.add_at_index(2, 20) + " should be true" );
      System.out.println("Printing add_at_index..." + curtis.add_at_index(12, 20) + " should be false"); //indext out of bounds
      System.out.println("Printing add_at_index..." + curtis.add_at_index(-1, 20) + " should be false"); //index out of bounds
      System.out.println("Printing remove()" + curtis.remove(10) + " should be true");
      System.out.println("Printing remove()" + curtis.remove(20) + " should be false");


  }//end main()


}//end class

// Crabby Chips: Lauren Lee and Diana Akhmedova
// APCS pd8
// HW55: Never Fear, Big Oh Is Here!
// 2022-01-12
// Time Spent: 0.5 hrs

/**
DISCO:
- O(1) classification is a point, if you are simply inserting an element at a specific index in the ArrayList.
- O(n) classification is linear, if you traverse through the ArrayList once.
- O(n^2) classification is quadratic, if you traverse through the ArrayList n times.
QCC:
- How do the different big-O classifications differ in efficiency?
- What other functions can be used in big-O classification?
**/

import java.util.ArrayList;

public class OrderedArrayList
{

  // instance of class ArrayList, holding objects of type Integer
  // (i.e., objects of a class that implements interface Integer)
  private ArrayList<Integer> _data;

  // default constructor
  // initializes instance variables
  public OrderedArrayList()
  {
    _data = new ArrayList<>();
    for(int i=0; i<23; i++) {
	     _data.add(i);
     }
  }

  public String toString()
  {
    String ans = "{ ";
    for (int i=0; i<_data.size(); i++) {
  	   ans += _data.get(i) + ", ";
     }
     ans = ans.substring(0, ans.length()-2);
     ans += " }";
     return ans;
  }


  /**
  Best Case Scenario: i is the last element in the Arraylist.
  Worst Case Scenario: i is not in the ArrayList.
  Classification: O(1)
  **/
  public Integer remove( int i )
  {
    int temp = _data.get(i);
    _data.remove(i);
    return temp;
  }


  /**
  Best Case Scenario: The size is 0.
  Worst Case Scenario: The size is extremely large.
  Classification: O(n)
  **/
  public int size()
  {
    return _data.size();
  }


  /**
  Best Case Scenario: i is in the Arraylist.
  Worst Case Scenario: i is not in the ArrayList.
  Classification: O(1)
  **/
  public Integer get( int i )
  {
    return _data.get(i);
  }


  /**
  Best Case Scenario: newVal is the smallest value in the ArrayList, O(1).
  Worst Case Scenario: There is not enough space in the ArrayList or the element is at the end of the ArrayList, O(n)
  **/
  public void addLinear(Integer newVal)
  {
    if (_data.size() < 1) {
	     _data.add(newVal);
     } else {
       for (int i=0; i<_data.size()-1; i++) {
         if(_data.get(i) > newVal) {
	          _data.add(i, newVal);
	           break;
  	     }
       }
       if (_data.get(_data.size()-1) < newVal) {
  	      _data.add(newVal);
        }
      }
  }


  /**
  Best Case Scenario: newVal is the middle element in the ArrayList, O(1).
  Worst Case Scenario: newVal is the smallest or largest element in the ArrayList, O(log2n).
  **/
  public void addBinary(Integer newVal)
  {
  int min = 0;
  int max = _data.size() - 1;
        while (min <= max) {
            int middle = min + (max - min) / 2;
            if (_data.get(middle) == newVal) {
                _data.add(middle, newVal);
            }
            if (_data.get(middle) < newVal)  {
                min = middle + 1;
            }
            else {
                max = middle - 1;
            }
        }
  }

  // main method solely for testing purposes
  public static void main( String[] args )
  {

    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
      Franz.addLinear( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

    // testing binary search
    Franz = new OrderedArrayList();
    for( int i = 0; i < 15; i++ )
      Franz.addBinary( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

  }//end main()

}//end class OrderedArrayList

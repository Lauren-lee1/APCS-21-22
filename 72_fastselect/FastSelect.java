// Team Not Gonna Lie (Nafiz Labib, Gabriel Thompson, Lauren Lee)
// APCS pd8
// HW72 -- So So Fast
// 2022-03-08t
// time spent: 1.0hrs

/***
 * ALGO
 *  1. From the known sorted index, partition the array
 *  2. If the known sorted index is the number that we're looking for, return that.
 *  3. If the known sorted index is less than the number we're looking for...
 *     -> The known sorted index to the right bound will contain the number we're looking for,
 *        so partition from the sorted index to the right bound
 *  4. If the known sorted index is more than the number we're lookin for...
 *     -> The left bound to the known sorted index will contain the number we're looking for, so
 *        partition from the left bound to the sorted index
 *
 * BEST CASE SCENARIO
 *  -> The middle number is the item we're searching for
 *  -> Complexity: O(n), because it runs the partition function once, then instantly ends the process
 *
 * WORST CASE SCENARIO
 *  -> The first or last number is the item we're searching for
 *  -> Complexity: O(n log n), because the partition function runs in O(n) time, and gets called on
 *     the order of O(log n) times, because the size of the array being handled roughly halves in
 *     each function call
 *
 * DISCO
 *  -> When we call a method in an if statement, the method will be called
 *  -> Calling the partition() function multiple times changed our result
 *
 * QCC
 *  -> Both this algorithm and merge sort run in O(n log n) time. Which is preferable? Does Java
 *     use either of this?
 *  -> What is this algorithm called? How quickly can it sort?
 *
 ***/

import java.util.Arrays;

public class FastSelect
{
  public static int counter = 0;

  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d )
  {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------


  public static int partition( int arr[], int left, int right, int pivotIndex)
  {
    int v = arr[pivotIndex];

    swap( pivotIndex, right, arr);
    int storePos = left;

    for( int i = left; i < right; i++ ) {
      if ( arr[i] <= v) {
        swap( i, storePos, arr );
        storePos++;}
    }
    swap(storePos,right,arr);

    return storePos;
  }//end mysterion

  public static int fastSelect( int arr[], int y ) {
    counter = 0;
    return fastSelectHelper(arr, 0, arr.length - 1, arr.length / 2, y);
  }

  public static int fastSelectHelper( int arr[], int left, int right, int pivotIndex, int y ) {
    counter++;
    int result = partition(arr, left, right, pivotIndex);

    if (result == y - 1) {
      return arr[y - 1];
    }

    if (result < y - 1) {
      return fastSelectHelper(arr, result + 1, right, (result + right + 1)/2, y);
    } else {
      return fastSelectHelper(arr, left, result - 1, (left + result - 1)/2, y);
    }
  }

  //main method for testing
  public static void main( String[] args )
  {
    int[] arr1 = {8,21,17,69,343};
    int[] arr2 = {1,28,33,4982,37};
    int[] arr3 = {5,4,17,9000,6};
    int[] arr4 = {3,0,16,599,1024};

    System.out.println(fastSelect(arr1, 1) + " ...should be 8");
    System.out.println(fastSelect(arr1, 2) + " ...should be 17");
    System.out.println(fastSelect(arr1, 3) + " ...should be 21");
    System.out.println(fastSelect(arr1, 4) + " ...should be 69");
    System.out.println(fastSelect(arr1, 5) + " ...should be 343");

    System.out.println("\nWORST CASE:");
    System.out.println(fastSelect(arr2, 4) + " ...should be 37");
    System.out.println("# of function calls: " + counter);

    System.out.println("\nBEST CASE:");
    System.out.println(fastSelect(arr2, 3) + " ...should be 33");
    System.out.println("# of function calls: " + counter);
  }//end main

}//end class Mysterion

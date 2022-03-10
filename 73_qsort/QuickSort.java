// Team Not Gonna Lie (Nafiz Labib, Gabriel Thompson, Lauren Lee)
// APCS pd8
//HW72 -- QuickSort
//2022-03-09w
//time spent: 0.9h

/***
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):
 *  If the left index is at or larger than the right index, then
 return because then we can conclude that the partition has been sorted
 *  If left is not greater than or equal to the right, we don't know that the partition is sorted yet so we parition the array and sort the left and right parititions.
 * 2a. Worst pivot choice and associated run time:
 *  The worst pivot choise is the left or right bound because in the worst case scenario of the array in decreasing order, the run time classification would be O(n^2)
 * 2b. Best pivot choice and associated run time:
 *  The best pivot choice on average is the middle value between left and right because in the worst case scenario of descreasing order, every time we run the partition method, we would be decreasing the part of the array we are focusing on by 1/2. The runtime would be O(nlogn)
 * 3. Approach to handling duplicate values in array:
 * If we are considering quick select in the context of index to find the yth smallest element, we don't need to change how we select our yth element
(ie, {2, 3, 4, 4, 5, 7, 7, 8}, the fourth smallest element is four)
 * If we are considering quick select in the context that we are trying to find the smallest distict value...
(ie, {2, 3, 4, 4, 5, 7, 7, 8}, the fourth smallest element is five)
We would remove duplicates and then run quickselect on the array.
 **/
 /**

 DISCO:
 * Increasing the sizes of the arrays in our test cases give us a better understanding of runtime rather than sticking w a smaller array size. 
 *
 QCC
 * is the algorithm really O(nlogn) because in each method call of the quick sort helper, it will call partition twice and partition has a run time of O(n).
 * for quick select, are we finding the yth smallest element based on the index or distinct elements?
 **/

public class QuickSort
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




  /**
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   */
  public static void qsort( int[] d )
  {
    counter = 0;
    qsortHelper(d, 0, d.length-1);
    System.out.println(counter);
  }

  public static void qsortHelper(int arr[], int left, int right){
    counter ++;
    if (left >= right){
      return;
    } else{
      int s = partition(arr, left, right);
      qsortHelper(arr, left, s-1);
      qsortHelper(arr, s+1, right);
    }
  }

  public static int partition( int arr[], int left, int right)
  {
    int pivot = (left+right)/2;
    int v = arr[pivot];

    swap( pivot, right, arr);
    int storePos = left;

    for( int i = left; i < right; i++ ) {
      if ( arr[i] <= v) {
        swap( i, storePos, arr );
        storePos++;}
    }
    swap(storePos,right,arr);

    return storePos;
  }//end partition
  //you may need a helper method...





  //main method for testing
  public static void main( String[] args )
  {
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)

    //get-it-up-and-running, static test case:
    */
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);
    /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    */

    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );

    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    //(hypothesis)best case
    int [] best = new int[100];
    for( int i = 0; i < best.length; i++ )
    best[i] = i+1;
    qsort(best);
    printArr(best);
    //in array length of 10 -- 13 function calls
    // in array length of 100 -- took 127 function calls

    //(hypothesis)worst case
    int [] worst  = new int[100];
    for( int i = 0; i < worst.length; i++ )
    worst[i] = 100-(i+1);
    qsort(worst);
    printArr(worst);
    //in array length of 10 -- 13 function calls
    // in array length of 100 -- took 129 function calls

    int[] rand = new int[100];
    for( int i = 0; i < rand.length; i++ )
    rand[i] = (int)( 100 * Math.random() )+1;
    printArr(rand);
    qsort(rand);
    printArr(rand);
    //in array length of 10 -- 15 function calls
    // in array length of 100 -- took 129 function calls

    // conclusion -- there isn't a best or worst case
  }//end main

}//end class QuickSort

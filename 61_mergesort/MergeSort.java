
/***
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
  To merge two sorted arrays:
  1. compare the first elements of the two arrays. Place the lesser element in the merge array
  2. compare the first element of each array after the element that was placed in the merge array and place the lesser element in the merge array
  3. once one array has been exhausted, place the rest of the elements in the other array into the merge array
  MergeSort Algorithm:
  1. Split your array in half and sort those two arrays by splitting it in half until only one element is in all the arrays
  2. once sorted, merge the two splitted arrays
  ***/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
    int[] merge = new int[a.length + b.length];
    int i = 0;
    int indexa = 0;
    int indexb = 0;
    while(indexa < a.length && indexb < b.length){
      if (a[indexa] > b[indexb]) {
        merge[i] = b[indexb];
        indexb += 1;
        i++;
      }
      else {
        merge[i] = a[indexa];
        indexa += 1;
        i++;
      }
    }
    if(indexa == a.length){
      while (indexb < b.length){
        merge[i] = b[indexb];
        i++;
        indexb++;
      }
    } else{
      while (indexa < a.length){
        merge[i] = a[indexa];
        i++;
        indexa++;
      }
    }
    return merge;

  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
    if(arr.length>1){
      int[] one = new int[arr.length/2];
      for (int i = 0; i < (arr.length/2); i++){
        one[i] = arr[i];
      }
      int[] two = new int[arr.length-(arr.length/2)];
      for(int n = (arr.length/2); n < arr.length; n++){
        two[n-(arr.length/2)] = arr[n];
      }
      return merge(sort(one), sort(two));
    }
    else {
      return arr;
    }
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args )
  {
    /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~*/
      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr4,arr6) );

      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class MergeSort

// Crabby Chips: Lauren Lee and Diana Akhmedova
// APCS pd8
// HW54: One File to Bring Them All...
// 2022-01-12
// Time Spent: 0.5 hrs

import java.util.ArrayList;
@SuppressWarnings("unchecked")

public class MySorts {

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond:  lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi )
  {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of BubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order

  // ALGO for BubbleSort
  // 1. For bubbleSortV, our method first passes through the ArrayList from the right, checking if the last pair is in increasing order, and swapping the two values if not.
  // 2. It repeats this for the second to last pair, then third to last, and so on.
  // 3. After this first pass, it will run through again, but since the value at index 0 is guaranteed to be in the correct position, it will cut short before the last comparison.
  // 4. It will repeat this over and over, each time comparing one less pair from the left. It also will not check the final last pair, as that is guaranteed to be correct.
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    for(int i = 0; i < data.size()-1; i++) {
    	for(int j = data.size() - 1; j > i; j--){
    		if(data.get(j).compareTo(data.get(j - 1)) < 0) {
          int temp = (int)data.get(j);
          data.set(j, data.get(j - 1));
          data.set(j-1, temp);
    		}
    	}
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order

  // ALGO for SelectionSort
  // 1. Select the largest element at move it to the right end.
  // 2. Select the next smallest and move it to the next to right end.
  // 3. Repeat step 2.
  public static void selectionSortV( ArrayList<Comparable> data )
  {
    //note: this version places greatest value at "rightmost" end
    //maxPos will point to position of SELECTION (greatest value)
    int maxPos;

    for(int pass = data.size()-1; pass > 0; pass--) {
      System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
      maxPos = 0;

      for( int i = 0; i < pass+1; i++ ) {
        if (data.get(i).compareTo(data.get(maxPos)) > 0) {
          maxPos = i;
        }
        System.out.println( "maxPos: " + maxPos );//diag
        System.out.println( data );//diag
      }
      data.add(pass+1,data.get(maxPos));
      data.remove(maxPos);
      System.out.println( "after swap: " +  data );//diag
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order

  // ALGO for InsertionSort
  // 1. Start with the sorted partiion osize of one.
  // 2. Insert the one value at a time into the sorted region, swapping with the value's adjacent element when necessary.
  // 3. Repeat until sorted.
  public static void insertionSortV( ArrayList<Comparable> data )
  {
    shuffle(data);
    for(int x = 0; x < data.size()-1; x++  ) {
      //partition marks first item in unsorted region
      int partition = x;

      System.out.println( "\npartition: " + partition + "\tdataset:"); //diag
      System.out.println( data );

      //traverse sorted region from right to left
      for( int i = x+1; i>0; i-- ) {
        // "walk" the current item to where it belongs
        // by swapping adjacent items
        if (data.get(i).compareTo(data.get(i-1)) < 0  ) {
          System.out.println( "swap indices "+(i-1)+" & "+i+"..." ); //diag
          data.add(i-1,data.get(i));
          data.remove(i+1);
        }
        else{
          break;
        }
      }
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  public static void main( String [] args )
  {
    //===============for VOID methods=============
      System.out.println("\u001b[32m");
      System.out.println("Testing Bubble Sort...");
      System.out.println("\u001b[0m");
      ArrayList glen1 = new ArrayList<Integer>();
      glen1.add(7);
      glen1.add(1);
      glen1.add(5);
      glen1.add(12);
      glen1.add(3);
      System.out.println( "ArrayList glen1 before sorting:\n" + glen1 );
      bubbleSortV(glen1);
      System.out.println( "ArrayList glen1 after sorting:\n" + glen1 );

      ArrayList coco1 = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco1 before sorting:\n" + coco1 );
      bubbleSortV(coco1);
      System.out.println( "ArrayList coco1 after sorting:\n" + coco1 );
      System.out.println();
      System.out.println();
    //============================================

    //===============for VOID methods=============
      System.out.println("\u001b[32m");
      System.out.println("Testing Selection Sort...");
      System.out.println("\u001b[0m");
      ArrayList glen2 = new ArrayList<Integer>();
      glen2.add(7);
      glen2.add(1);
      glen2.add(5);
      glen2.add(12);
      glen2.add(3);
      System.out.println( "ArrayList glen2 before sorting:\n" + glen2 );
      selectionSortV(glen2);
      System.out.println( "ArrayList glen2 after sorting:\n" + glen2 );
      ArrayList coco2 = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco2 before sorting:\n" + coco2 );
      selectionSortV(coco2);
      System.out.println( "ArrayList coco2 after sorting:\n" + coco2 );
      System.out.println();
      System.out.println();
    //============================================

    //===============for VOID methods=============
      System.out.println("\u001b[32m");
      System.out.println("Testing Insertion Sort...");
      System.out.println("\u001b[0m");
      System.out.println("*** Testing sort-in-place (void) version... *** ");
      ArrayList glen3 = new ArrayList<Integer>();
      glen3.add(7);
      glen3.add(1);
      glen3.add(5);
      glen3.add(12);
      glen3.add(3);
      System.out.println( "\nArrayList glen3 before sorting:\n" + glen3 );
      insertionSortV(glen3);
      System.out.println( "\nArrayList glen3 after sorting:\n" + glen3 );
      ArrayList coco3 = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco3 before sorting:\n" + coco3 );
      insertionSortV(coco3);
      System.out.println( "\nArrayList coco3 after sorting:\n" + coco3 );
    //============================================
  }

}

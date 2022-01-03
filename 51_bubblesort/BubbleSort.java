// Perfect Purple Petunias (John Gupta-She, Emily Ortiz, Lauren Lee)
// APCS pd8
// HW51 -- implementing bubblesort
// 2022-01-04t
// time spent: 0.5 hrs

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 *
 * ALGO:
 1. beginning at the right hand side of the ArrayList, compare the value of the element at your current position in the ArrayList with the value to the left of the element
 2. If the higher indexed number is greater than the number to the left of it, remove it and add it at one index less than its original index to swap the two values you are comparing
 3. Repeat steps 1-2  until you have compared every two adjacent value in the ArrayList
 4. Repeat steps 1-3 until you have traversed the ArrayList length-2 times
 * DISCO
 * Once we have traversed the array to know the first length-2 elements are in order, we can assume the last element is in its right place so we don't have to traverse the Arraylist again -- this would represent the worse case scenario
 *
 * QCC
 * q0: If a pass requires no swaps, what do you know?
 * a0: The ArrayList is already in order
 * q1: After pass p, what do you know?
 * a1:We know that all elements from index p-1 and less are in order
 * q2: How many passes are necessary to completely sort?
 * a2: The worse case scenario would require length passes to completely sort
 *
 ******************************/

import java.util.ArrayList;

public class BubbleSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond:  lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
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


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    shuffle(data);
    int counter = 0;
    while(counter < data.size()-1){
      int i = data.size()-1;
      while(i > 0){
          Comparable og = (data.get(i));
          if (data.get(i).compareTo( data.get(i-1))<0) {
            data.remove(i);
            data.add(i-1, og);
          }
          i--;
      }
      counter++;
    }
  }


  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
    int counter = 0;
    while(counter < input.size()-1){
      int i = input.size()-1;
      while(i > 0){
          Comparable og = (input.get(i));
          if (input.get(i).compareTo( input.get(i-1))<0) {
            input.remove(i);
            input.add(i-1, og);
          }
          i--;
      }
      counter++;
    }
    return input;
  }


  public static void main( String [] args )
  {

    /*===============for VOID methods=============
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      ============================================*/

    /*==========for AL-returning methods==========*/
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = bubbleSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n"
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
      /*============================================*/

  }//end main

}//end class BubbleSort

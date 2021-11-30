/******************************
 * class TwoDimArray
 * practice working with 2D arrays
 ******************************/

 /*****************************************************
  * Perfect Purple Petunias (John Gupta-She, Lauren Lee, Emily Ortiz)
  * APCS pd08
  * HW40 -- Demand A Raise
  * 2021-11-30
  * time spent: 0.5 hrs
  *****************************************************/

public class TwoDimArray
{
  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOR loop
  public static void print1( int[][] a )
  {
    String outputln = "{\n";
    for (int x = 0; x < a.length; x++){
      outputln += "(" + a[x][0];
      for (int y = 1; y < a[x].length; y++){
        outputln += ", " + a[x][y] ;
      }
      outputln += ")\n";
    }
    outputln += "}";
    System.out.println(outputln);
  }


  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOREACH loop
  public static void print2( int[][] a )
  {
    String outputln = "{\n";
    for (int[] x: a){
      outputln += "(" + x[0];
      int[] z = new int [x.length-1];
        for(int n = 0; n < z.length; n++){
          z[n] = x[n+1];
        }
      for (int y: z){
        outputln += ", " + y;
      }
      outputln += ")\n";
      }
    outputln += "}";
    System.out.println(outputln);
  }


  //postcond: returns sum of all items in 2D int array a
  public static int sum1( int[][] a )
  {
    int sum = 0;
    for (int[] x: a) {
      for (int y:x) {
        sum += y;
      }
    }
    return sum;
  }

  //postcond: returns sum of all items in 2D int array a
  //          * uses helper fxn sumRow
  public static int sum2( int [][] m )
  {
    int sum = 0;
    for (int x = 0; x < m.length; x++){
      sum += sumRow(x, m);
    }
    return sum;
  }
  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOR loop
  public static int sumRow( int r, int[][] a )
  {
    int sum = 0;
    for (int x = 0; x < a[r].length; x++){
      sum += a[r][x];
    }
    return sum;
  }

  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOREACH loop
  public static int sumRow2(int r, int[][] m)
  {
    int summer = 0;
    for (int x : m[r]){
      summer += x;
    }
    return summer;
  }


  public static void main( String [] args )
  {

      int [][] m1 = new int[4][2];
      int [][] m2 = { {2,4,6}, {3,5,7} };
      int [][] m3 = { {2}, {4,6}, {1,3,5} };

      System.out.print("testing print1...\n");
      print1(m1);
      print1(m2);
      print1(m3);

      System.out.print("testing print2...\n");
      print2(m1);
      print2(m2);
      print2(m3);
      System.out.print("testing sum1...\n");
      System.out.println("sum m1 : " + sum1(m1) + " ... should be 0");
      System.out.println("sum m2 : " + sum1(m2) + " ... should be 27");
      System.out.println("sum m3 : " + sum1(m3) + " ... should be 21");

      System.out.print("testing sum2...\n");
      System.out.println("sum m1 : " + sum2(m1) + " ... should be 21");
      System.out.println("sum m2 : " + sum2(m2) + " ... should be 21");
      System.out.println("sum m3 : " + sum2(m3) + " ... should be 21");

      System.out.print("testing sumRow2...\n");
      System.out.println("sumRow2 m1 r0 : " + sumRow2(0,m1) + " ... should be 0");
      System.out.println("sumRow2 m2 r0: " + sumRow2(0,m2) + " ... should be 12");

  }

}//end class TwoDimArray

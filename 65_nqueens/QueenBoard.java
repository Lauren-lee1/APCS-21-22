/***
TNPG: Pikovo (Lauren Lee, Jack Chen)
APCS
HW65 -- How Many Queens Can a Thinker Place, If a Thinker Can Place Queens...
2022-02-16
time spent: 1 hr
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Transcribe your KtS verbiage into block comments preceding each method where necessary.
 * 2. Implement solver method.
 * DISCO:
 * A wrapper class is a method that calls a helper method
 * simple is better
 * You can use recursion in a for loop
 * base case is when recursive call should end

 * QCC:
 * The current solve method starts from the upper-leftmost corner of the board. Would it be possible to devise a solution that
 starts from another row in that leftmost column? 
 */

public class QueenBoard
{

  private int[][] _board;

  public QueenBoard( int size )
  {
    _board = new int[size][size];
  }


  /***
   * precondition: board is filled with 0's only.
   * postcondition:
   * If a solution is found, board shows position of N queens,
   * returns true.
   * If no solution, board is filled with 0's,
   * returns false.
   */
  public boolean solve()
  {
    return solveH(0);

  } // lazy ass function that wraps and calls the helper method. not recursive ):<


  /**
   *Helper method for solve.
   */
  private boolean solveH( int col )
  {
    if (col == _board.length) {
      return true;
    } // base case
    for(int i = 0 ; i < _board.length; i++){
      if ((addQueen(i,col))) {
        if (solveH(col + 1)) {
          return true;
        }
        else {
          removeQueen(i,col);
        }
      }

    } // why the for loop then? :0
    return false;


  }


  public void printSolution()
  {
    for (int i = 0 ; i< _board.length ; i++){
      String row = "";
      for (int n = 0; n < _board[i].length; n++){
        if (_board[i][n] != 1) {
          row = row + " _ ";
        } else {
          row = row + " Q ";
        }
      }
      System.out.println(row);
      row = "";
    }
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * If a space is unoccupiable, represented by 1 or -1, then no queen can be placed and the method returns false.
    Otherwise, the indicated space would be replaced by a 1 (the queen) and spaces to the row right of the queen and diagonal
    going right-down nd left-up will be assigned -1, then returns true.

   * precondition: Row and Col must be less than board.length
                   Start from the leftmost row
   * postcondition: A queen is placed at the position indicated by a 1 if it is
   and occupiable space. All spaces that the queen can attack are replaced with -1
   to indicate that they are unoccupiable
   */
  private boolean addQueen(int row, int col)
  {
    if(_board[row][col] != 0){
      return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
      _board[row][col+offset]--;
      if(row - offset >= 0){
        _board[row-offset][col+offset]--;
      }
      if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
      }
      offset++;
    }
    return true;
  }


  /***
   * If the space is not occupied, indicated by a 0, or it is unoccupiable, represented by a -1, nothing
   happens and it returns false. If the space has a queen, indicated by 1, the space occupied by the queen
   would be replaced by a 0, making it occupiable. The diagnols and rows the queen was able to attack would be also
   turned into occupiable 0s and true is returned.

   * precondition: Row and Col must be less than board.length
   * postcondition: If there is a queen at the space indicated by 1, the queen would be removed by replacing it with a 0
   and the spaces where the queen could attack, indicated by -1, would be turned into a 0, making them occupiable again.
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
      return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
      _board[row][col+offset]++;
      if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
      }
      if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
      }
      offset++;
    }
    return true;
  }


  /***
   * <General description>
   * precondition: String ans is initialized as an empty string. Must have something you can string.
   * postcondition: String ans would contain the board, each row and its contents is it's own separate line.
   */
  public String  toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
      }
      ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    QueenBoard c = new QueenBoard(5);
    QueenBoard d = new QueenBoard(8);
    System.out.println(b);
    /** should be...
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
    */

    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    /** should be...
       0	1	-1	-2	-1
       0	0	-2	0	0
       0	-1	0	-1	0
       1	-1	-1	-1	-2
       0	-1	0	0	0
    */

    b.removeQueen(3,0);
    System.out.println(b);
    /** should be...
       0	1	-1	-1	-1
       0	0	-1	0	0
       0	0	0	-1	0
       0	0	0	0	-1
       0	0	0	0	0
    */
  c.solve();
  c.printSolution();

  d.solve();
  d.printSolution();

  }

}//end class


import java.io.*;
import java.io.IOException;

public class MazeGenerator{

  private char[][] _maze;
  private int h, w;
  private int sideh, sidew;

  final private char HERO =           '@';
  final private char PATH =           '#';
  final private char WALL =           ' ';
  final private char EXIT =           '$';
  final private char VISITED_PATH =   '.';

  public MazeGenerator(){
    h=5;
    sideh = h+2;
    w=4;
    sidew = w+2;
    _maze = new char[100][100];

    for( int i=0; i<sideh; i++){
        for (int n=0; n<sidew; n++){
          _maze[i][n] = WALL;
        }
    }
/*
h+2
h+1
*/
    for( int i=1; i<sideh-1; i++){
        for (int n=1; n<sidew-1; n++){
          _maze[i][n] = PATH;
        }
    }
    _maze[(int) (Math.random()*h) +1][(int) (Math.random()*w) +1] = EXIT;

  }

  public MazeGenerator(int x, int y){
    h=x;
    sideh = h+2;
    w=y;
    sidew = w+2;

    _maze = new char[100][100];

    for( int i=0; i<sideh; i++){
        for (int n=0; n<sidew; n++){
          _maze[i][n] = WALL;
        }
    }
  //  addPath(randomx, randomy);

    for( int i=1; i<=sideh-1; i++){
        for (int n=1; n<=sidew-1; n++){
          int random = (int) (Math.random()*2);
          if (random == 0){
            _maze[i][n] = PATH;
          }
        }
    }

    _maze[(int) (Math.random()*h) +1][(int) (Math.random()*w) +1] = EXIT;

  }
/*
  public  void addPath(int x, int y){
    if (x == 0 || x == h+1 || y == 0 || y == h+1){
      System.out.println("t");
      return;
    }
    else if (_maze[x+1][y] == PATH || _maze[x-1][y] == PATH || _maze[x][y+1] == PATH|| _maze[x][y-1] == PATH){
      System.out.println("u");
      return;
    }
    else if (_maze[x][y] == EXIT){
      System.out.println("i");
      return;
    } else{
      _maze[x][y] = PATH;
      addPath(x+1,y);
      addPath(x-1,y);
      addPath(x,y+1);
      addPath(x,y-1);
    }
  }
  */
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, ESC
    //emacs shortcut: M-x quoted-insert, ESC

    int i, j;
    for( i=0; i<sideh; i++ ) {
      for( j=0; j<sidew; j++ )
        retStr = retStr + _maze[j][i];
      retStr = retStr + "\n";
    }
    return retStr;
  }

  public File makeFile(String txt){
    String retStr = "";
    int i, j;
    for( i=0; i<sideh; i++ ) {
      for( j=0; j<sidew; j++ )
        retStr = retStr + _maze[j][i];
      retStr = retStr + "\n";
    }

      File maze = new File(txt);
    try{
      FileWriter writer = new FileWriter(txt);
      writer.write(retStr);
      writer.close();
    } catch (IOException e){
      System.out.println("error");
    }
    return maze;
  }

  public static void main(String[] args){
    MazeGenerator maze = new MazeGenerator(19,20);
    System.out.println( "[2J" );
    System.out.println(maze);

  }


}

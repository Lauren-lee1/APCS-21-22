
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
          _maze[i][n] = VISITED_PATH;
        }
    }

    for( int i=1; i<sideh-1; i++){
        for (int n=1; n<sidew-1; n++){
          _maze[i][n] = PATH;
        }
    }

    int exith = (int) (Math.random()*h) +1;
    int exitw = (int) (Math.random()*w) +1;
    _maze[exith][exitw] = EXIT;

    int pathh = (int) (Math.random()*h) +1;
    int pathw = (int) (Math.random()*w) +1;

    makePath(pathh, pathw);

    for( int i=0; i<sideh; i++){
        for (int n=0; n<sidew; n++){
          if (_maze[i][n]==VISITED_PATH){
            _maze[i][n] = WALL;
          }
        }
    }

  }

  public MazeGenerator(int x, int y){
    h=x;
    sideh = h+2;
    w=y;
    sidew = w+2;

    _maze = new char[100][100];

    for( int i=0; i<sideh; i++){
        for (int n=0; n<sidew; n++){
          _maze[i][n] = VISITED_PATH;
        }
    }

    for( int i=1; i<sideh-1; i++){
        for (int n=1; n<sidew-2; n++){
          _maze[i][n] = WALL;
        }
    }

    int exith = (int) (Math.random()*h) +1;
    int exitw = (int) (Math.random()*w) +1;
    _maze[exith][exitw] = EXIT;

    int pathh = (int) (Math.random()*h) +1;
    int pathw = (int) (Math.random()*w) +1;

    makePath(pathh, pathw);

    for( int i=0; i<sideh; i++){
        for (int n=0; n<sidew; n++){
          if (_maze[i][n]==VISITED_PATH){
            _maze[i][n] = WALL;
          }
        }
    }

  }

  public void makePath(int x, int y){
    if (_maze[x][y] == EXIT){
      System.exit(0);
    } else if (_maze[x][y] == VISITED_PATH){
      if (_maze[])
    } else if(_maze[x][y+1] == PATH && _maze[x-1][y+1] == PATH){
      _maze[x][y] = PATH;
      System.out.println( this );
      int rand = (int) (Math.random()*2);
      if (rand == 0){
        makePath(x,y-1);
      } else{
        makePath(x+1,y);
      }
    } else if(_maze[x+1][y] == PATH && _maze[x+1][y-1] == PATH){
      _maze[x][y] = PATH;
      System.out.println( this );
      int rand = (int) (Math.random()*2);
      if (rand == 0){
        makePath(x,y+1);
      } else{
        makePath(x-1,y);
      }
    } else if(_maze[x][y+1] == PATH && _maze[x+1][y+1] == PATH){
      _maze[x][y] = PATH;
      System.out.println( this );
      int rand = (int) (Math.random()*2);
      if (rand == 0){
        makePath(x,y-1);
      } else{
        makePath(x-1,y);
      }
    } else if(_maze[x-1][y] == PATH && _maze[x-1][y-1] == PATH){
      _maze[x][y] = PATH;
      System.out.println( this );
      int rand = (int) (Math.random()*2);
      if (rand == 0){
        makePath(x,y+1);
      } else{
        makePath(x+1,y);
      }
    } else if(_maze[x][y-1] == PATH && _maze[x+1][y-1] == PATH){
      _maze[x][y] = PATH;
      System.out.println( this );
      int rand = (int) (Math.random()*2);
      if (rand == 0){
        makePath(x,y+1);
      } else{
        makePath(x-1,y);
      }
    } else if(_maze[x-1][y] == PATH && _maze[x-1][y+1] == PATH){
      _maze[x][y] = PATH;
      System.out.println( this );
      int rand = (int) (Math.random()*2);
      if (rand == 0){
        makePath(x,y-1);
      } else{
        makePath(x+1,y);
      }
    } else if(_maze[x][y-1] == PATH && _maze[x-1][y-1] == PATH){
      _maze[x][y] = PATH;
      System.out.println( this );
      int rand = (int) (Math.random()*2);
      if (rand == 0){
        makePath(x,y+1);
      } else{
        makePath(x+1,y);
      }
    } else if(_maze[x+1][y] == PATH && _maze[x+1][y+1] == PATH){
      _maze[x][y] = PATH;
      System.out.println( this );
      int rand = (int) (Math.random()*2);
      if (rand == 0){
        makePath(x,y-1);
      } else{
        makePath(x-1,y);
      }
    } else {
      _maze[x][y] = PATH;
      System.out.println( this );
      int rand = (int) (Math.random()*4);
      if (rand == 0){
        makePath(x,y+1);
      } else if (rand == 1){
        makePath(x,y-1);
      } else if (rand == 2){
        makePath(x+1,y);
      } else {
        makePath(x-1,y);
      }
    }
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

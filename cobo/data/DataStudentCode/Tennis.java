import core.data.*;
import java.util.ArrayList;

public class Tennis{

  public static void main(String[] arg){
    /*
    Scanner tennis = new Scanner(new File(atp_matches_2017.csv))
    tennis.useDelimiter(",");
    while (tennis.hasNext()){
      System.out.println(tennis.next);
    }
    */
    DataSource ds = DataSource.connect("atp_matches_2017.xml").load();
    Tournament[] data = ds.fetchArray("Tournament","row/tourney_name", "row/winner_name");
    String tournament;
    String winner;
    int nadalCounter=0;
    int djokCounter = 0;
    int fedCounter = 0;
    for (Tournament x : data){
      winner = x.getWinner();
      if(winner.equals("Rafael Nadal")){
        nadalCounter++;
      }
      if(winner.equals("Novak Djokovic")){
        djokCounter ++;
      }
      if(winner.equals("Roger Federer")){
        fedCounter++;
      }
    }
    if (nadalCounter>djokCounter){
      if(nadalCounter>fedCounter){
        System.out.println("Nadal is the GOAT");
      }else{
        System.out.println("Federer is the GOAT");
      }
    } else{
      if(djokCounter>fedCounter){
        System.out.println("Djokovic is the GOAT");
      } else{
        System.out.println("Federer is the GOAT");
      }
    }
    //System.out.println("Total stations: " + allstns.length);
  }

}

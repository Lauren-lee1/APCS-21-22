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
    Tournament[] data = ds.fetchArray("Tournament","tourney_name", "winner_name");
    String tournament;
    String winner;
    for (Tournament x : data){
      tournament = x.getName();
      winner = x.getWinner();
      System.out.println(winner + " won " + tournament);
    }
    //System.out.println("Total stations: " + allstns.length);
  }
  public class Tournament{
    private String _name;
    private String _winName;

    public Tournament(String name, String winner){
      this._name = name;
      this._winName = winner;
    }

    public String getName(){
      return this._name;
    }

    public String getWinner(){
      return this._winName;
    }

  }
}

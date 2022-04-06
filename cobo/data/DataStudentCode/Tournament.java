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

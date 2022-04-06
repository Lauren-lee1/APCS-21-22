public class Cereal{
  private char _type;
  private int _calories;
  private int[] _nutrition = new int[8];
  private int _shelf;
  private double _weight;
  private double _cups;
  private double _rating;
//CONSTRUCTOR
  public Cereal( char _type, int _calories, int[] _nutrition, int _shelf, double _weight, double _cups, double _rating) {
    this._type = _type;
    this._calories = _type;
    this._nutrition = _nutrition;
    this._shelf = _shelf;
    this._weight = _weight;
    this._cups = _cups;
    this._rating = _rating;
  }
//ACCESSOR
  public char getType(){
    return this._type;
  }

  public int getCalories(){
    return this._calories;
  }

  public int getProtein(){
    return this._nutrition[0];
  }

  public int getFat(){
    return this._nutrition[1];
  }

  public int getSodium(){
    return this._nutrition[2];
  }

  public int getFiber(){
    return this._nutrition[3];
  }

  public int getCarbohydrates(){
    return this._nutrition[4];
  }

  public int getSugar(){
    return this._nutrition[5];
  }

  public int getPotassium(){
    return this._nutrition[6];
  }

  public int getVitamins(){
    return this._nutrition[7];
  }

  public int getShelf(){
    return this._shelf;
  }

  public double getWeight(){
    return this._weight;
  }

  public double getCups(){
    return this._cups;
  }

  public double getRating(){
    return this._rating;
  }

  public String toString(){
    return "Count Chocula: \nType: " + (char)getType() + "\nCalories: " + getCalories() +  "\nProtein: " + getProtein() + "\nFat: " + getFat() + "\nSodium: " + getSodium() + "\nFiber: "+ getFiber() + "" + "\nCarbs: " + getCarbohydrates() + "\nSugar: " + getSugar() + "\nPotassium: " + getPotassium() + "\nVitamins: " + getVitamins() + "\nShelf: " + getShelf() + "\nWeight: " + getWeight() + "\nCups: " + getCups() + "\nRating: " + getRating(); //FINISH LATER
  }

  public static void main(String[] args){

    int[] countChocData = new int[]{3, 3, 140, 4, 10, 7, 160, 160, 25};
    Cereal countChocula = new Cereal('C', 110, countChocData, 3, 1, 0.5, 40.448772);
    System.out.println(countChocula);

  }

}

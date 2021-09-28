public class Date{
  public static void main(String[] args){

    //initializing and declaring variables
    String day = "Sunday"; //initilizes and declares day
    String month = "August"; //initilizes and declares day
    int date = 22; //initilizes and declares day
    int year = 2021; //initilizes and declares day

    //American format of day, month date, year.
    System.out.println("American format:"); //prints the heading
    System.out.print(day); //prints the day
    System.out.print(", ");
    System.out.print(month); //prints the day
    System.out.print(" " + date); //prints the day
    System.out.print(", ");
    System.out.println(year); //prints the day

    //European format of day date month and year
    System.out.println("European format:"); //prints the heading
    System.out.print(day + " "); //prints the day
    System.out.print(date + " "); //prints the day
    System.out.print(month + " "); //prints the day
    System.out.println(year); //prints the day
  }
}

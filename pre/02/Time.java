public class Time{
  public static void main(String[] args){
    //initialize and declare variables
      int hour = 21;
      int minute = 21;
      int second = 1;
    // calculate seconds in hour and minute
      int hourSec = hour * 60 *60;
      int minuteSec = minute * 60;
    //print seconds in total
      int totalSec = (minuteSec + hourSec + second);
      System.out.println(totalSec);
    //remainging seconds in the day
      int daySec = 86400;
      int remaingingSec =  daySec - totalSec;
      System.out.println(remaingingSec);
    //percentage of seconds passed
      double percentage = totalSec * 100/ 86400;
      System.out.println(percentage);

    //initialize and declare variables of time now
      int hourNow = 21;
      int minuteNow = 42;
      int secondNow = 23;
    // calculate seconds in hour and minute
      int hourSecNow = hourNow * 60 *60;
      int minuteSecNow = minuteNow * 60;
    //print difference
      int totalSecNow = (minuteSecNow + hourSecNow + secondNow);
      System.out.println(totalSecNow-totalSec);
  }
}

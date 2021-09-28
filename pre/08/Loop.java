public class Loop{
  public static String stringTimes(String str, int n) {
    int counter = 0;
    String copy = "";
    while (counter < n) {
      copy = str + copy;
      counter=counter+1;
    }
    return copy;
    }
}

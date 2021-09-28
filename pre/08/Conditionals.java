public class Conditionals{

  public static int oddsAreNegated(int x){
    int division = x % 2;
    if (division == 1 || division == -1) {
      return x*-1;
    } else {
      return x;
    }
  }

    public static int fixTeen(int n) {
      if (n == 13 || n==14 || n==17 || n==18 || n==19) {
        n=0;
      } else {
        n = n ;
        }
        return n;
    }

}

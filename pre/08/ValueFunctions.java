public class ValueFunctions{

  public static double force(double g, double m1, double m2, double r){
    return ((g*(m1*m2))/(r*r));
  }

  public static double average3(int a, int b, int c){
    double x = (double) a;
    double y = (double) b;
    double z = (double) c;
    return (x+y+z)/3;
  }
  public static double sumOfSines(double t){
    double radians = t*(Math.PI/180);
    double value = Math.sin(2*radians)+Math.sin(3*radians);
    return (Math.round(value*1000.000))/1000.000;
  }

}

import java.util.Random;

public class Arrays{

  public static void main(String[] args) {
    System.out.println("Exercise 1 part 1");
    //create a small array for test
    double[] d = new double[3];
    d[0] = 1;
    d[1] = 3;
    d[2] = 2;
    powArray(d,3);
    System.out.println("Exercise 1 part 2");
    histogram(10, 10); //an array of ten numbers with ten counters
    System.out.println("Exercise 4");
    //create a small array for a test
    int[] b = new int[3];
    b[0] = 1;
    b[1] = 3;
    b[2] = 2;
    System.out.println(indexOfMax(b));
    System.out.println("Exercise 5");
    printBooArray(sieve(10));
  }

  //exercise 1, part 1
  //raises all the values of an array to the power inputed
  public static void powArray(double[] a, double power) {
    System.out.print("{" + Math.pow(a[0], power));
    for (int i = 1; i < a.length; i++) {
      a[i] = Math.pow(a[i], power);
      System.out.print( ", " + a[i]);
    }
    System.out.println("}");
  }


  //exercise 1, part 2
  public static void histogram(int size, int counters) {
    int [] random = randomArray(size); //creates a randomly generated array with the size a inputed
    int[] counts = new int[100]; //creates an array of 100 for the highest score of 100
    int interval = 100/counters; //finds the interval using counters
    System.out.print("{" + inRange(random, 0, interval+1)); //first term
    int original = interval; //makes interval a constant in original
    for (int i = 1; i < counters; i++) {
      counts[i] = inRange(random, interval, interval + original + 1);
      interval=interval+original; //keeps adding to the interval each round
      System.out.print( ", " + counts[i]);
    }
    System.out.println("}");
  }

  // generates a random array given a size
  public static int[] randomArray(int size) {
    Random random = new Random();
    int[] a = new int[size];
    for (int i = 0; i < a.length; i++) {
        a[i] = random.nextInt(100); //all numbers out of 100
    }
    return a;
}
  //counts the number of values in a range
  public static int inRange(int[] a, int low, int high) {
    int count = 0;
    for (int i = 0; i < a.length; i++) {
        if (a[i] >= low && a[i] < high) {
          count++;
          }
        }
  return count;
  }

//exercise 4
//finds the index of the max value in the array
//enhanced for loop not helpful if refering to index
  public static int indexOfMax (int[] a){
    int current = 0;
    //use a for loop to find the max
    for (int i = 0; i < a.length; i++) {
      if (a[i] > current) { //can't use the enhanced for loop bc of the if statement here
        current = a[i];
      }
    }
    //use a while loop to find the index of the max
    int n = -1;
    while (n < a.length) {
      n=n+1;
      if (current != a[n]) {
        continue;
      } else{
        break;
      }
    }
    return n;
  }

//exercise 5
//outputs an array indicating if each element in an array is prime
  public static boolean[] sieve(int n) {
    int [] orderedArray = new int[n]; //makes the array from 0-(n-1)
    boolean[] booleanArray = new boolean[n]; //makes a boolean array with n values

    for (int i = 0; i<orderedArray.length; i=i+1) {
      orderedArray[i] = i; //each element is true or false using isPrime
    }

    for (int i = 2; i < booleanArray.length; i++) {
      booleanArray[i] = true;
    }

    for ( int i : orderedArray) { // i = base prime number
      if (booleanArray[i]) { //checks if prime
        for (int x : orderedArray) { //sieve ;; x= every number to check if multiple
          if (x>i && x%i == 0) {
            booleanArray[x] = false;
          }
        }
      }
    }
    return booleanArray;
  }


  //print a boolean array
  public static void printBooArray(boolean[] a) {
      System.out.print("{" + a[0]);
      for (int i = 1; i < a.length; i++) {
          System.out.print(", " + a[i]);
      }
      System.out.println("}");
  }

}

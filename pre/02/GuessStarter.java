import java.util.Random;
import java.util.Scanner;

public class GuessStarter {

  public static void main(String[] args){

    //generate a random number
    Random random = new Random();
    int number = random.nextInt(100) + 1;
    Scanner in = new Scanner(System.in);

    //ask for a guess
    System.out.println("I'm thinking of a number between 1 and 100");
    System.out.println("Can you guess what it is?");
    System.out.println("Type a number:");
    int guess = in.nextInt();

    //compute the difference
    System.out.println("Your guess is: " + guess);
    System.out.println("The number I was thinking of is: " + number);
    System.out.println("You were off by: " + (guess-number));
  }
}

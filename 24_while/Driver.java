public class Driver {

  public static void main( String[] args ) {

    //build Objects from blueprint specified by class Coin


    //test default constructor
      Coin mine = new Coin();
      //test 1st overloaded constructor
      Coin yours = new Coin( "quarter" );
      //test 2nd overloaded constructor
      Coin wayne = new Coin( "dollar", "heads" );
      //test toString() methods of each Coin
      System.out.println("mine: " + mine);
      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);
      //test flip() method
      System.out.println("\nAfter flipping...");
      yours.flip();
      wayne.flip();
      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);
      //test equals() method
      if ( yours.equals(wayne) ) {
        System.out.println( "Matchee matchee!" );
      }
      else {
        System.out.println( "No match. Firestarter you can not be." );
      }

	mine.reset("heads", 0.5);
	yours.reset("heads",0.5);
	int matchCounter = 0;
	while (matchCounter <  65536 && matchCounter % 2005 != 0){
		mine.flip();
		yours.flip();
		if (yours.equals(mine) == true) {
			matchCounter = matchCounter + 1;
		}
	}
	int totalHeads =  yours.getHeadsCtr() + mine.getHeadsCtr();
	System.out.println(yours.getHeadsCtr() + mine.getHeadsCtr() + " heads have come up" + "\n" + matchCounter + " matches have occured");
  }//end main()

}//end class

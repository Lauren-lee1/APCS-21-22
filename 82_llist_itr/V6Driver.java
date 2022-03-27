/***
 * class V6Driver
 * ...for testing implementation of Iterable interface
 *    (ability to run a FOREACH loop over your LList)
 *
 * Assumes local version of List.java, overriding Java standard library interface
 **/

public class V6Driver
{
  public static void main( String[] args )
  {
    List<String> wu = new LList<String>();

    System.out.println(wu);
    wu.add("RZA");
    System.out.println(wu);
    wu.add("GZA");
    System.out.println(wu);
    wu.add("ODB");
    System.out.println(wu);
    wu.add("Inspectah Deck");
    System.out.println(wu);
    wu.add("Raekwon the Chef");
    System.out.println(wu);
    wu.add("U-God");
    System.out.println(wu);
    wu.add("Ghostface");
    System.out.println(wu);
    wu.add("Method Man");
    System.out.println(wu);

    for( String s : wu ) {
      System.out.println( s + " raps for the Wu");
    }
    System.out.println(wu);
  }//end main()

}//end class

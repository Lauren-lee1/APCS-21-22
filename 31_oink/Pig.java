/***
 * Clueless Cats: Lauren Lee + Bo, Vansh Saboo + Tiffany, Diana Akhmedova + Ajax
 * APCS
 * HW31 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
 * 2021-11-04
 * time spent: _hrs
 *
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

/**
DISCO:
- we can use String.toLowerCase() to make all letters of a string lowercase
- we can call other methods within methods other than the main method
-
QCC
- can we assume that the vowels will always be lowercase, or do we need to include the .toLowercase()?
**/
public class Pig
{
  //Q: How does this initialization make your life easier?
  private static final String VOWELS = "aeiou";


  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter )
  {
	w  =  w.toLowerCase();
	for (int i = 0; i<w.length(); i=i+1){
		if (w.substring(i, i+1).equals(letter)){
			return true;
		}
	}
	return false;
  }//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter )
  {
	letter = letter.toLowerCase();
	for (int i = 0; i<VOWELS.length(); i=i+1){
		if (letter.equals(VOWELS.substring(i,i+1))){
			return true;
		}
	}
	return false;
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w )
  {
	int counter = 0;
	for (int i = 0; i<w.length(); i=i+1){
		if (isAVowel(w.substring(i,i+1))==true){
			counter = counter + 1;
		}
	}
	return counter;
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w )
  {
	if (countVowels(w) > 0){
		return true;
	}else {
		return false;
	}
  }


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w )
  {
	String output = "";
	if (hasAVowel(w) == false) {
		return null;
	} else{
		for  ( int i = 0; i<VOWELS.length(); i = i+1){
			for (int n = 0; n<w.length(); n = n+1){
				if (hasA(w.substring(n, n+1), VOWELS.substring(i,i+1)) == true){
					output = output + VOWELS.substring(i,i+1);
				}
			}
		} return output;
	}
  }


  public static void main( String[] args )
  {
	System.out.println();
	System.out.println("tests hasA()");
	System.out.println(hasA("cat", "a") + " ...should be true");
	System.out.println(hasA("pill", "c") + " ...should be false");
	System.out.println(hasA("Apple", "a") + " ...should be true"); //tests uppercase vowel

	System.out.println();
	System.out.println("tests isAVowel()");
	System.out.println(isAVowel("a") + " ... should be true");
	System.out.println(isAVowel("p") + " ... should be false");
	System.out.println(isAVowel("A") + " ...should be true"); //tests uppercase vowel

	System.out.println();
	System.out.println("tests countVowels()");
	System.out.println(countVowels("career")  + " ...should be 3");
	System.out.println(countVowels("wqpd") + " ...should be 0"); //tests no vowels
	System.out.println(countVowels("CAREER") + " ...should be 3"); //test uppercase vowel

	System.out.println();
	System.out.println("tests hasAVowel()");
	System.out.println(hasAVowel("career") + " ... should be true");
	System.out.println(hasAVowel("wqpd") + " ... should be false");
	System.out.println(hasAVowel("CAREER") + "... should be true"); //test upppercase

	System.out.println();
	System.out.println("tests allVowels()");
	System.out.println(allVowels("career") + " ... should be aee");
	System.out.println(allVowels("wqpd") + " ...should be null");
	System.out.println(allVowels("CAREER") + " ... should be aee");
  }//end main()

}//end class Pig

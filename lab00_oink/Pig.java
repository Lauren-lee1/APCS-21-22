
   
/**
Ellowyay Unflowersay Arlkesspay (Yellow Sunflower Sparkles)
Diana Akhmedova + Ajax, Lauren Lee + Bo, Emily Ortiz + Applesauce
APCS
L00: Etterbay Odingcay Oughthray Ollaborationcay
2021-11-09
Time Spent: 4.5 hours
DISCO:
- hasNext() checks if the Scanner has another token in its input.
- scanner.next finds and returns the next complete token.
QCC:
- Having issues with letter y, but it was working in v1.
- We looked through the sentence to try to find other spaces or punctuation (that would mean there is a new word), then translate the word and put the space/punctuation at the end but it did not work.
HOW WE UTILIZED SCANNER DEMO (v3):
- We used Scanner demo to check if the Scanner has another token in its input and used a while loop to find + return the next complete token.
WHAT CAUSES THE RUNTIME ERROR IN THE SCANNER DEMO:
- The runtime error in the Scanner demo occurs since the hasNext() method is never false, and it is in a while loop, meaning it will forever loop unless you do ctrl+C (^C).
NEW IN V3:
- Added Scanner + a while loop in our main method.
- Added punctuation at the end of the translated word/phrase.
**/

import java.util.Scanner;

public class Pig {

    private static final String VOWELS = "aeiouyAEIOUY";
    private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String PUNCS = ".,:;!?";

  /**
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p") -> false
  **/

  public static boolean hasA( String w, String letter ) {
    return w.indexOf(letter) != -1;
  }

  /**
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
  **/

  public static boolean isAVowel( String letter ) {
    return VOWELS.indexOf( letter ) != -1;
  }

  /**
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
  **/

  public static int countVowels( String w ) {
    return allVowels(w).length();
  }

  /**
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz") -> false
  **/

  public static boolean hasAVowel( String w ) {
    return w.indexOf(w) >= 0;
  }

  /**
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
  **/

  public static String allVowels( String w ) {
    String ans = ""; //init return String

    for( int i = 0; i < w.length(); i++ ) {
      if ( isAVowel( w.substring(i,i+1) ) )
        ans += w.substring( i, i+1 ); //grow the return String
    }
    return ans;
  }

  /**
    String firstVowel(String) -- returns first vowel in a String
    pre:  w != null
    post: firstVowel("") --> ""
    firstVowel("zzz") --> ""
    firstVowel("meatball") --> "e"
  **/

  public static String firstVowel( String w ) {
    String ans = "";

    if ( hasAVowel(w) ) //Q: Why this necess?
      ans = allVowels(w).substring(0,1);
    return ans;
  }

  /**
    boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
    pre:  w != null and w.length() > 0
    post: beginsWithVowel("apple")  --> true
    beginsWithVowel("strong") --> false
  **/

  public static boolean beginsWithVowel( String w ) {
    return isAVowel( w.substring(0,1) );
  }

    /*=====================================
      boolean isPunc(String) -- tells whether a character is punctuation
      pre:  symbol.length() == 1
      post: isPunc(".") -> true
            isPunc("b") -> false
      =====================================*/

    public static boolean isPunc( String symbol ) {
	     return PUNCS.indexOf( symbol ) != -1;
    }

    /*=====================================
      boolean isUpperCase(String) -- tells whether a letter is uppercase
      pre:  letter.length() == 1
      post: isUpperCase("a") -> false
            isUpperCase("A") -> true
      =====================================*/

    public static boolean isUpperCase( String letter ) {
        return hasA(CAPS, letter);
    }

    /*=====================================
      boolean hasPunc(String) -- tells whether a String contains punctuation
      pre:  w != null
      post: hasPunc("cat.") -> true
            hasPunc("cat") -> false
      =====================================*/

    public static boolean hasPunc( String w ) {
        for (int i = 0; i < w.length(); i++){
          String letter = w.substring(i, i+1);
          if (hasA(PUNCS, letter)){
            return true;
          }
        }
        return false;
    }

    /*=====================================
      boolean beginsWithUpper(String) -- tells whether 1st letter is uppercase
      pre:  w != null and w.length() > 0
      post: beginsWithUpper("Apple") -> true
            beginsWithUpper("apple") -> false
      =====================================*/

    public static boolean beginsWithUpper( String w ) {
	     return isUpperCase(w.substring(0,1) );
    }

    /**
      String engToPig(String) -- converts an English word to Pig Latin
      pre:  w.length() > 0
      post: engToPig("apple")  --> "appleway"
      engToPig("strong") --> "ongstray"
      engToPig("java")   --> "avajay"
    **/

  public static String engToPig( String og ) {
    String ans = "";
    String w = og.toLowerCase();
    String output = "";

    for( int i = 0; i < w.length(); i++ ) {
      if( isAVowel(w.substring(i,i+1)) ) {
        if( i == 0 && isAVowel(w.substring(i,i+1)) && !(w.substring(i,i+1).equals("y")) ) {
          ans = w + "way";
          if (beginsWithUpper(og)){ ans = Capitalize (ans); }
          if (hasPunc(w)) {
            String punc = w.substring(w.length()-1);
            ans = w.substring(0,w.length()-1) + "way" + punc;
          }
          return ans;
        }
        else if( i != 0 && isAVowel(w.substring(i,i+1)) && !(w.substring(i,i+1).equals("y")) ) {
          ans = w.substring(i) + w.substring(0,i) + "ay";
          if (beginsWithUpper(og)){ ans = Capitalize (ans); }
          if (hasPunc(w)) {
            String punc = w.substring(w.length()-1);
            ans = w.substring(0,w.length()-1) + "ay" + punc;
          }
          return ans;
        }
        else {
          ans = w.substring(i) + w.substring(0,i) + "ay";
          if (beginsWithUpper(og)){ ans = Capitalize (ans); }
          if (hasPunc(w)) {
            String punc = w.substring(w.length()-1);
            ans = w.substring(0,w.length()-1) + "ay" + punc;
          }
          return ans;
        }
      }
    }
    if (beginsWithUpper(og)){ ans = Capitalize (ans); }
    return ans;
  }

/*
TEST:
    if ( beginsWithVowel(w) ) {
      ans = w + "way";
    }
    else {
      int vPos = w.indexOf( firstVowel(w) );
      ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
    }
    if (beginsWithUpper(w)) {
      ans = Capitalize (ans);
    }
    if( hasPunc(w) ) {
      String punc = w.substring(w.length()-1);
      ans = w + punc;
    }
    return ans;
  }
*/

/*
Ideas for translating a whole sentence:
for loop through every character in sentence
if character = space or punctuation,
String word = sentence.substring(0, i)
run the original for loop with word
output += wordtranslation + character at index i
sentence = sentence.substring (i+1)
keep going through for loop
*/

/*
    for (int j = 0; j < sentence.length(); j++){
      if ( isPunc(sentence.substring(j, j+1)) || sentence.substring(j, j+1).equals(" ") ) {
        String w = sentence.substring(0, j);
        for( int i = 0; i < w.length(); i++ ) {
          if( isAVowel(w.substring(i,i+1)) ) {
              if( i == 0 && isAVowel(w.substring(i,i+1)) && !(w.substring(i,i+1).equals("y")) ) {
                ans = w + "way";
                if (beginsWithUpper(og)){ ans = Capitalize (ans); }
              }
              else if( i != 0 && isAVowel(w.substring(i,i+1)) && !(w.substring(i,i+1).equals("y")) ) {
                ans = w.substring(i) + w.substring(0,i) + "ay";
                if (beginsWithUpper(og)){ ans = Capitalize (ans); }
              }
              else {
                ans = w.substring(i) + w.substring(0,i) + "ay";
                if (beginsWithUpper(og)){ ans = Capitalize (ans); }
              }
          } else {
          if (beginsWithUpper(og)){ ans = Capitalize (ans); }
          }
          output += ans + sentence.substring(j,j+1);
          //sentence = sentence.substring(i+1);
        } // close inner for loop
        j = -1;
      } // close first if
    } return output;
  }
*/

  public static String Capitalize(String str){
    String firstLetter = str.substring(0, 1);
    firstLetter = firstLetter.toUpperCase();
    String ans = firstLetter + str.substring(1);
    return ans;
  }

  public static void main( String[] args ) {
    /*
    for( String word : args ) {
      System.out.println( "allVowels \t" + allVowels(word) );
      System.out.println( "firstVowels \t" + firstVowel(word) );
      System.out.println( "countVowels \t" + countVowels(word) );
      System.out.println( "engToPig \t" + engToPig(word) );
      System.out.println( "---------------------" );
    }*/
    Scanner scan = new Scanner(System.in);

    while(scan.hasNext()) {
      System.out.println(engToPig(scan.next()));
    }

  }//end main()

}//end class Pig

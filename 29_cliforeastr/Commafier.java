/**
Clueless Cats: Vansh saboo + Tiffany, Lauren Lee + Bo, Diana Akhmedova + Ajax
APCS
HW29: Which Way Do You Roll?
2021-11-2
**/

/**
DISCO:
- we can't convert an int directly to a String. We have to convert the int to an Integer, then to a string. 
- Integer.parseInt() will take a String input and convert it to an integer
-a for each loop will take the args from the main method parameter which will be a string and do the body
QCC:
-what is the difference between an Integer and an int?
-why can an Integer convert to a String but an int cannot?
**/

public class Commafier{

	public static void main(String[] args){
/**
		System.out.println();

		System.out.println("Recursive");
		System.out.println(commafyR(1));
		System.out.println(commafyR(10));
		System.out.println(commafyR(101));
		System.out.println(commafyR(1000));
		System.out.println(commafyR(12345));

		System.out.println();

		System.out.println("for loop");
		System.out.println(commafyF(1));
		System.out.println(commafyF(10));
		System.out.println(commafyF(101));
		System.out.println(commafyF(1000));
		System.out.println(commafyF(12345));
**/
		for (String test : args) {
			System.out.println(commafyF(Integer.parseInt(test)));
			System.out.println(commafyR(Integer.parseInt(test)));
		}
	}


	public static String commafyR(int num){
		Integer number = num;
        	String strNum = number.toString();
        	if(number < 1000){return strNum; } // 3 digits or less and return the # as-is

		String threeDigits = strNum.substring(strNum.length() - 3) ; // Take the last three digits of the number
        		return (commafyR(num / 1000) + ","  + threeDigits ); // Recursively call the commafyR with n / 1000 to give the digits digits before the last 3, plus a comma and the last three digits
    }

    	public static String commafyF(int num){
        	Integer intNum = num;
        	String strNum = intNum.toString();
        // Get a string for the number

        	if(strNum.length() < 4 ){return strNum;} // Three digits or less and return the number as is

        	String output = "";
        	int xtraNums = strNum.length() % 3; // Modulo for the length - if there's one or two more digits than a multiple of 3, return the first one or two digits

        	if(xtraNums == 0){ // If the number of digits is a multiple of three (like 9 digits or 12 digits), return the first three digits without a comma preceding it, and then add the commas

            		output += strNum.substring(0, 3); // First three digits
            		for(int i = 3; i + 3 <= strNum.length(); i += 3 ){
               			output += "," + strNum.substring(i, i + 3); // Add a comma, then the 3 digit substrings
            		}
        	}
        	else{ // 1 or 2 more digits than a multiple of 3 as many e. g. 7 digits, 8 digits
            		output += strNum.substring(0, xtraNums); // First one or two digits
            		for(int i = xtraNums; i + 3 <= strNum.length() ; i += 3 ){ 
                		output += "," + strNum.substring(i, i + 3);
            		}
        	}
        	return output;
	}

}

public class string{

	public static void main(String [] args){
		System.out.println("Test cases for doublChar()");
		System.out.println(doubleChar("AAbb"));
		System.out.println(doubleChar("Hi-There"));
		
		System.out.println();
		System.out.println("Test cases for countHi()");
		System.out.println(countHi("abc hi ho"));
		System.out.println(countHi("ABChi hi"));
		System.out.println(countHi("hihi"));
		
		System.out.println();
		System.out.println("Test cases for catDog()");
		System.out.println(catDog("catcat"));
		System.out.println(catDog("catcat"));
		System.out.println(catDog("1cat1cadodog"));
		
		System.out.println();
		System.out.println("Test cases for endThere");
		System.out.println(endOther("Hiabc", "abc"));
		System.out.println(endOther("AbC", "HiaBc"));
		System.out.println(endOther("abc", "abXabc"));
		
		System.out.println();
		System.out.println("Test cases for xyzThere()");
		System.out.println(xyzThere("abcxyz"));
		System.out.println(xyzThere("abc.xyz"));
		System.out.println(xyzThere("xyz.abc"));
		
		System.out.println();
		System.out.println("Test cases for bobThere()");
		System.out.println(bobThere("abcbob"));
		System.out.println(bobThere("b9b"));
		System.out.println(bobThere("bac"));
		
	}

	public static String doubleChar(String str){
		int x = 0;
		String output = "";
		while (x<str.length()){
			output = output + str.substring(x, x+1) + str.substring(x, x+1);
			x=x+1;
		}
		output = output + str.substring(x) + str.substring(x);
		return output;
	}
	
	public static int countHi(String str){
		int x = 0;
		int counter = 0;
  		while(x<str.length()-1){
    			if (str.substring(x,x+2).equals("hi")){
      				counter = counter + 1;
     			} 
       		x=x+1;
  		}
  		return counter;
		}
	}

	public static int catDog(String str){
		int catX = 0;
		int catCounter = 0;
  		while(catX<str.length()-2){
  			if (str.substring(catX,catX+3).equals("cat")){
    				catCounter = catCounter + 1;
    			} 
       			catX=catX+1;
    		}
  		int dogX = 0;
  		int dogCounter = 0;
  		while(dogX<str.length()-2){
  	   		if(str.substring(dogX, dogX+3).equals("dog")){
  	       			dogCounter = dogCounter + 1;
      			}
      			dogX=dogX+1;
    		}
  		if (catCounter == dogCounter) {
  			return true;
  		} else {
  			return false;
  		}
	}

	public static boolean endThere(String str) {
		int alen = a.length();
		int blen = b.length();
  		if (blen < alen){
			if (a.substring(alen-blen).toLowerCase().equals(b.toLowerCase())){
				return true;
			} else {
				return false;
			}
		} else if (alen < blen) {
			if (b.substring(blen-alen).toLowerCase().equals(a.toLowerCase())){
				return true;
			} else {
				return false;
			}
		} else {
			if (a.equals(b)){
				return true;
			} else {
				return false;
			}
		}
	
	publci static boolean xyzThere(String str) {
		if (str.length()<3){
			return false;
		}else if (str.length() > 2) {
			if (str.substring(0,3).equals("xyz")){
				return true;
			}else{
				int x= 1;
				while (x < str.length()-2){
					if (str.substring(x, x+3).equals("xyz")){
						if (!(str.substring(x-1,x).equals("."))){
							return true;
						}
					} x = x+1;
				}
			} 
		}return false;
	}
		
	public static boolean bobThere(String str){
	  	int x = 0;
  		while(x<str.length()-2){
    			if (str.substring(x,x+1).equals("b") && str.substring(x+2,x+3).equals("b")){
      				return true;
     			} 
       		x=x+1;
  		}
  		return false;
	}
		
		
}
		

public class string{

	public static void main(String [] args){
		System.out.println("Test cases for doublChar()");
		System.out.println(doubleChar("AAbb"));
		System.out.println(doubleChar("Hi-There"));
	}

	public static String doubleChar(String str){
		int x = 0;
		String output = "";
		while (x<str.length()){
			output = output + str.substring(x) + str.substring(x);
			x=x+1;
		}
		return output;
	}
}

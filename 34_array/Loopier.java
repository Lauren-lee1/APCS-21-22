/*
TNPG: Perfect Purple Petunias
John Gupta-She + Po, Lauren Lee + Bo, Emily Ortiz + Applesauce
HW 34 -- A Pirate's Life for Me
2021-11-12
time spent:
*/

public class Loopier{

	private static int counter=0;

	private static int[] popArray(int[] a){
		for (int i = 0; i < a.length; i++){
			a[i] = (int)( Math.random()*100);
		}
		return a;
	}

	private static String strArray(int[] a){
		String output = "{" + a[0];
		for (int i = 1; i < a.length; i++){
			output += ", " + a[i];
		}
    			output += "}";
    		return output;
  		}

	public static int linSearch( int[] a, int target){
		for (int i = 0; i < a.length; i++){
			if (a[i] == target) {
				return i;
			}
		}
		return -1;
  	}

	public static int linSearchR(int[] a, int target){
		int output;
		if (a.length == 0){
			return -1;
		} else if (a[0] == target){
			output = counter;
			counter = 0;
			return output;
		} else {
			counter = counter + 1;
			if  (a.length > 1){
				int[] b = new int[a.length-1];
				for (int i = 0; i<b.length; i++){
					b[i] = a[i+1];
				}
				if (b[0] == target){
					output = counter;
					counter = 0;
					return output;
				}else {
					return linSearchR(b, target);
				}
			}else {
				int [] b =new int[0];
				return linSearchR(b, target);
			}
		}
	}

	public static int freq(int[] a, int target){
		int counter = 0;
		for (int i = 0; i < a.length; i++){
			if (a[i] == target) {
				counter = counter + 1;
			}
		}
		return counter;
	}

	public static int freqRec(int[] a, int target){
		if (a.length == 0) {
			return 0;
		} else {
			int[] b = new int[a.length-1];
			for (int i = 0; i<b.length; i++){
				b[i]=a[i+1];
			}
			if (a[0] == target) {
				return 1 + freqRec(b, target);
			}
			return freqRec(b, target);
		}
	}

	public static void main (String args[]){
		int[] b = {1,2,1,4,3, 2, 3};

		System.out.println();
		System.out.println("test for popArray()");
		System.out.println(strArray(popArray(b)));

		int [] a = {1, 2, 1, 4, 3, 2, 3};
		System.out.println();
		System.out.println("tests for linSearch()");
		System.out.println(linSearch(a, 0) + " ...should be -1");
		System.out.println(linSearch(a, 1) + " ...should be 0");
		System.out.println(linSearch(a, 2) + " ...should be 1");

		System.out.println();
		System.out.println("tests for linSearchR()");
		System.out.println(linSearchR(a, 1) + " ...should be 0");
		System.out.println(linSearchR(a, 0) + " ...should be -1");
		System.out.println(linSearchR(a, 2) + " ...should be 1");

		System.out.println();
		System.out.println("tests for freq()");
		System.out.println(freq(a, 1) + " ...should be 2");
		System.out.println(freq(a, 0) + " ...should be 0");
		System.out.println(freq(a, 4) + " ... should be 1");

		System.out.println();
		System.out.println("tests for freqRec()");
		System.out.println(freqRec(a, 1) + " ...should be 1");
		System.out.println(freqRec(a, 0) + " ...should be 0");
		System.out.println(freqRec(a, 4) + " ...should be 1");
	}
}


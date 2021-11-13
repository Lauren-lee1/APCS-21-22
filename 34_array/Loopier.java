/*
TNPG: Perfect Purple Petunias
John Gupta-She + Po, Lauren Lee + Bo, Emily Ortiz + Applesauce
HW 34 -- A Pirate's Life for Me
2021-11-12
time spent:
*/

public class Loopier{
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


	public static int freq(int[] a, int target){
		int counter = 0;
		for (int i = 0; i < a.length; i++){
			if (a[i] == target) {
				counter = counter + 1;
			}
		}
		return counter;
	}

//	public static int freqRec(int[] a, int target){
		
	public static void main (String args[]){
		int[] a = {1,2,1,4};
		System.out.println(freq(a, 1));
 	}
}


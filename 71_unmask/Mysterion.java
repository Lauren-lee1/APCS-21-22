/*
<Frist> <Lsat>
APCS
HW<nn> -- <Title/Topic/Summary... (Aim for concision, brevity, CLARITY. Write to your future self...)>
<yyyy>-<mm>-<dd>
time spent: <elapsed time in hours, rounded to nearest tenth>
*/

public class Mysterion {
  public static void mysterion(int[] arr, int lower, int upper, int target) {
    int compareTar = arr[target];
    int targetNum = arr[target];
    arr[target]=arr[upper];
    arr[upper]=targetNum;
    int splitIndex = lower;
    for (int i = 0; i < upper; i++) {
      if (arr[i] < compareTar) {
        int split = arr[splitIndex];
        arr[splitIndex]=arr[i];
        arr[i] = split;
        splitIndex += 1;
      }
    }
    int upperNum = arr[upper];
    arr[upper]=arr[splitIndex];
    arr[splitIndex] = upperNum;
  } // mysterion

  private static String strArray(int[] a){
		String output = "{" + a[0];
		for (int i = 1; i < a.length; i++){
			output += ", " + a[i];
		}
    			output += "}";
    		return output;
  		}

  public static void main(String[] args) {
    int[] arr = new int[] {7,1,5,12,3};
    mysterion(arr, 0, 4, 2);
    System.out.println(strArray(arr));
  } // main
}


public class Mysterion {

  /*
  The method does not necessarily sort the array, rather it places elements in the array in respect to the target element we are looking at.
  Places elements less than target on the left side and elements greater than target on the right side. Only elements within the bounds are considered
  If the element is outside of bounds, it is left where it is.

  int[] arr -- array we are working with
  int lower and int upper -- indexes that partition the array to only the parts we want to work with
  int target -- the element that we want to have all lower numbers to the left and all higher numbers to the right
  */
  public static void partition(int[] arr, int lower, int upper, int target) {
    //swap the upper index with the target to take the target out of the parts of the array we will be comparing
    int compareTar = arr[target];
    int targetNum = arr[target];
    arr[target]=arr[upper];
    arr[upper]=targetNum;

    int splitIndex = lower;
    for (int i = lower; i < upper; i++) { //looks through the array from lower to upper limit (minus target)
      if (arr[i] < compareTar) { //if the numbers is lower than the target, it placed on the left side of the array.
        int split = arr[splitIndex];
        arr[splitIndex]=arr[i];
        arr[i] = split;
        splitIndex += 1;
      }
    }
    //target is placed before its greater numbers and after its lower numbers
    int upperNum = arr[upper];
    arr[upper]=arr[splitIndex];
    arr[splitIndex] = upperNum;
  } // partition

  private static String strArray(int[] a){
		String output = "{" + a[0];
		for (int i = 1; i < a.length; i++){
			output += ", " + a[i];
		}
    			output += "}";
    		return output;
  		}

  public static void main(String[] args) {

    int[] og = new int[] {7,1,5,12,3}; // original array
    partition(og, 0, 4, 2);
    System.out.println(strArray(og) + " ... should be {1,3,5,12,7}");

    System.out.println("-------------------------------------------");
    int[] doesitSort = new int[] {7,1,5,12,3}; // does the array sort itself as we use the method in ascending target index order?
    partition(doesitSort, 0, 4, 0);
    System.out.println(strArray(doesitSort) + " ... should be {3,1,5,7,12}");
    partition(doesitSort, 0, 4, 1);
    System.out.println(strArray(doesitSort) + " ... should be {1,12,5,7,3}");
    partition(doesitSort, 0, 4, 2);
    System.out.println(strArray(doesitSort) + " ... should be {1,3,5,7,12}");
    partition(doesitSort, 0, 4, 3);
    System.out.println(strArray(doesitSort) + " ... should be {1,3,5,7,12}");
    partition(doesitSort, 0, 4, 4);
    System.out.println(strArray(doesitSort) + " ... should be {1,3,5,7,12}");
    // yes it does
    System.out.println("-------------------------------------------");

    System.out.println("-------------------------------------------");
    int[] des = new int[] {12,7,5,3,1}; //worst case?
    partition(des, 0, 4, 0);
    System.out.println(strArray(des) + " ... should be {1,7,5,3,12}");
    partition(des, 0, 4, 1);
    System.out.println(strArray(des) + " ... should be {1,5,3,7,12}");
    partition(des, 0, 4, 2);
    System.out.println(strArray(des) + " ... should be {1,3,12,7,5}");
    partition(des, 0, 4, 3);
    System.out.println(strArray(des) + " ... should be {1,3,5,7,12}");
    partition(des, 0, 4, 4);
    System.out.println(strArray(des) + " ... should be {1,3,5,7,12}");
    // takes four method calls to sort (length-1)
    System.out.println("-------------------------------------------");

    int[] changeLower = new int[] {7,1,5,12,3}; //changing lower limit
    partition(changeLower, 1, 4, 2);
    System.out.println(strArray(changeLower) + "... should be {7,1,3,5,12}");

    System.out.println("-------------------------------------------");

    int[] changeUpper = new int[] {7,1,5,12,3}; //changing upper limit
    partition(changeUpper, 0, 3, 2);
    System.out.println(strArray(changeUpper) + "... should be {1,5,12,7,3}");

    System.out.println("-------------------------------------------");

    int[] bigger= new int[] {7,1,5,12,3,17,15}; //making array larger
    partition(bigger, 0, 6, 3);
    System.out.println(strArray(bigger) + "... should be {7,1,5,3,12,17,15}");

  } // main
}

public class Array{

  public static int countEvens(int[] nums) {
    int i = 0;
    int counter = 0;
    while (i < nums.length) {
      if (nums[i]%2 == 0) {
        counter = counter +1;
      } else {
        counter = counter;
      }
      i = i +1;
    } return counter;
}

  public static boolean sum28(int[] nums) {
    int i = 0;
    int counter = 0;
    while (i < nums.length) {
      if (nums[i] ==2) {
        counter = counter + nums [i];
      } else {
        counter = counter;
      }
      i = i+1;
      } if (counter == 8) {
        return true;
      } else {
        return false;
      }
  }

}

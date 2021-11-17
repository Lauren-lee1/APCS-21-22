public class arrayOne{

  public static boolean firstLast6(int[] nums) {
    return (nums[0] == 6) || (nums[nums.length-1] == 6);
  }

  public static boolean sameFirstLast(int[] nums) {
    return (nums.length >= 1) && (nums[0] == nums[nums.length -1]);
  }

  public static int[] makePi() {
    int[] a = {3, 1, 4};
    return a;
  }

  public static boolean commonEnd(int[] a, int[] b) {
    return (a[0] == b[0]) || (a[a.length-1] == b[b.length-1]);
  }

  public static int sum3(int[] nums) {
    int total = nums[0] + nums[1] + nums[2];
    /* for (int x: nums){
      total += x;
    } */
    return total;
  }

  public static int[] rotateLeft3(int[] nums) {
    int[] output = new int[3];
    output[0] = nums[1];
    output[1] = nums[2];
    output[2] = nums[0];
    return output;
  }

  public static int[] reverse3(int[] nums) {
    int[] output = new int[3];
    output[0] = nums[2];
    output[1] = nums[1];
    output[2] = nums[0];
    return output;
  }

  public static int[] maxEnd3(int[] nums) {
    int max = Math.max(nums[0], nums[2]);
    int[] output = new int[3];
    output[0] = max;
    output[1] = max;
    output[2] = max;
    return output;
  }

  public static int sum2(int[] nums) {
    if (nums.length == 0){
      return 0;
    } else if (nums.length == 1){
      return nums[0];
    } else {
      return nums[0] + nums[1];
    }
  }


  public static void main (String[] args){
    int [] a = {1,2,3,6};
    int[] b = {3, 3, 6};
    System.out.println("First Last: should be true..." + firstLast6(a) );
    System.out.println("sameFirstLast: should be false..." + sameFirstLast(a));
    //System.out.println("makePi: " + makePi());
    System.out.println("commonEnd: should be true..." + commonEnd(a, b));
    System.out.println("sum3: should be 12..." + sum3(b));
    System.out.println("sum2: should be 6..." + sum2(b));
  }
}

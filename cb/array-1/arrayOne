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

  public static void main (String[] args){
    int [] a = {1,2,3,6};
    int[] b = {3, 3, 6};
    System.out.println("First Last: should be true..." + firstLast6(a) );
    System.out.println("sameFirstLast: should be false..." + sameFirstLast(a));
    //System.out.println("makePi: " + makePi());
    System.out.println("commonEnd: should be true..." + commonEnd(a, b));
    System.out.println("sum3: should be 12..." + sum3(b));
  }
}

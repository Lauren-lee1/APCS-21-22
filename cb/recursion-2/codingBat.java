public class codingBat{

/*Given an array of ints, is it possible to choose a group of some of the ints,
such that the group sums to the given target? This is a classic backtracking
recursion problem. Once you understand the recursive backtracking strategy in this
problem, you can use the same pattern for many problems to search a space of choices.
Rather than looking at the whole array, our convention is to consider the part of the
array starting at index start and continuing to the end of the array. The caller
can specify the whole array simply by passing start as 0. No loops are needed
-- the recursive calls progress down the array. */
  public static boolean groupSum(int start, int[] nums, int target){
    if (start >= nums.length){
      if (target == 0)
        return true;
    } else if (groupSum(start+1, nums, target - nums[start]) == true) {
      return true;
    } else if (groupSum(start+1, nums, target) == true){
      return true;
    }
     return false;
   }

// [2 4 8] --10
/*

start: 0 target: 10 (14) [2,4,8]
start: 1 target: 8 (14) 2
start: 2 target: 4 (14) 4
start: 3 target: 4  8
start: 1 target: 10 (16) 2
start: 2 target: 6 (14) 4
start: 3 target: 6 (14) 8
start 2 target: 10 (16) 4
start 3 target 2 (14)8



*/



  public static boolean splitArray(int[] nums){
    return add(nums, 0, 0, 0);
  }

  public static boolean add(int[] nums , int start, int g1, int g2){
    if (start >= nums.length){
      if (g1 == g2){
        return true;
      }
    } else if(add(nums, start+1, g1 + nums[start],g2) ==  true){
      return true;
    } else if (add(nums, start+1, g1, g2+nums[start]) == true){
      return true;
    }
    return false;
  }

  // [ 1 2 3 ]

  public static void main(String[] args){
    int[] a = new int [] {2, 4, 8};

    System.out.println(groupSum(0, a, 10) + "...should be true");
    System.out.println(groupSum(0, a, 14) + "...should be true");
    System.out.println(groupSum(0, a, 9) + "...should be false");

    int[] b = new int [] {2, 2};
    int[] c = new int [] {2, 3};
    int[] d = new int [] {5, 2, 3};

    System.out.println(splitArray(b) + "...should be true");
    System.out.println(splitArray(c) + "...should be false");
    System.out.println(splitArray(d) + "...should be true");

  }
}

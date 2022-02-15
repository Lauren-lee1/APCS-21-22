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
/*
Given an array of ints, is it possible to choose a group of some of the ints,
beginning at the start index, such that the group sums to the given target?
However, with the additional constraint that all 6's must be chosen. (No loops needed.)
*/
  public static boolean groupSum6(int start, int[] nums, int target) {
    if (start >= nums.length){
      if (target == 0)
        return true;
    } else if (nums[start] == 6){
      return groupSum6(start+1, nums, target - nums[start]);
    }
      else if (groupSum6(start+1, nums, target - nums[start]) == true) {
      return true;
    } else if (groupSum6(start+1, nums, target) == true){
      return true;
    }
     return false;
  }

/*
Given an array of ints, is it possible to choose a group of some of the ints,
such that the group sums to the given target with this additional constraint:
If a value in the array is chosen to be in the group, the value immediately
following it in the array must not be chosen. (No loops needed.)
*/
  public static boolean groupNoAdj(int start, int[] nums, int target){
    if (start >= nums.length){
      return (target == 0);
    } else if (groupNoAdj(start + 2, nums, target - nums[start])) {
      return true;
    } else if (groupNoAdj(start+1, nums, target)){
      return true;
    }
      return false;
  }

  public static boolean groupSum5(int start, int[] nums, int target){
    if (start >= nums.length){
      if (target == 0)
        return true;
    }else if (nums[start] % 5 == 0 && start+1 < nums.length && nums[start+1] == 1) {
      return groupSum5(start+2, nums, target - nums[start]);
    } else if (nums[start] % 5 == 0){
      return groupSum5(start+1, nums, target - nums[start]);
    }
      else if (groupSum5(start+1, nums, target - nums[start]) == true) {
      return true;
    } else if (groupSum5(start+1, nums, target) == true){
      return true;
    }
     return false;
  }
/*
Given an array of ints, is it possible to divide the ints into two groups,
so that the sums of the two groups are the same. Every int must be in one group
or the other. Write a recursive helper method that takes whatever arguments you
like, and make the initial call to your recursive helper from splitArray(). (No loops needed.)
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

    int [] e = new int [] {5,6,2};
    System.out.println(groupSum6(0, e, 8) + "...should be true");
    System.out.println(groupSum6(0, e, 9) + "...should be false");
    System.out.println(groupSum6(0, e, 7) + "...should be false");

    int [] f = new int [] {2, 5, 10, 4};
    System.out.println(groupNoAdj(0, f, 12) + "...should be true");
    System.out.println(groupNoAdj(0, f, 14) + "...should be false");
    System.out.println(groupNoAdj(0, f, 7) + "...should be false");

    System.out.println(groupSum5(0, f, 19) + "...should be true");
    System.out.println(groupSum5(0, f, 17) + "...should be true");
    System.out.println(groupSum5(0, f, 12) + "...should be false");
  }
}

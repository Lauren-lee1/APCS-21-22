public class arrayTwo{

  public static int countEvens(int[] nums) {
    int numEvens = 0;
    for (int x: nums){
      if (x%2 == 0){
        numEvens += 1;
      }
    }
    return numEvens;
 }

 public static int bigDiff(int[] nums) {
   int min = nums[0];
   int max = nums[0];
   for (int x: nums){
     min = Math.min(min, x);
     max = Math.max(max, x);
   }
   return max - min;
 }

 public static int centeredAverage(int[] nums) {
   int min = nums[0];
   int max = nums[0];
   for (int x: nums){
     min = Math.min(min, x);
     max = Math.max(max, x);
   }
   int total = 0;
   for (int x: nums){
     total += x;
   }
   total = total - min - max;
   return total / (nums.length - 2);
 }

 public static int sum13(int[] nums) {
   int sum = 0;
   if (nums.length == 0){
     return 0;
   }

   int x = 0;
   while (x < nums.length){
     if (nums[x] != 13){
       sum += nums[x];
       x++;
     } else {
       x += 2;
     }
  }
  return sum;
 }

  public static int sum67(int[] nums) {
    int sum = 0;
    if (nums.length == 0){
      return 0;
    }

    int x = -1;
    while (x < nums.length-1){
      x ++;
      if (nums[x] == 6){
        while (nums[x] != 7){
          x++;
        }
      } else {
      sum += nums[x];
      }
   }
   return sum;
  }

  public static void main (String[] args){
    int[] a = {2, 1, 2, 3, 4};
    int[] b = {2, 1, 2, 13, 4, 5};
    int[] c = {1, 2, 2, 6, 99, 99, 7};
    System.out.println("countEvens: should be 3..." + countEvens(a));
    System.out.println("bigDiff: should be 3..." + bigDiff(a));
    System.out.println("centeredAverage: should be 2..." + centeredAverage(a));
    System.out.println("sum13: should be 10..." + sum13(b));
    System.out.println("sum67: should be 5..." + sum67(c));
  }
}

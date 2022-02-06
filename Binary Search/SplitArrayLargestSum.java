/**
 * Problem #410
 */
class SplitArrayLargestSum {
  public int splitArray(int[] nums, int m) {
    int left = getMax(nums);
    int right = getSum(nums);
    
    // ...f f f f f t t t t t...
    // First occurence of true
    while (left < right) { // end if left == right
      int mid = left + (right - left) / 2;
      
      int split = split(nums, mid);
      
      // less split -> subarray sum (mid) is larger -> subarray sum
      // can be smaller to increase split until to m
      if (split <= m) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    
    return left;
  }
  
  private int split(int[] nums, int max) {
    int count = 1;
    int currSum = 0;
    
    for (int i : nums) {
      if (currSum + i > max) {
        count++;
        currSum = i;
      } else {
        currSum += i;
      }
    }
    
    return count;
  }
  
  private int getMax(int[] nums) {
    int max = nums[0];
    
    for (int i : nums) {
      max = Math.max(max, i);
    }
    
    return max;
  }
  
  private int getSum(int[] nums) {
    int sum = 0; 
    
    for (int i : nums) {
      sum += i;
    }
    
    return sum;
  }
}
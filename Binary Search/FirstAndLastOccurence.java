/**
 * Problem #34
 */
class FirstAndLastOccurence {
  public int[] searchRange(int[] nums, int target) {
    if (nums.length == 0) {
      return new int[]{-1, -1};
    }
    
    int begin = firstOccurenceC(nums, target);
    int end = lastOccurenceC(nums, target);
    return new int[]{begin, end};
  }
  
  private int firstOccurenceA(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int result = -1;
    
    while (left <= right) { // end if left > right
      int mid = left + (right - left) / 2;
      
      if (nums[mid] == target) { // Update result
        result = mid; // First occurence must be the last target to visit
      }
      
      if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return result;
  }
  
  private int lastOccurenceA(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int result = -1;
    
    while (left <= right) { // end if left > right
      int mid = left + (right - left) / 2;
      
      if (nums[mid] == target) { // Update result
        result = mid; // Last occurence must be the last target to visit
      }
      
      if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        left = mid + 1;
      }
    }
    return result;
  }
  
  private int firstOccurenceB(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) { // end if left == right
      int mid = left + (right - left) / 2;
      
      if (nums[mid] > target) {
        right = mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[right] == target ? right : -1;
  }
  
  private int lastOccurenceB(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    
    while (left < right) { // end if left == right
      int mid = left + (right - left) / 2 + (right - left) % 2;
      
      if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] < target) {
        left = mid;
      } else {
        left = mid;
      }
    }
    return nums[right] == target ? right : -1;
  }
  
  private int firstOccurenceC(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right - 1) { // end if left == right - 1
      int mid = left + (right - left) / 2;
      
      if (nums[mid] > target) {
        right = mid;
      } else if (nums[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    
    if (nums[left] != target && nums[right] != target) {
      return -1;
    }
    
    if (nums[left] == target) {
      return left;
    } else {
      return right;
    }
  }
  
  private int lastOccurenceC(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right - 1) { // end if left == right - 1
      int mid = left + (right - left) / 2;
      
      if (nums[mid] > target) {
        right = mid;
      } else if (nums[mid] < target) {
        left = mid;
      } else {
        left = mid;
      }
    }
    
    if (nums[left] != target && nums[right] != target) {
      return -1;
    }
    
    if (nums[right] == target) {
      return right;
    } else {
      return left;
    }
  }
}
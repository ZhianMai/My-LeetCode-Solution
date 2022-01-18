/**
 * Problem #81
 */
class RotatedArrayWithDuplicateSearch {
  public boolean search(int[] nums, int target) {
    if (nums == null || nums.length < 1) {
      return false;
    }

    int peak = findMax(nums);
    
    if (binarySearch(nums, 0, peak, target) != -1) {
      return true;
    } else {
      return binarySearch(nums, peak + 1, nums.length - 1, target) != -1;
    }
  }
  
  // Return the break point which is the maximum in the original sorted array
  private int findMax(int[] array) {
    if (array.length < 3) {
      return array[0] <= array[array.length - 1] ? array.length -1 : 0;
    }
    int left = 0;
    int right = array.length - 1;

    while (left < right - 1) { // Terminate: left > right, search space == 0
      if (left < right && array[left] == array[right]) {  
        right--;
        continue;
      }
       
      int mid = left + (right - left) / 2;
      
      if (mid == array.length - 1 || array[mid] > array[mid + 1]) {
        return mid;
      } else if (array[left] <= array[mid]) {
        left = mid;
      } else {
        right = mid;
      }
    }
    return array[left] > array[right] ? left : right;
  }

  private int binarySearch(int[] array, int left, int right, int target) {
    if (left > right) {
      return -1;
    }

    while (left < right) { // Terminate: left == right, search space == 0
      int mid = left + (right - left) / 2;
      // The target is at the right side of mid 
      if (array[mid] < target) {
        left = mid + 1;
      // The target is at the left side of mid
      } else {
        right = mid;
      }
    }
    return array[right] == target ? right : -1;
  }
}
/**
* Problem #704
*
* The easiest problem?
* Or the hardest?
*
* Anyway, it's one of my most well-studied problem!
*/
class BinarySearch {
  // The first way to write binary search.
  // The while loop is left <= right.
  public int searchOne(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1;
  }
  
  // The second way to write binary search.
  // The while loop is left < right.
  public int searchTwo(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return nums[left] == target ? left : -1;
  }
  
  // The third way to write binary search.
  // The while loop is left < right.
  // But the mid is different to the second one!
  public int searchThree(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int mid = left + (right - left) / 2 + (right - left) % 2;

      if (target < nums[mid]) {
        right = mid - 1;
      } else {
        left = mid;
      }
    }

    return nums[left] == target ? left : -1;
  }
  
  // The fourth way to write binary search.
  // The while loop is left < right - 1.
  public int searchFour(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right - 1) {
      int mid = left + (right - left) / 2 + (right - left) % 2;

      if (target < nums[mid]) {
        right = mid;
      } else {
        left = mid;
      }
    }

    if (nums[left] == target) {
      return left;
    } else if (nums[right] == target) {
      return right;
    } else {
      return -1;
    }
  }
}
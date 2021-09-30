class MinInRotatedSortedArray {
  public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int mid = left + (right-left) / 2;
      if (nums[left] == nums[left + 1]) {
        left++;
      } else if (nums[right] == nums[right - 1]) {
        right--;
      } else if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[left];
  }
}
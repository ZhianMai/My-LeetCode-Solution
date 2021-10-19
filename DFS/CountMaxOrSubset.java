/**
 * Problem #2044
 */
class CountMaxOrSubset {
    public int countMaxOrSubsets(int[] nums) {
      int maximum = 0;
      
      for (int i : nums) {
        maximum |= i;
      }
      int[] count = new int[]{0};
      for (int i = 0; i < nums.length; i++) {
        dfs(nums, count, maximum, i + 1, 0, 0);
      }
      return count[0];
    }
    
    private void dfs(int[] nums, int[] count, int maximum, int selectLeft, int curr, int begin) {
      if (selectLeft == 0 || begin >= nums.length) {
        if (curr == maximum) {
          count[0]++;
        }
        return;
      }
      
      for (int i = begin; i <= nums.length - selectLeft && i < nums.length; i++) {
        dfs(nums, count, maximum, selectLeft - 1, curr | nums[i], i + 1);
      }
    }
}
/**
* Problem #698
*/
class PartitionKSubsets {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = 0;

    for(int i : nums){
      sum += i;
    }

    if(sum % k != 0){
      return false; // Invalid input
    }

    return dfs(nums, sum / k, 0, 0, k);
  }

  // DFS1: O(n!), each recursion iterate one element of the array. The logic is difficult to form.
  private boolean dfs(int[] nums, int target, int beginIdx, int currSum, int subsetRemains) {
    if (subsetRemains == 0) {
      return true;
    }

    for (int i = beginIdx; i < nums.length; i++) {
      if (nums[i] > 0 && currSum + nums[i] <= target) {
        nums[i] *= -1; // Flipping the number to negative to indicate it's used.

        // Case one: if adding current nums[i] can reach target, then restart a new currSum.
        // Case two: if adding current nums[i] is still less than target, then do more recursions.
        if ((currSum - nums[i] == target && dfs(nums, target, 0, 0, subsetRemains - 1)) ||
            (dfs(nums, target, i + 1, currSum - nums[i], subsetRemains))) {
          return true;
        }

        nums[i] *= -1;
      }
    }

    return false;
  }
  
  public boolean canPartitionKSubsetsB(int[] nums, int k) {
      boolean[] result = new boolean[]{false};
      int[] subsetSum = new int[k];
      int sum = 0;

      for (int i : nums) {
        sum += i;
      }

      if (sum % k != 0) {
        return false;
      }

      for (int i : nums) {
        if (i > sum / k) {
          return false;
        }
      }

      Arrays.fill(subsetSum, sum / k);

      dfs(nums, result, subsetSum, 0, 0);

      return result[0];
    }

    // DFS2: O(k^n). Try every possible subsets. It's very slow but easier to write.
    private void dfsB(int[] nums, boolean[] result, int[] subsetSum, int level, int matchCount) {
      if (result[0]) {
        return;
      }

      if (level == nums.length) {
        if (matchCount == subsetSum.length) {
          result[0] = true;
        }
        return;
      }

      for (int i = 0; i < subsetSum.length; i++) {
        if (subsetSum[i] >= nums[level]) {
          subsetSum[i] -= nums[level];

          if (subsetSum[i] == 0) {
            dfs(nums, result, subsetSum, level + 1, matchCount + 1);
          } else {
            dfs(nums, result, subsetSum, level + 1, matchCount);
          }

          subsetSum[i] += nums[level];
        }
      }
    }
  }
}
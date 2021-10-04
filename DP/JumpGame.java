/**
* Problem #55
*/
class JumpGame {
  // DP, idx 0 -> end
  public boolean canJumpA(int[] nums) {
    boolean[] dp = new boolean[nums.length];
    dp[0] = true; // dp[i]: can idx 0 reach idx i

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && j + nums[j] >= i) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[nums.length - 1];
  }
  
  // DP, idx end -> 0
  public boolean canJumpB(int[] nums) {
    boolean[] dp = new boolean[nums.length];
    dp[nums.length - 1] = true; // dp[i]: can idx i reach the end
    
    for (int i = nums.length - 1; i > -1; i--) {
      for (int j = 1; i + j < nums.length && j <= nums[i]; j++) {
        if (dp[i + j]) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[0];
  }
  
  // Greedy, idx 0 -> end
  public boolean canJumpC(int[] nums) {
    int maxDist = nums[0];

    for (int i = 0; i < nums.length; i++) {
      if (maxDist < i) {
        return false;
      }

      maxDist = Math.max(maxDist, nums[i] + i);
    }
    return true;
  }
  
  // Greedy, idx end -> 0
  public boolean canJumpD(int[] nums) {
    int idxToEnd = nums.length - 1;

    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + nums[i] >= idxToEnd) {
        idxToEnd = i;
      }
    }
    return idxToEnd == 0;
  }
}
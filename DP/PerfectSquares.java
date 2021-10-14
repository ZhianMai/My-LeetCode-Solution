/**
 * Problem #279
 */
class PerfectSquares {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    
    for (int i = 1; i <= n; i++) {
      dp[i] = i;
      for (int j = 1; j * j <= i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }
    return dp[n];
  }
  // Time complexity:
  // = O(1^(1 / 2) + 2^(1 / 2) + 3^(1 / 2)+ ... + n^(1 / 2))
  // = O(n)
  // Summation of square root series is O(n)
}
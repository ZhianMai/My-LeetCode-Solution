/**
 * Problem #322
 */
class CoinChangeI {
  public int coinChange(int[] coins, int amount) {
    // dp[i]: fewest number of coins to get amount i
    int[] dp = new int[amount + 1];
    
    for (int i = 1; i <= amount; i++) {
      dp[i] = -1;
      for (int j : coins) {
        if (i - j >= 0 && dp[i - j] != -1) {
          if (dp[i] == -1) {
            dp[i] = dp[i - j] + 1;
          } else {
            dp[i] = Math.min(dp[i], dp[i - j] + 1); 
          }
        }
      }
    }
    return dp[amount];
  }
}
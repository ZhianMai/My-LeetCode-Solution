/**
 * Problem #518
 */
class CoinChangeII {
  public int change(int amount, int[] coins) {
    // dp[i]: fewest number of coins to get amount i
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    
    // One situation of permutations that ensures the coin is
    // in order, so it's combination
    for (int coin : coins) {
      for (int val = 1; val <= amount; val++) {
        if (val - coin >= 0) {
          dp[val] += dp[val - coin];
        }
      }
    }
    
    return dp[amount];
  }
  
// This is permutation! but it needs combination
//   public int change(int amount, int[] coins) {
//     // dp[i]: fewest number of coins to get amount i
//     int[] dp = new int[amount + 1];
//     dp[0] = 1;
    
//     for (int i = 1; i <= amount; i++) {
//       for (int j : coins) {
//         if (i - j >= 0) {
//           dp[i] += dp[i - j];
//         }
//       }
//     }
    
//     for (int i : dp) {
//       System.out.print(i + ",");
//     }
//     return dp[amount];
//   }
}
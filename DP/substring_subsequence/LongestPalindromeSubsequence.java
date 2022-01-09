/**
 * Problem #516
 */
class LongestPalindromeSubsequence {
  public int longestPalindromeSubseq(String input) {
    int length = input.length();
    int[][] dp = new int[length][length];

    for (int i = 0; i < length; i++) {
      dp[i][i] = 1;
    }

    // i: length of substring
    for (int i = 1; i < length; i++) {
      // j: begin index of substring
      for (int j = 0; j + i < length; j++) {
        // k: end index of substring
        int k = i + j;
        if (input.charAt(j) == input.charAt(k)) {
          dp[j][k] = dp[j + 1][k - 1] + 2;
        } else {
          dp[j][k] = Math.max(dp[j + 1][k], dp[j][k - 1]);
        }
      }
    }

    return dp[0][length - 1];
  }
}
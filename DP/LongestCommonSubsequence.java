/**
* Problem #1143
*/
class LongestCommonSubsequence {
  public int longestCommonSubsequence(String text1, String text2) {
    char[] str1 = text1.toCharArray();
    char[] str2 = text2.toCharArray();

    // If use an 2-D array to fill out, notice that the current row
    // is only depends on the previous row.
    // So using two 1-D arrays is enough for this problem.
    
    // Yes, it's possible to use ONE array only, but it would be hard
    // to follow.
    int[][] dp = new int[2][str2.length + 1];

    for (int i = 1; i <= str1.length; i++) {
      int iIdx = i % 2; // Alternate two arrays
      int iiIdx = (i - 1) % 2;
      
      for (int j = 1; j <= str2.length; j++) {
        if (str1[i - 1] == str2[j - 1]) {
          dp[iIdx][j] = dp[iiIdx][j - 1] + 1;
        } else {
          dp[iIdx][j] = Math.max(dp[iiIdx][j], dp[iIdx][j - 1]);
        }
      }
    }

    return Math.max(dp[0][str2.length], dp[1][str2.length]);
  }
}

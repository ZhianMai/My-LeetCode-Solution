/**
 * Problem #72
*/
class MinEditDistance {
  // Space: O(min(m,n))
  public int minDistance(String word1, String word2) {
    if (word1.length() < word2.length()) {
      String temp = word1;
      word1 = word2;
      word2 = temp;
    }
    
    char[] input1 = word1.toCharArray();
    char[] input2 = word2.toCharArray();
    int len1 = input1.length;
    int len2 = input2.length;
    int[][] dp = new int[2][len2 + 1];
    
    for (int i = 0; i <= len1; i++) {
      int currRowIdx = i % 2;
      int prevRowIdx = (i - 1) % 2;
      
      for (int j = 0; j <= len2; j++) {
        if (i == 0) { // Delete all to empty string
          dp[0][j] = j;
        } else if (j == 0) { // Delete all to empty string
          dp[currRowIdx][0] = i;
        } else if (input1[i - 1] == input2[j - 1]) {
          // Current chars are equal, back track to previous 
          dp[currRowIdx][j] = dp[prevRowIdx][j - 1];
        } else {
          // Delete, replace, || add a char on input1 || input2
          dp[currRowIdx][j] = Math.min(dp[prevRowIdx][j - 1],
                             Math.min(dp[currRowIdx][j - 1], dp[prevRowIdx][j])) + 1;
        }
      }
    }
    return dp[len1 % 2][len2];
  }
  
  // Space: O(m*n)
//   public int minDistance(String word1, String word2) {
//     char[] input1 = word1.toCharArray();
//     char[] input2 = word2.toCharArray();
//     int len1 = input1.length;
//     int len2 = input2.length;
//     int[][] dp = new int[len1 + 1][len2 + 2];
    
//     for (int i = 0; i <= len1; i++) {
//       for (int j = 0; j <= len2; j++) {
//         if (i == 0) { // Delete all to empty string
//           dp[0][j] = j;
//         } else if (j == 0) { // Delete all to empty string
//           dp[i][0] = i;
//         } else if (input1[i - 1] == input2[j - 1]) {
//           // Current chars are equal, back track to previous 
//           dp[i][j] = dp[i - 1][j - 1];
//         } else {
//           // Delete, replace, || add a char on input1 || input2
//           dp[i][j] = Math.min(dp[i - 1][j - 1],
//                              Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
//         }
//       }
//     }
//     return dp[len1][len2];
//   }
}
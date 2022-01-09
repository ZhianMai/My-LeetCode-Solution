/**
 * Problem #132
 */
class FewestCutPalindrome {
  // Method one: O(n^3)
  public int minCut(String s) {
    char[] input = s.toCharArray();
    // dp[i]: min cut for substring idx 0 to idx i inclusively
    int[] dp = new int[input.length + 1];

    for (int i = 1; i < dp.length; i++) {
      dp[i] = i - 1;
      for (int j = 0; j < i; j++) {
        if (isPalidrome(input, 0, i - 1)) {
          dp[i] = 0;
        } else if (isPalidrome(input, j, i - 1)) {
          dp[i] = Math.min(dp[i], dp[j] + 1);
        }
      }
    }
    return dp[dp.length - 1];
  }

  private boolean isPalidrome(char[] input, int left, int right) {
    while (left <= right) {
      if (input[left] != input[right]) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
  
  // Method two: O(n^2)
  // First use O(n^2) to find out all palidromes from all substrings
  // Then apply method one, but can use O(1) time to verify palidrome.
  // Space: O(n^2) to record all possible palindrome
    public int minCut2(String input) {
    if (input == null || input.length() < 2) {
      return 0;
    }
    // isPal[i][j]: Substring from index i to j inclusively is palidrome or not
    boolean [][] isPal = new boolean[input.length()][input.length()];
    char[] string = input.toCharArray();
    
    // DP method to find all palidrome substring with odd length
    for (int i = 0; i < string.length; i++) {
      // j is the length offset of substring starting at 0.
      // Each substring is from index i - j to i + j 
      for (int j = 0; i - j >= 0 && i + j < string.length; j++) {
        if (j == 0) {
          isPal[i - j][i + j] = true;
        } else {
          isPal[i - j][i + j] = 
              (string[i - j] == string[i + j]) && isPal[i - j + 1][i + j - 1];
        }
      }
    }

    // DP method to find all palidrome substring with even length
    for (int i = 0, j = 1; j < string.length; i++, j++) {
      for (int k = 0; i - k >= 0 && j + k < string.length; k++) {
        if (k == 0) {
          isPal[i - k][j + k] = string[i - k] == string[j + k];
        } else {
          isPal[i - k][j + k] = 
              (string[i - k] == string[j + k]) && isPal[i - k + 1][j + k - 1];
        }
      }
    }

    int[] dp = new int[string.length + 1];
    
    for (int i = 1; i < dp.length; i++) {
      if (isPal[0][i - 1]) {
        dp[i] = 0;
        continue;
      }
      dp[i] = i - 1;
      for (int j = 0; j < i; j++) {
        if (isPal[j][i - 1]) {
          dp[i] = Math.min(dp[i], dp[j] + 1);
        }
      }
    }
    return dp[dp.length - 1];
  }
}
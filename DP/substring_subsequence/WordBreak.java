/**
 * Problem #139
 */
class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    int len = s.length();
    boolean[] dp = new boolean[len + 1];
    dp[0] = true;
    Set<String> dict = new HashSet<>();
    for (String str : wordDict) {
      dict.add(str);
    }
    
    for (int i = 1; i <= len; i++) {
      for (int j = 0; j < i; j++) {
        if (dict.contains(s.substring(j, i)) && dp[j]) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[len];
  }
}
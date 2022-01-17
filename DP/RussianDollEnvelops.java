/**
 * Problem #354
 */
class RussianDollEnvelops {
  public int maxEnvelopes(int[][] pts) {
    Arrays.sort(pts, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));
    
    // Longest ascending subsequence ending at pts[i][1]
    int[] dp = new int[pts.length];
    int max = 0;
  
    for (int i = 0; i < dp.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (pts[j][0] < pts[i][0] && pts[j][1] < pts[i][1]) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
        }
      }
      max = Math.max(max, dp[i]);
    }
    
    return max;
  }
}
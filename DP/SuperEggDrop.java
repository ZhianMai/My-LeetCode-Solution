/**
* Problem #887
*/
class SuperEggDrop {
  public int superEggDrop(int K, int N) {    
    return helper(K, N, new int[K + 1][N + 1]);
  }
  
  private int helper(int k, int n, int[][] dp) {
    if (n == 0) { // Groud floor, skip
      return 0;
    } else if (k == 1) { // Only one egg left, linearly try.
      return n;
    }else if (dp[k][n]!= 0) { // Result exists.
      return dp[k][n];
    }

    int result = n;
    int low = 1;
    int high = n;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      int left = helper(k - 1, mid - 1, dp); // Egg brokes here. 
      int right = helper(k, n - mid, dp); // Egg not broke here.

      // Best result from all worst cases
      result = Math.min(result, Math.max(left, right) + 1);

      if (left == right) {
        break;
      } else if (left < right) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    dp[k][n] = result;

    return result;
  }
}
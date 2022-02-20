/**
 * Problem #1288
 */
class RemoveCoveredIntervals {
  int removeCoveredIntervals(int[][] intvs) {
    // Sort intervals in start point in ascending order
    // If two intervals have the same start point, then sort
    // them based on end point in descending order
    Arrays.sort(intvs, (a, b) -> {
      if (a[0] == b[0]) {
        return b[1] - a[1];
      }
      return a[0] - b[0]; 
    });

    int left = intvs[0][0];
    int right = intvs[0][1];
    int res = 0;
    
    for (int i = 1; i < intvs.length; i++) {
      int[] curr = intvs[i];

      // Interval covered
      if (left <= curr[0] && right >= curr[1]) {
        res++;
      }

      // Interval merge
      if (right >= curr[0] && right <= curr[1]) {
        right = curr[1];
      }

      // Move to next interval
      if (right < curr[0]) {
        left = curr[0];
        right = curr[1];
      }
    }

    return intvs.length - res;
  }
}
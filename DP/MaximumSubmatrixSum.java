/**
 * This problem is not available on leetcode.
 *
 * Description: given a matrix, whose entries are integer and it can be
 * positive or negative, return the maximum sum of a submatrix.
 */
class MaximumSubmatrixSum {
  public int largest(int[][] matrix) {
    int row = matrix[0].length;
    int col = matrix.length;
    int[][] dp = new int[col][row];
    int globalMax = matrix[0][0];
    int[] localSum = new int[row];

    for (int i = 0; i < row; i++) {
      dp[0][i] = matrix[0][i];
      for (int j = 1; j < col; j++) {
        dp[j][i] = dp[j - 1][i] + matrix[j][i];
      }
    }

    for (int i = 0; i < col; i++) {
      for (int j = i; j < col; j++) {
        int localdpax = dp[j][0] - dp[i][0] + matrix[i][0];
        localSum[0] = localdpax;

        for (int k = 1; k < row; k++) {
          localSum[k] = dp[j][k] - dp[i][k] + matrix[i][k];
          localdpax = dpath.max(localSum[k], localdpax + localSum[k]);
          globaldpax = dpath.max(globaldpax, localdpax);
        }
      }
    }

    return globaldpax;
  }
}
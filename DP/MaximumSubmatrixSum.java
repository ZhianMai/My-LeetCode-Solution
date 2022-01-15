/**
 * This problem is not available on leetcode.
 *
 * https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1#
 *
 * Description: given a matrix, whose entries are integer and it can be
 * positive or negative, return the maximum sum of a submatrix.
 */
class MaximumSubmatrixSum {
  int maximumSumRectangle(int rows, int cols, int M[][]) {
    // code here
    int[][] colPrefixSum = new int[rows][cols];
    
    for (int col = 0; col < cols; col++) {
      colPrefixSum[0][col] = M[0][col];
      for (int row = 1; row < rows; row++) {
        colPrefixSum[row][col] = M[row][col] + colPrefixSum[row - 1][col];
      }
    }
    
    int[] currRow = new int[cols];
    int max = M[0][0];
    
    // r2 is above r1
    for (int r1 = 0; r1 < rows; r1++) {
      for (int r2 = 0; r2 <= r1; r2++) {
        if (r2 == r1) {
          for (int c = 0; c < cols; c++) {
            currRow[c] = colPrefixSum[r1][c];
          }
        } else {
          for (int c = 0; c < cols; c++) {
            currRow[c] = colPrefixSum[r1][c] - colPrefixSum[r2][c];
          }
        }
        max = Math.max(max, largestSubarraySum(currRow));
      } // end for -r2
    } // end for -r1
    return max;
  }
  
  private int largestSubarraySum(int[] arr) {
    int globalMax = arr[0];
    int prevSum = 0;
    
    for (int i : arr) {
      if (prevSum < 0) {
        prevSum = 0;
      }
      
      prevSum += i;
      globalMax = Math.max(prevSum, globalMax);
    }
    return globalMax;
  }
}
/**
* Problem #1547
*/
class MinimumCostCuttingStick {
public int minCost(int n, int[] cuts) {
    // Sort the array so that the cut index is in ascending order
    Arrays.sort(cuts);

    // Use an array to represent a wood as the example described,
    // input: n = 7, cuts = [1,3,4,5]
    // wood: [0, 1, 3, 4, 5, 7]
    int length = cuts.length + 2;
    int[] wood = new int[length];
    wood[length - 1] = n;

    for (int i = 0; i < cuts.length; i++) {
      wood[i + 1] = cuts[i];
    }

    // This is a 2-D DP problem.
    // dp[i][j] represents the minimum cost of cutting the wood from index i to j
    int[][] dp = new int[length][length];

    // Approach:
    // First is to calculate the min cost of all subwoods with length 1,
    // Then calculate all the min cost of all subwoods with length 2, based on length 1;
    // Then calculate all the min cost of all subwoods with length 3, based on length 1 and 2;
    // ... (leave this work to for-loop ;))
    // Until get the min cost of subwood with max length, which is the final solution!
    //
    // Base case: subwood length 1: such as wood[i] to wood[i + 1].
    // Since the subwood with length 1 is individable, so the cost is 0: dp[i][i + 1] = 0.

    // ***Importent***
    // i: sub-wood length, stating at length = 2.
    for (int i = 2; i < length; i++) {
      // ***Important***
      // j: begin idx of subwood
      for (int j = 0; j < length - i; j++) {
        // So for the current subwood, the begin index is i, then the end index is
        // i + j: beginIdx + subwoodLength.

        // Init current cost to max int, since it calculates the min cost.
        dp[j][j + i] = Integer.MAX_VALUE;

        // Calculate the cost of making ONE cut on the current subwood.
        // The cost is the "length" or "weight" of current subwood,
        // calculated by wood[end] - wood[begin].
        // This value is fixed on making ONE cut, no matter cutting at which slot.
        int currCost = wood[j + i] - wood[j];

        // ***Important***
        // k: index of where to make ONE cut on the current subwood.
        //
        // If we make one cut on the subwood, then it will generate sub-subwoodA
        // and sub-subwoodB. So the problem breaks down to:
        // Possible min cut on current subwood = current cut cost +
        //    cutting sub-subwoodA min cost + cutting sub-subwoodB min cost
        //
        // How to get cutting sub-subwoodA and sub-subwoodB min cost?
        // Read from dp[][] :)
        //
        // Try all possible ONE cut on the current subwood, then update the min cost of 
        // current subwood.
        //
        // We confirm the the current sub wood indexed from j to j + i.
        // So the first valid cut is at j + i, and the last valid cut is at j + i - 1.

        for (int k = j + 1; k < j + i; k++) {
          dp[j][j + i] = Math.min(dp[j][j + i],
              (dp[j][k] + dp[k][j + i] + currCost));
        }
      }
    }
    return dp[0][length - 1];
  }
}
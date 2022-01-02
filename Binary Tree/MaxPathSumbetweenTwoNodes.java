/**
 * This problem is not on the leetcode
 * https://practice.geeksforgeeks.org/problems/maximum-path-sum/1#
 */
class MaxPathSumbetweenTwoNodes {
  int maxPathSum(Node root) { 
    /*
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Here Leaf node is a node which is connected to exactly one different node.
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     */
    int[] result = new int[]{Integer.MIN_VALUE};
    int partialSum = helper(root, result);
    
    if (root.left == null || root.right == null) {
      result[0] = Math.max(result[0], partialSum);
    }
    
    return result[0];
  } 
    
  private int helper(Node root, int[] result) {
    if (root == null) {
      return 0;
    }
    
    // This if statement is optional
    if (root.left == null && root.right == null) {
      return root.data;
    }
    
    int leftSum = helper(root.left, result);
    int rightSum = helper(root.right, result);
    
    if (root.left != null && root.right != null) {
      result[0] = Math.max(result[0], leftSum + rightSum + root.data);
      return Math.max(leftSum, rightSum) + root.data;
    } else if (root.left == null) {
      return rightSum + root.data;
    } else {
      return leftSum + root.data;
    }
  }
}
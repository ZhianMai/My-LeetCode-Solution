/**
 * Problem #993
 */
class CousinsInBinaryTree {
  public boolean isCousins(TreeNode root, int x, int y) {
    return helper(root, x, y, 0) == Integer.MAX_VALUE;
  }
  
  private int helper(TreeNode root, int x, int y, int height) {
    if (root == null) {
      return -1;
    }
    
    if (root.val == x || root.val == y) {
      return height;
    }
    
    int left = helper(root.left, x, y, height + 1);
    int right = helper(root.right, x, y, height + 1);
    
    if (left == right && left - height > 1) {
      return Integer.MAX_VALUE; // Signal found!
    }
    
    return Math.max(left, right);
  }
}
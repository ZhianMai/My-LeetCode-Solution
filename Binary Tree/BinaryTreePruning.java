/**
 * Problem #814
 */
class BinaryTreePruning {
  public TreeNode pruneTree(TreeNode root) {
    return postorder(root) == 0 ? null : root; 
  }
  
  private int postorder(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int left = postorder(root.left);
    int right = postorder(root.right);
    
    if (left == 0) {
      root.left = null;
    }
    
    if (right == 0) {
      root.right = null;
    }
    
    return Math.max(Math.max(left, right), root.val);
  }
}
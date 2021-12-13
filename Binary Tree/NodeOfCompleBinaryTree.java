/**
 * Problem #222
 */
class NodeOfCompleBinaryTree {
  // The idea is to utilize the property of complete binary tree.
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int leftHeight = getLeftHeight(root);
    int rightHeight = getRightHeight(root);
    
    if (leftHeight == rightHeight) {
      int result = 2;
      
      for (int i = 1; i < leftHeight; i++) {
        result *= 2;
      }
      return result - 1;
    }
    
    return countNodes(root.left) + countNodes(root.right) + 1;
  }
  
  private int getLeftHeight(TreeNode root) {
    int height = 0;
    while (root != null) {
      height++;
      root = root.left;
    }
    return height;
  }
  
  private int getRightHeight(TreeNode root) {
    int height = 0;
    while (root != null) {
      height++;
      root = root.right;
    }
    return height;
  }
}
/**
 * Problem #701
 */
class InsertToBST {
  public TreeNode insertIntoBST(TreeNode root, int val) {
    TreeNode newNode = new TreeNode(val);
    
    if (root == null) {
      return newNode;
    }
    
    TreeNode oldRoot = root;
    
    while (root != null) {
      if (root.val > val) { // Go left
        if (root.left == null) {
          root.left = newNode;
        } else {
          root = root.left;
        }
      } else if (root.val < val) { // Go right
        if (root.right == null) {
          root.right = newNode;
        } else {
          root = root.right;
        }
      } else { // Already in the BST
          break;
        }
    }
    return oldRoot;
  }
}
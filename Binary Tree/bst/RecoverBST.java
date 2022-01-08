/**
 * Problem #99
 */

class RecoverBST {
  TreeNode prevNode = null;
  TreeNode fstBadNode = null;
  TreeNode secBadNode = null;
  
  public void recoverTree(TreeNode root) {
    // Find two bad nodes
    inorder(root);
    
    // swap
    int temp = fstBadNode.val;
    fstBadNode.val = secBadNode.val;
    secBadNode.val = temp;
  }
  
  private void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    
    inorder(root.left);
    
    if (prevNode != null && prevNode.val > root.val) {
      if (fstBadNode == null) { // This is the first bad node
        fstBadNode = prevNode;
      }
      secBadNode = root;
    }
    
    prevNode = root;
    
    inorder(root.right);
  }
}
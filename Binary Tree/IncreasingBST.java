/**
* Problem #897
*/

class IncreasingBST {
  public TreeNode increasingBST(TreeNode root) {
    TreeNode dummy = new TreeNode(0);
    inorder(new TreeNode[]{dummy}, root); // Need an array to keep track of the current list tail.

    return dummy.right;
  }

  private void inorder(TreeNode[] tail, TreeNode root) {
    if (root == null) {
      return;
    }

    inorder(tail, root.left);

    root.left = null;
    tail[0].right = root;
    tail[0] = root;

    inorder(tail, root.right);

  }
}
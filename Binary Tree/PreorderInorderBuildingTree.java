/**
* Problem #105
*/
class PreorderInorderBuildingTree {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0) {
      return new TreeNode();
    }

    Map<Integer, Integer> inorderMap = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }
    return helper(preorder, 0, preorder.length - 1, inorderMap, 0, inorder.length - 1);
  }

  private TreeNode helper (int[] preorder, int preLeft, int preRight,
                           Map<Integer, Integer> inorder, int inLeft, int inRight) {
    TreeNode root = new TreeNode(preorder[preLeft]);
    int inorderIdx = inorder.get(root.val);

    int inorderLeftLength = inorderIdx - inLeft;
    int inorderRightLength = inRight - inorderIdx;

    if (inorderLeftLength > 0) { // Reduce unnecessary recursion that returns null
      root.left = helper(preorder, preLeft + 1, preLeft + inorderLeftLength,
          inorder, inLeft, inorderIdx - 1);
    }

    if (inorderRightLength > 0) {
      root.right = helper(preorder, preLeft + inorderLeftLength + 1, preRight,
          inorder, inorderIdx + 1, inRight);
    }
    return root;
  }
}
/**
 * Problem #1373
 */
class MaximumSumBSTInBinaryTree {
  static class SubtreeInfo {
    boolean isBST;
    int leftBound;
    int rightBound;
    int returnSum;

    SubtreeInfo (boolean isBST, int leftBound, int rightBound, int returnSum) {
      this.leftBound = leftBound;
      this.rightBound = rightBound;
      this.returnSum = returnSum;
      this.isBST = isBST;
    }
  }

  public int maxSumBST(TreeNode root) {
    int[] globalMax = new int[1];
    helper(root, globalMax);
    return globalMax[0];
  }

  private SubtreeInfo helper(TreeNode root, int[] globalMax) {
    if (root == null) {
      return null;
    }

    SubtreeInfo leftInfo = helper(root.left, globalMax);
    SubtreeInfo rightInfo = helper(root.right, globalMax);

    // Leaf node
    if (leftInfo == null && rightInfo == null) {
      globalMax[0] = Math.max(globalMax[0], root.val);

      return new SubtreeInfo(true, root.val, root.val, root.val);
      // Has right child only, and it's BST.
    } else if (leftInfo == null && rightInfo.isBST && root.val < rightInfo.leftBound) {
      int sum = root.val + rightInfo.returnSum;
      globalMax[0] = Math.max(globalMax[0], sum);

      return new SubtreeInfo(true, root.val, rightInfo.rightBound, sum);
      // Has left child only, and it's BST.
    } else if (rightInfo == null && leftInfo.isBST && root.val > leftInfo.rightBound) {
      int sum = root.val + leftInfo.returnSum;
      globalMax[0] = Math.max(globalMax[0], sum);

      return new SubtreeInfo(true, leftInfo.leftBound, root.val, sum);
      // Has left & right children, and it's BST.
    } else if (leftInfo != null && rightInfo != null &&
        leftInfo.isBST && root.val > leftInfo.rightBound &&
        rightInfo.isBST && root.val < rightInfo.leftBound) {
      int sum = root.val + leftInfo.returnSum + rightInfo.returnSum;
      globalMax[0] = Math.max(globalMax[0], sum);

      return new SubtreeInfo(true, leftInfo.leftBound, rightInfo.rightBound, sum);
      // Not a BST.
    } else {
      return new SubtreeInfo(false, 0, 0, 0);
    }
  }
}
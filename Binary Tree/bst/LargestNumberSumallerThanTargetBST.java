class LargestNumberSumallerThanTargetBST {
  public int largestSmaller(TreeNode root, int target) {
    int result = Integer.MIN_VALUE;
    while (root != null) {
      if (target <= root.key) {
        root = root.left;
      } else {
        result = root.key;
        root = root.right;
      }
    }
    return result;
  }
}
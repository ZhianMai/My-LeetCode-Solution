class MaximumPathSum {
  public int maxPathSum(TreeNode root) {
    int[] max = new int[]{Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
  }
  
  private int helper(TreeNode root, int[] max) {
    if (root == null) {
      return 0;
    }
    
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    
    max[0] = Math.max(max[0], left + right + root.val);
    
    return Math.max(root.val + Math.max(left, right), 0);
  }
}
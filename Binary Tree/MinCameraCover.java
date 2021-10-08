/**
 * Problem #968
 */
class MinCameraCover {
  public int minCameraCover(TreeNode root) {
    int[] sum = new int[]{0};

    if (check(root, sum) == -1) {
      sum[0]++;
    }
    return sum[0];
  }

  // -1: child needs cam covered, I need a cam!
  // 0: child got covered, and I'm not covered.
  // 1: child got cam, I'm good!
  private int check(TreeNode root, int[] sum) {
    if (root == null) {
      return 0; // Parent take care of yourself!
    }
    int left = check(root.left, sum);
    int right = check(root.right, sum);

    if (left == -1 || right == -1) { // Either child needs my cover
      sum[0]++;
      return 1; // My child need cam, I got one, and cover my parent.
    }

    if (left == 1 || right == 1) { // One child covers me, and the other one is covered or got cam.
      return 0; // My child got cam, parent cover yourself.
    }
    // None of my child needs cam and none of my child covers me! They must be 0!
    return -1; // My child got coverd, and ask parent to cover me!
  }
}
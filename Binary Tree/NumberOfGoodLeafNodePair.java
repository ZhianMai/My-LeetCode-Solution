/**
 * Problem #1530
 */
class NumberOfGoodLeafNodePair {
  public int countPairs(TreeNode root, int distance) {
    if (distance < 2) {
      return 0;
    }
    
    int[] count = new int[1];
    postorder(root, distance, count);
    return count[0];
  }
  
  private int[] postorder(TreeNode root, int distance, int[] count) {
    int[] distCount = new int[distance];
    if (root == null) {
      return distCount;
    }
    
    if (root.left == null && root.right == null) {
      distCount[1] = 1;
      return distCount;
    }
    
    int[] left = postorder(root.left, distance, count);
    int[] right = postorder(root.right, distance, count);
    
    for (int i = 1; i < distance; i++) {
      for (int j = 1; j < distance; j++) {
        if (i + j <= distance) {
          count[0] += left[i] * right[j];
        } else {
          break;
        }
      }
    }
    
    for (int i = 1; i < distance; i++) {
      distCount[i] = left[i - 1] + right[i - 1];
    }
    
    return distCount;
  }
}
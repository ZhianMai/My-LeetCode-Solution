/**
 * Problem #662
 */
class WidthOfBinaryTree {
  public int widthOfBinaryTree(TreeNode root) {
    Map<Integer, Integer> leftMostXY = new HashMap<>();
    int[] max = new int[1];
    preOrder(root, leftXY, max, 0, 0);
    return max[0];
  }
  
  private void preOrder(TreeNode root, Map<Integer, Integer> leftMostXY, int[] max, int x, int y) {
    if (root == null) {
      return;
    }
    
    if (!leftMostXY.containsKey(y)) {
      leftMostXY.put(y, x);
    }
    
    max[0] = Math.max(max[0], x - leftMostXY.get(y) + 1);
    
    preOrder(root.left, leftMostXY, max, x * 2, y + 1);
    preOrder(root.right, leftMostXY, max, x * 2 + 1, y + 1);
  }
}
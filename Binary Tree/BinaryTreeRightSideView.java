/**
 * Problem #199
 */
class BinaryTreeRightSideView {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      result.add(queue.peek().val);

      while (size-- != 0) {
        TreeNode curr = queue.poll();

        if (curr.right != null) {
          queue.offer(curr.right);
        }
        if (curr.left != null) {
          queue.offer(curr.left);
        }
      }
    }
    return result;
  }
}
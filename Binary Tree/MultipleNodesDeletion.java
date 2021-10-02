/**
* Problem #1110
*/
class MultipleNodesDeletion {
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    Set<Integer> set = new HashSet<>();

    for (int i : to_delete) {
      set.add(i);
    }

    Set<TreeNode> forest = new HashSet<>();

    root = postOrder(root, set, forest);

    if (root != null) {
      forest.add(root);
    }

    return new LinkedList<>(forest);
  }

  private TreeNode postOrder(TreeNode root, Set<Integer> set, Set<TreeNode> forest) {
    if (root == null) {
      return root;
    }

    root.left = postOrder(root.left, set, forest);
    root.right = postOrder(root.right, set, forest);

    if (set.contains(root.val)) {
      if (root.left != null) {
        forest.add(root.left);
        // root.left = null;
      }


      if (root.right != null) {
        forest.add(root.right);
        // root.right = null;
      }

      return null;
    }
    return root;
  }

  private void preOrder(TreeNode root, Set<Integer> set, Set<TreeNode> forest) {
    if (root == null) {
      return;
    }

    TreeNode left = root.left;
    TreeNode right = root.right;

    if (set.contains(root.val)) {
      if (forest.contains(root)) {
        forest.remove(root);
      }

      if (root.left != null) {
        forest.add(root.left);
        // root.left = null;
      }

      if (root.right != null) {
        forest.add(root.right);
        // root.right = null;
      }
    }

    if (root.left != null && set.contains(root.left.val)) {
      root.left = null;
    }

    if (root.right != null && set.contains(root.right.val)) {
      root.right = null;
    }

    preOrder(left, set, forest);
    preOrder(right, set, forest);
  }
}
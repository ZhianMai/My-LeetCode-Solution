/**
 * Problem #103
 */
class PrintBinaryTreeZigzag {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    
    if (root == null) {
      return result;
    }
    
    // Deque internal order: each level of the node is arranged from left to right 
    Deque<TreeNode> deque = new LinkedList<>();
    deque.offerFirst(root);
    boolean isZig = true;
    
    // Even level: zig, pollFirst - offerLast
    // Odd level:  zag, offerFirst - pollLast 
    while (!deque.isEmpty()) {
      List<Integer> temp = new ArrayList<>();
      int size = deque.size();
      
      if (isZig) {
        while (size-- != 0) {
          TreeNode curr = deque.pollFirst();
          temp.add(curr.val);
          
          if (curr.left != null) {
            deque.offerLast(curr.left);
          }
          
          if (curr.right != null) {
            deque.offerLast(curr.right);
          }
        }
      } else {
        while (size-- != 0) {
          TreeNode curr = deque.pollLast();
          temp.add(curr.val);
          
          if (curr.right != null) {
            deque.offerFirst(curr.right);
          }
          
          if (curr.left != null) {
            deque.offerFirst(curr.left);
          }
        }
      }
      
      isZig = !isZig;
      result.add(temp);
    }
    
    return result;
  }
}
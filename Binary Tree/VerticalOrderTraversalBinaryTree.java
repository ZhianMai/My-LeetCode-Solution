/**
 * Problem #987
 */
class VerticalOrderTraversalBinaryTree {
  class Node {
    int x;
    int y;
    int val;
  
    Node(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }
  }
  
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
      public int compare(Node one, Node two) {
        if (one.y == two.y) {
          if (one.x == two.x) {
            return Integer.compare(one.val, two.val);
          } else {
            return Integer.compare(one.x, two.x);
          }
        }
        return Integer.compare(one.y, two.y);
      }
    });
  
    preorder(root, 0, 0, minHeap);
  
    List<List<Integer>> result = new LinkedList<>();
  
    while (!minHeap.isEmpty()) {
      int y = minHeap.peek().y;
      List<Integer> list = new LinkedList<>();
    
      while (!minHeap.isEmpty() && minHeap.peek().y == y) {
        list.add(minHeap.poll().val);
      }
      result.add(list);
    }
    return result;
  }
  
  private void preorder(TreeNode root, int x, int y, PriorityQueue<Node> minHeap) {      
    minHeap.add(new Node(x, y, root.val));
  
    if (root.left != null) {
      preorder(root.left, x + 1, y - 1, minHeap);
    }
  
    if (root.right != null) {
      preorder(root.right, x + 1, y + 1, minHeap);
    }
  }
}
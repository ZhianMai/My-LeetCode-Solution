/**
 * This problem is not on leetcode.
 * https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1#
 */
 
/* A Binary Tree node
class Node {
  int data;
  Node left, right;
  Node(int item) {
    data = item;
    left = right = null;
  }
} */
class MinDistanceBetweenTwoNodes {
  int findDist(Node root, int a, int b) {
    // Your code here
    int[] dist = new int[]{-1};
    // Suppose one node is not the ancestor of another node
    findDistance1(root, a, b, dist);
    
    // One node is the ancestor of another node
    if (dist[0] == -1) {
      findDistance2(root, a, b, dist, -1);
    }
    
    return dist[0];
  }
    
  /**
   * Suppose two nodes are not the in the same path. If they're in the same
   * path, then dist[] would not update.
   */
  private int findDistance1(Node root, int a, int b, int[] dist) {
    if (root == null) {
      return -1;
    }
    
    if (root.data == a || root.data == b) {
      return 1;
    }
    
    int leftDist = findDistance1(root.left, a, b, dist);
    int rightDist = findDistance1(root.right, a, b, dist);
    
    if (leftDist != -1 && rightDist != -1) {
      // Update distance only on this node!
      dist[0] = leftDist + rightDist;
      return -1;
    } else if (leftDist == -1 && rightDist == -1) {
      return -1;
    } else {
      // The current node is between (a || b) and their LCA
      return Math.max(leftDist, rightDist) + 1;
    }
  }
    
  private void findDistance2(Node root, int a, int b, int[] dist, int height) {
    if (root == null) {
      return;
    }
    
    if (root.data == a || root.data == b) {
      if (height != -1) { // One node is found and it's my ancestor
        dist[0] = height;
        return;
      } else { // I'm the ancestor of another node
        findDistance2(root.left, a, b, dist, 1);
        findDistance2(root.right, a, b, dist, 1);
      }
    }
    
    // I'm in between node a and node b
    if (height != -1) {
      height++;
    }
    
    findDistance2(root.left, a, b, dist, height);
    findDistance2(root.right, a, b, dist, height);
  }
}
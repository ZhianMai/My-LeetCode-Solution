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
    findDistance1(root, a, b, dist);
    
    if (dist[0] == -1) {
      findDistance2(root, a, b, dist, -1);
    }
    
    return dist[0];
  }
    
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
      dist[0] = leftDist + rightDist;
      return -1;
    } else if (leftDist == -1 && rightDist == -1) {
      return -1;
    } else {
      return Math.max(leftDist, rightDist) + 1;
    }
  }
    
  private void findDistance2(Node root, int a, int b, int[] dist, int height) {
    if (root == null) {
      return;
    }
    
    if (root.data == a || root.data == b) {
      if (height != -1) {
        dist[0] = height;
        return;
      } else {
        findDistance2(root.left, a, b, dist, 1);
        findDistance2(root.right, a, b, dist, 1);
      }
    }
    
    if (height != -1) {
      height++;
    }
    
    findDistance2(root.left, a, b, dist, height);
    findDistance2(root.right, a, b, dist, height);
  }
}
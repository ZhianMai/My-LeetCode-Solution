/**
 * Problem #297
 */
public class SerializeDeserializeTree {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    preorderSerialize(root, sb);
    return sb.toString();
  }
  
  private void preorderSerialize(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append('N');
      return;
    }
    
    sb.append(String.valueOf(root.val));
    sb.append('L'); // Mark end of numeric value
    preorderSerialize(root.left, sb);
    sb.append('R'); // Mark end of numeric value
    preorderSerialize(root.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    return preorderSerialize(data.toCharArray(), new int[]{0});
  }
  
  private TreeNode preorderSerialize(char[] data, int[] idx) {
    if (idx[0] >= data.length || data[idx[0]] == 'N') {
      idx[0]++;
      return null;
    }
    
    int val = 0;
    int sign = 1;
    
    // Determine the sign of number
    if (idx[0] < data.length && data[idx[0]] == '-') {
      idx[0]++;
      sign = -1;
    }
    
    // Read numeric value
    while (idx[0] < data.length && Character.isDigit(data[idx[0]])) {
      val *= 10;
      val += (data[idx[0]] - '0');
      idx[0]++;
    }
    
    // Build left & right subtree
    TreeNode root = new TreeNode(val * sign);
    idx[0]++;
    root.left = preorderSerialize(data, idx);
    idx[0]++;
    root.right = preorderSerialize(data, idx);
    return root;
  }
}
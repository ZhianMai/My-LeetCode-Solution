/**
 * Problem #652 
 */
class FindDuplicatedSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
      List<TreeNode> result = new LinkedList<>();
      postorder(root, result, new HashMap<String, Boolean>());
      return result;
    }
    
    private String postorder(TreeNode root, List<TreeNode> result, Map<String, Boolean> hashMap) {
      if (root == null) {
        return "";
      }
      
      String curr = postorder(root.left, result, hashMap) + "," + 
                    postorder(root.right, result, hashMap) + "," + root.val;
      
      Boolean record = hashMap.get(curr);
      
      if (record == null) {
        hashMap.put(curr, false);
      } else if (!record) {
        result.add(root);
        hashMap.put(curr, true);
      }

      return curr;
    }
}
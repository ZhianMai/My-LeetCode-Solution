/**
 * Problem #508
 */
class MostFrequentSubtreeSum {
  public int[] findFrequentTreeSum(TreeNode root) {
    int[] maxFreq = new int[]{-1};
    Map<Integer, Integer> map = new HashMap<>();
    postorder(root, map, maxFreq);
    
    List<Integer> set = new LinkedList<>();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == maxFreq[0]) {
        set.add(entry.getKey());
      }
    }
    
    int[] result = new int[set.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = set.get(i);
    }
    
    return result;
  }
  
  private int postorder(TreeNode root, Map<Integer, Integer> map, int[] maxFreq) {
    if (root == null) {
      return 0;
    }
    
    int left = postorder(root.left, map, maxFreq);
    int right = postorder(root.right, map, maxFreq);
    int sum = left + right + root.val;
    Integer count = map.getOrDefault(sum, 0) + 1;
    
    map.put(sum, count);
    maxFreq[0] = Math.max(maxFreq[0], count);
    
    return sum;
  }
}
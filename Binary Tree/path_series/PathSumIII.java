/**
 * Problem #437
 */
class PathSumIII {
  public int pathSum(TreeNode root, int targetSum) {
    int[] count = new int[1];
    // <prefixVal, count>
    Map<Integer, Integer> prefixSum = new HashMap<>();
    helper(root, prefixSum, targetSum, count, 0);
    return count[0];
  }
  
  private void helper(TreeNode root, Map<Integer, Integer> prefixSum, int target, 
                      int[] count, int prevSum) {
    if (root == null) {
      return;
    }

    prevSum += root.val;
    Integer existedPrefix = prefixSum.get(prevSum);
    
    if (prevSum == target) {
      count[0]++;
    }
    
    Integer result = prefixSum.get(prevSum - target);
    if (result != null) {
      count[0] += result;
    }
    
    if (existedPrefix != null) {
      prefixSum.put(prevSum, existedPrefix + 1);
    } else {
      // existedPrefix = 0;
      prefixSum.put(prevSum, 1);
    }
    
    helper(root.left, prefixSum, target, count, prevSum);
    helper(root.right, prefixSum, target, count, prevSum);
    
    prefixSum.put(prevSum, existedPrefix);
  }
}
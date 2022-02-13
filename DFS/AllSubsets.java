/**
 * Problem #78
 */
class AllSubsets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new LinkedList<>();
    result.add(new LinkedList<>());
    dfs(result, nums, new LinkedList<>(), 0);
    return result;
  }
  
  private void dfs(List<List<Integer>> result, int[] nums, List<Integer> curr, int level) {
    if (level == nums.length) {
      return;
    }
    
    for (int i = level; i < nums.length; i++) {
      curr.add(nums[i]);
      result.add(new LinkedList<>(curr));
      dfs(result, nums, curr, i + 1);
      curr.remove(curr.size() - 1);
    }
  }
}
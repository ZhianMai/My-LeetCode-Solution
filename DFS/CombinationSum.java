/**
 * Problem #39
 */
class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new LinkedList<>();
    dfs(result, new LinkedList<Integer>(), candidates, target, 0);
    return result;
  }
  
  private void dfs(List<List<Integer>> result, List<Integer> curr, int[] candidates,
                  int remains, int level) {
    if (level == candidates.length) {
      if (remains == 0) {
        result.add(new LinkedList<>(curr));
      }
      return;
    }
    
    int times = remains / candidates[level];
    
    for (int i = 0; i <= times; i++) {
      for (int j = 0; j < i; j++) {
          curr.add(candidates[level]);
      }
        
      dfs(result, curr, candidates, remains - i * candidates[level], level + 1);
      
      for (int j = 0; j < i; j++) {
          curr.remove(curr.size() - 1);
      }
    }
  }
}
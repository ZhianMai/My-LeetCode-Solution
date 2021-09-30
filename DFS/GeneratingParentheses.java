/**
* Problem #22
*/
class GeneratingParentheses {
  public List<String> generateParenthesis(int n) {
    List<String> result = new LinkedList<>();
    
    dfs(result, new char[n * 2], n, n, 0);
    
    return result;
  }
  
  private void dfs(List<String> result, char[] curr, int leftRemain, int rightRemain, int level) {
    if (level == curr.length) {
      result.add(new String(curr));
      return;
    }

    if (leftRemain > 0) {
      curr[level] = '(';
      dfs(result, curr, leftRemain - 1, rightRemain, idx + 1);
    }

    if (rightRemain > leftRemain) {
      curr[level] =')';
      dfs(result, curr, leftRemain, rightRemain - 1, idx + 1);
    }
  }
}
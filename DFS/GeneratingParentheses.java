/**
* Problem #22
*/
class GeneratingParentheses {
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
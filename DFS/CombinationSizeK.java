/**
* Problem #77
* 
* Time: O((n - k)^k), Space: O(k).
*
* Most solutions calculate all subsets and records the subset with size k. This is extremely
* slow since it creates a lot of useless result.
*
* I implemented two ways to record current results: fixed-size array and ArrayList.
* I fixed k = 2, and if n < 7000, ArrayList is faster; if n > 7000, int[] is much faster!
* Different pc should have different performance threshold.
*
* So the runtime shown on Leetcode does not mean a lot.
*/
class CombinationSizeK {
  public List<List<Integer>> combine1(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();

    dfs1(n, result,new int[k], k, 1, n - k);

    return result;
  }

  private void dfs1(int n, List<List<Integer>> result, int[] curr, int dfsLeft, int begin, int range) {
    if (dfsLeft == 0) {
      List<Integer> temp = new ArrayList<>();

      for (int i : curr) {
        temp.add(i);
      }

      result.add(temp);
      return;
    }

    for (int i = begin; i <= n && i <= begin + range; i++) {
      curr[curr.length - dfsLeft] = i;
      dfs1(n, result, curr, dfsLeft - 1, i + 1, range);
    }
  }

  public List<List<Integer>> combine2(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();

    dfs2(n, result,new ArrayList<Integer>(), k, 1, n - k);

    return result;
  }

  private void dfs2(int n, List<List<Integer>> result, List<Integer> curr, int dfsLeft, int begin, int range) {
    if (dfsLeft == 0) {
      result.add(new ArrayList<>(curr));
      return;
    }

    for (int i = begin; i <= n && i <= begin + range; i++) {
      curr.add(i);
      dfs2(n, result, curr, dfsLeft - 1, i + 1, range);
      curr.remove(curr.size() - 1);
    }
  }

  public static void main(String[] args) {
    CombinationSizeK main = new Main();

    int n = 7000;
    int k = 2;
    long startTime = System.nanoTime();
    List<List<Integer>> result1 = main.combine1(n, k);
    System.out.println(result1.size());
    long endTime = System.nanoTime();
    System.out.println("My Total time: " + (endTime - startTime) / 1000000000);

    startTime = System.nanoTime();
    List<List<Integer>> result2 = main.combine2(n, k);
    System.out.println(result2.size());
    endTime = System.nanoTime();
    System.out.println("Ass Total time: " + (endTime - startTime) / 1000000000);
  }
}
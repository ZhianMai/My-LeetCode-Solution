/**
 * Leetcode #84
 */
class LargestRectangleInHistogram {
  public int largestRectangleArea(int[] array) {
    int result = 0;
    // offerFirst(), pollFirst()
    // Stack stores idx, not array[idx], because the last idx is arr.length
    Deque<Integer> stack = new LinkedList<>();
    
    for (int i = 0; i <= array.length; i++) {
      int curr = (i == array.length ? 0 : array[i]);
      
      while (!stack.isEmpty() && array[stack.peekFirst()] >= curr) {
        int height = array[stack.pollFirst()];
        int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
        result = Math.max(result, height * (i - left));
      }
      stack.offerFirst(i);
      for (int j : stack) {
        System.out.print(j + ",");
      }
      System.out.println();
    }
    return result;
  }
}
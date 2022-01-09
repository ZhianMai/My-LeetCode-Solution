/**
 * Prblem #503
 */
class NextGreaterElementII {
  public int[] nextGreaterElements(int[] nums) {
    int len = nums.length;
    int[] result = new int[len];
    // Descending order from top to bottom
    Deque<Integer> stack = new LinkedList<>();
    
    for (int i = len * 2 - 1; i > -1; i--) {
      while (!stack.isEmpty() && stack.peekLast() <= nums[i % len]) {
        stack.pollLast();
      }
      result[i % len] = stack.isEmpty() ? -1 : stack.peekLast();
      stack.offerLast(nums[i % len]);
    }
    return result;
  }
}
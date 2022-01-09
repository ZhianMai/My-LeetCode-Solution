/**
 * Prblem #496
 */
class NextGreaterElementI {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {       
    // monotonic stack, stores elements in increasing order, top = smallest
    Stack<Integer> stack = new Stack<>();
    int[] greater = new int[nums2.length];
    Arrays.fill(greater, -1);
    Map<Integer, Integer> indexOf = new HashMap<>();

    // Loop through and find out next greater element for all elements
    // If the sequence decreases then push it to stack and track it back later
    for(int i = 0; i < nums2.length; i++) {
      while(!stack.isEmpty() && (nums2[i] > nums2[stack.peek()])) {
        int index = stack.pop();
        greater[index] = nums2[i]; // i element greater than the index element
      }

      stack.push(i);
      indexOf.put(nums2[i], i);
    }

    int[] ans = new int[nums1.length];

    for(int i = 0; i < nums1.length; i++) {
      ans[i] = greater[indexOf.get(nums1[i])];
    }

    return ans;
  }
}
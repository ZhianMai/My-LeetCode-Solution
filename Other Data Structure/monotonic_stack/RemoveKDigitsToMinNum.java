/**
 * Problem #402
 */
class RemoveKDigitsToMinNum {
  public String removeKdigits(String num, int k) {
    // To get the minimum number after removing k digits, the number should delete digits
    // starting at the left side to maintain ascending order from left to right.
    
    // offerLast, pollLast, peekLast
    // Monostic stack, with property: when k != 0, from the stack top to bottom all
    // elements are in descending order
    Deque<Character> stack = new LinkedList<>();
    
    for (char ch : num.toCharArray()) {
      while (!stack.isEmpty() && stack.peekLast() > ch && k != 0) {
        System.out.println("A: poll: " + stack.peekLast() + ", curr: " + ch);
        k--;
        stack.pollLast();
      }
      
      if (!stack.isEmpty() || ch != '0') { // Avoid leading zero
        stack.offerLast(ch);
      }
    }
    
    while (k > 0) {
      stack.pollLast();
      k--;
    }
    
    if (stack.isEmpty()) {
      return "0";
    }
    
    StringBuilder sb = new StringBuilder();
    
    while (!stack.isEmpty()) {
      sb.append(stack.pollFirst());
    }
    
    return sb.toString();
  }
}
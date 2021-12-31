/**
 * Problem #1209
 */
class RemoveAdjacentKDuplicate {
  public String removeDuplicates(String s, int k) {
    char[] input = s.toCharArray(); // Simulate string is mutable!!!
    // slow: end of the result substring, i.e. input[slow - 1] is the last ele in result subarray
    int slow = 0;
    // fast: begin of the unelored substring, i.e. input[fast] is the current char to operate
    int fast = 0;
    
    // segment: substring with same chars
    while (fast < input.length) {
      char curr = input[fast]; // Begin of the segment
      int segBeging = fast;
      int charCount = 0; // == fast - segBegin
      
      // Step one: confirm the length of the segment
      while (fast < input.length && input[fast] == curr) {
        fast++;
        charCount++;
      } // input[fast]: next segment, charCount: curr segment length
      
      // Step two: calculate segment length to keep
      // count = 9, k = 2, 9 % 2 = 1
      // charCount %= k;
      
      // Step three: check the top of the stack char
      while (slow > 0 && input[slow - 1] == curr) {
        slow--;
        charCount++;
      } // input[slow]: end of previous kept element, i.e. if the prev top ele is curr
        // it will remove from the result stack 
      
      charCount %= k;
      
      // Step four: copy the kept segment to the result substring
      while (charCount-- > 0) {
        input[slow++] = curr;
      }
    }
    
    return new String(input, 0, slow);
    
    // Runtime: each char deletes at most ONE time, read constant time: O(n)
    // Space: O(1), assume String -> char[]
  }
}
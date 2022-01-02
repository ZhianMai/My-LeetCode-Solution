/**
 * Problem #438
 */
class FindAllAnagrams {
  public List<Integer> findAnagrams(String s, String p) {
    if (s == null || p == null || s.length() < p.length() || p.length() == 0) {
      return new LinkedList();
    }
    
    List<Integer> result = new LinkedList();
    Map<Character, Integer> freqMap = new HashMap<>();
    char[] input = s.toCharArray();
    
    for (char ch : p.toCharArray()) {
      Integer freq = freqMap.get(ch);
      freq = freq == null ? 1 : freq + 1;
      freqMap.put(ch, freq);
    }
    
    int disMatched = freqMap.size();
    // System.out.println("disMatched: " + disMatched);
    
    for (int begin = 0; begin < input.length; begin++) {
      Integer count = freqMap.get(input[begin]);
      
      // Insert the new char into freqMap
      if (count != null) {
        if (count == 1) {
          // System.out.println("Insert char: " + input[begin] + ", idx: " + begin);
          disMatched--;
        }
        
        freqMap.put(input[begin], count - 1);
      }
      
      // Delete the tail char from freqMap
      if (begin >= p.length()) {
        count = freqMap.get(input[begin - p.length()]);
        
        if (count != null) {
          if (count == 0) {
            // System.out.println("Delete char: " + input[begin] + ", idx: " + begin);
            disMatched++;
          }
          
          freqMap.put(input[begin - p.length()], count + 1);
        }
      }
      
      if (disMatched == 0) {
        result.add(begin - p.length() + 1);
      }
    } // end for loop
    return result;
  }
}
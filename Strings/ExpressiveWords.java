/**
 * Problem #809
 */

class ExpressiveWords {
  public int expressiveWords(String s, String[] words) {
    int count = 0;
    char[] input = s.toCharArray();
    
    for (String str : words) {
      if (isExpressive(input, str.toCharArray())) {
        count++;
      }
    }
    return count;
  }
  
  private boolean isExpressive(char[] target, char[] input) {
    if (target.length < input.length) {
      return false;
    }
    
    // Pointer of input array, input[iPtr] is the current char to check
    int iPtr = 0;
    // Pointer of target array, input[iPtr] is the current char to check
    int tPtr = 0;
    
    while (iPtr < input.length && tPtr < target.length) {
      if (target[tPtr] != input[iPtr]) {
        return false;
      }
      
      int count = 0;
      char curr = input[iPtr];
      
      while (tPtr < target.length && iPtr < input.length &&
             target[tPtr] == curr && input[iPtr] == curr) {
        count++;
        iPtr++;
        tPtr++;
      }
      
      if (tPtr < target.length && target[tPtr] == curr) {
        
        while (tPtr < target.length && target[tPtr] == curr) {
          tPtr++;
          count++;
        }
        
        if (count < 3) {
          return false;
        }
      }
    }
    
    if (iPtr == input.length && tPtr == target.length) {
      return true;
    }
    
    return false;
  }
}
/**
 * Problem #468
 */
class ValidateIPAddress {
  public String validIPAddress(String queryIP) {
    char[] input = queryIP.toCharArray();
    int dotCount = 0;
    int colCount = 0;
    
    for (char ch : input) {
      if (ch == ':') {
        colCount++;
      }
      
      if (ch == '.') {
        dotCount++;
      }
    }
    
    // if dot == 3 || col == 7, true
    // if dot != 3 && col != 7, false
    if (dotCount != 3 && colCount != 7) {
      System.out.println("1: " + dotCount);
      return "Neither";
    }
    
    if (dotCount == 3) {
      if (isValidIPv4(input)) {
        return "IPv4";
      } else {
        return "Neither";
      }
    }
    
    if (isValidIPv6(input)) {
      return "IPv6";
    } else {
      return "Neither";
    }
  }
  
  private boolean isValidIPv4(char[] input) {
    if (input[input.length - 1] == '.') {
      return false;
    }
    
    // input pointer, input[ptr] is the current digit to process
    int ptr = 0;
    
    while (ptr < input.length) {
      int digitCount = 0;
      int currDigit = 0;
      
      while (ptr < input.length && input[ptr] != '.') {
        if (!Character.isDigit(input[ptr])) {
          System.out.println("2");
          return false;
        }
        
        digitCount++;
        currDigit *= 10;
        currDigit += (input[ptr] - '0');
        
        if (currDigit == 0 && 
            (ptr + 1 == input.length || input[ptr + 1] != '.')) { // Leading zero
          System.out.println("3");
          return false;
        }
        
        ptr++;
      } // ptr ends at '.'
      
      if (digitCount == 0 || digitCount > 3 || currDigit > 255) {
        System.out.println("4");
        return false;
      }
      
      ptr++; // skip '.' 
    }
    
    return true;
  }
  
  private boolean isValidIPv6(char[] input) {
    if (input[input.length - 1] == ':') {
      return false;
    }
    
    // input pointer, input[ptr] is the current digit to process
    int ptr = 0;
    
    while (ptr < input.length) {
      int digitCount = 0;
      
      while (ptr < input.length && input[ptr] != ':') {
        digitCount++;
        
        if (!isValidHex(input[ptr])) {
          return false;
        }
        
        ptr++;
      } // ptr ends at ':'
      
      if (digitCount == 0 || digitCount > 4) {
        return false;
      }
      
      ptr++; // skip ':' 
    }
    
    return true;
  }
  
  private boolean isValidHex(char ch) {
    return Character.isDigit(ch) || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F');
  }
}
 
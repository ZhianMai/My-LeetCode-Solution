/**
 * Problem #318
 */
class MaxProductStringLength {
  public int maxProduct(String[] words) {
    HashMap<String, Integer> bitMap = new HashMap<>();
    
    for (String str : words) {
      int bit = 0;
      
      for (char ch : str.toCharArray()) {
        bit |= 1 << (ch - 'a');
      }
      
      bitMap.put(str, bit);
    }
    
    Arrays.sort(words, new Comparator<String>() {
      @Override
      public int compare (String a, String b) {
        return Integer.compare(a.length(), b.length()) * -1;
      }
    });
    
    int max = 0;
    
    for (int i = 1; i < words.length; i++) {
      for (int j = 0; j < i; j++) {
        int product = words[i].length() * words[j].length();
        
        if (product < max) {
          break;
        }
        
        int a = bitMap.get(words[i]);
        int b = bitMap.get(words[j]);
        
        if ((a & b) == 0) {
          max = product;
        }
      }
    }
    
    return max;
  }
}
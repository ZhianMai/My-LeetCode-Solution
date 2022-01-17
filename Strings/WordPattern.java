/**
 * Problem #290
 */

class WordPattern {
  public boolean wordPattern(String pattern, String s) {
    String[] words = s.split(" ");
    char[] pat = pattern.toCharArray();
    Map<String, Character> wordToChar = new HashMap<>();
    boolean[] usedChar = new boolean[26];
    
    if (pat.length != words.length) {
      return false;
    }
    
    for (int i = 0; i < pat.length; i++) {
      Character curr = wordToChar.get(words[i]);
      
      if (curr == null && !usedChar[pat[i] - 'a']) {
        // char not paired with string
        wordToChar.put(words[i], pat[i]);
        usedChar[pat[i] - 'a'] = true;
      } else if (curr == null && usedChar[pat[i] - 'a']) {
        // current string not paired, but the current pattern char paired
        return false;
      } else if (!curr.equals(pat[i])) {
        // used char not match current pattern char
        return false;
      }
    }
    
    return true;
  }
}
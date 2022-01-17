/**
 * Problem #127
 */
class WordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> dict = new HashSet<>(wordList);
    
    if (!dict.contains(endWord)) {
      return 0;
    }
    
    int count = 1;
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    dict.remove(beginWord);
    
    while (!queue.isEmpty()) {
      int size = queue.size();
      boolean found = false;
      // System.out.print("\nX");
      
      while (size-- != 0) {
        char[] curr = queue.poll().toCharArray();
      
        for (int i = 0; i < curr.length; i++) {
          char prev = curr[i];
          
          for (char j = 'a'; j <= 'z'; j++) {
            curr[i] = j;
            String temp = new String(curr, 0, curr.length);
            
            if (endWord.equals(temp)) {
              return count + 1;
            }
            
            if (dict.contains(temp)) {
              // System.out.print(" " + temp + ",");
              queue.add(temp);
              dict.remove(temp);
              found = true;
            }
          }
          curr[i] = prev;
        } // end for
      } // end while (size-- != 0)
      
      if (found) {
        count++;
      }
      
    } // end while
    
    return 0;
  }
}
/**
 * Problem #36
 */
class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    for (char[] i : board) {
      Set<Character> set = new HashSet<>();
      for (char ch : i) {
        if (ch != '.') {
          if (set.contains(ch)) {
            return false;
          }
          set.add(ch);
        }
      }
    }
    
    for (int i = 0; i < 9; i++) {
      Set<Character> set = new HashSet<>();
      for (int j = 0; j < 9; j++) {
        if (board[j][i] != '.') {
          if (set.contains(board[j][i])) {
            return false;
          }
          set.add(board[j][i]);
        }
      }
    }
    
    for (int i = 0; i < 9; i++) {
      int x = i % 3 * 3;
      int y = i / 3 * 3;
      Set<Character> set = new HashSet<>();
      
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          if (board[x + j][y + k] != '.') {
            if (set.contains(board[x + j][y + k])) {
              return false;
            }
            set.add(board[x + j][y + k]);
          }
        }
      }
    }
    return true;
  }
}
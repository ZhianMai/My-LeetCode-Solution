/**
* Problem #79
*/

class WordSearch {
  private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  public boolean exist(char[][] board, String word) {
    Set<Character> set = new HashSet<>();
    char[] input = word.toCharArray();
    for (char[] row : board) {
      for (char letter : row) {
        set.add(letter);
      }
    }

    for (char ch: input) {
      if (!set.contains(ch)) {
        return false;
      }
    }

    // Do backtracking
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == input[0] && dfs(board, input, i, j, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  boolean dfs(char[][] board, char[] input, int row, int col, int index) {
    if (index == input.length - 1) {
      return true;
    }

    char prevValue = board[row][col];
    board[row][col] = '*';
    boolean found = false;

    for (int[] dir : DIRS) {
      int x = row + dir[0];
      int y = col + dir[1];

      // Reduce unnecessary dfs.
      if (!found && x >= 0 && x < board.length && y >= 0 && y < board[0].length &&
          board[x][y] == input[index + 1]) {
        found |= dfs(board, input, x, y, index + 1);
      }
    }

    board[row][col] = prevValue;
    return found;
  }
}

class Solution {
    private final static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public boolean exist(char[][] board, String word) {
        char[] wordArr = word.toCharArray();
        Set<Integer>[] visited = new Set[board.length * board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == wordArr[0] && 
                    exist(board, wordArr, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, char[] word,
            int x, int y, int index, Set<Integer>[] visited) {
        if (index == word.length - 1) {
            return true;
        }
        
        int m = board.length;
        int n = board[0].length;
        int coordinate = x * n + y;
        
        if (visited[coordinate] == null) {
            visited[coordinate] = new HashSet<Integer>();
        } else {
            if (visited[coordinate].contains(index)) {
                return false;
            }    
            visited[coordinate].add(index);
        }
        
        char tmp = board[x][y];
        board[x][y] = '.';
        for (int[] dir : dirs) {
            int newx = x + dir[0];
            int newy = y + dir[1];

            if (newx < 0 || newx >= m || newy < 0 || newy >= n || board[newx][newy] == '.') {
                continue;
            }
            
            if (board[newx][newy] == word[index + 1] && 
                exist(board, word, newx, newy, index + 1, visited)) {
                return true;       
            }
        }
        
        board[x][y] = tmp;
        return false;
    }
}
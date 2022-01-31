/**
 * Problem #200
 */
class NumberOfIslands {
  private static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  
  public int numIslands(char[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    Set<Integer> islandPt = new HashSet<>();
    
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == '1') {
          islandPt.add(row * cols + col);
        }
      }
    }
    
    int total = 0;
    boolean[][] enqueued = new boolean[rows][cols];
    
    while (!islandPt.isEmpty()) {
      int next = getPoint(islandPt);
      Queue<Integer> queue = new LinkedList<>();
      queue.offer(next);
      enqueued[next / cols][next % cols] = true;
      total++;
      
      while (!queue.isEmpty()) {
        int curr = queue.poll();
        int currX = curr / cols;
        int currY = curr % cols;
        islandPt.remove(curr);
        
        for (int[] dir : dirs) {
          int nextX = currX + dir[0];
          int nextY = currY + dir[1];
          
          if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols &&
              !enqueued[nextX][nextY] && grid[nextX][nextY] == '1') {
            queue.offer(nextX * cols + nextY);
            enqueued[nextX][nextY] = true;
          }
        }
      }
    
    } // end while-set
    
    return total;
  }
  
  private int getPoint(Set<Integer> set) {
    int next = 0;
    
    for (int i : set) {
      next = i;
      break;
    }
    
    set.remove(next);
    return next;
  }
}
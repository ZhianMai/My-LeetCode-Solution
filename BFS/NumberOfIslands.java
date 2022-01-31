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
  
  public int numIslands2(char[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];
    int total = 0;
    
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == '1' && !visited[i][j]) {
          total++;
          bfs(grid, visited, i, j);
        }
      }
    }
    return total;
  }
  
  private void bfs(char[][] grid, boolean[][] visited, int x, int y) {
    int cols = grid[0].length;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(x * cols + y);
    
    while (!queue.isEmpty()) {
      int curr = queue.poll();
      int currX = curr / cols;
      int currY = curr % cols;
      visited[currX][currY] = true;
      
      for (int[] dir : dirs) {
        int nextX = currX + dir[0];
        int nextY = currY + dir[1];
        
        if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < cols &&
            !visited[nextX][nextY] && grid[nextX][nextY] == '1') {
          queue.offer(nextX * cols + nextY);
          visited[nextX][nextY] = true;
        }
      }
    }
  }
  
  public int numIslands3(char[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];
    int total = 0;
    
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == '1' && !visited[i][j]) {
          total++;
          dfs(grid, visited, i, j);
        }
      }
    }
    return total;
  }
  
  private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
    if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length &&
        !visited[i][j] && grid[i][j] == '1') {
      visited[i][j] = true;
      
      for (int[] dir : dirs) {
        dfs(grid, visited, i + dir[0], j + dir[1]);
      }
    }
  }
}
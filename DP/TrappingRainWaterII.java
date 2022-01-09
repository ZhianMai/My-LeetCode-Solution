/**
* Problem #407
*/
class TrappingRainWaterII {
  private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  static class Cell {
    int row;
    int col;
    int height;
    public Cell (int row, int col, int height, boolean[][] visited) {
      this.row = row;
      this.col = col;
      this.height = height;
      visited[row][col] = true;
    }
  }

  public int trapRainWater(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    if (rows < 3 || cols < 3) {
      return 0;
    }

    Queue<Cell> minHeap = new PriorityQueue<>(new Comparator<Cell>(){
        @Override
        public int compare(Cell a, Cell b) {
          if (a.height == b.height) {
            return 0;
          }
          return a.height < b.height ? -1 : 1;
        }
    });

    boolean[][] visited = new boolean[rows][cols];

    for (int i = 0; i < cols; i++) {
      minHeap.offer(new Cell(0, i, matrix[0][i], visited));
      minHeap.offer(new Cell(rows - 1, i, matrix[rows - 1][i], visited));
    }

    for (int i = 0; i < rows; i++) {
      minHeap.offer(new Cell(i, 0, matrix[i][0], visited));
      minHeap.offer(new Cell(i, cols - 1, matrix[i][cols - 1], visited));
    }
    
    int result = 0;
    while (!minHeap.isEmpty()) {
      Cell curr = minHeap.poll();
      
      for (int[] dir : dirs) {
        int row = dir[0] + curr.row;
        int col = dir[1] + curr.col;
        if (row > 0 && col > 0 && row < rows - 1 &&
            col < cols - 1 && !visited[row][col]) {
          result += Math.max(0, curr.height - matrix[row][col]);
          int height = Math.max(curr.height, matrix[row][col]);
          minHeap.offer(new Cell(row, col, height, visited));
        }
      }
    }
    return result;
  }
}
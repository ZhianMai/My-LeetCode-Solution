/**
* Problem #51
*/
class NQueens {
  private static char[] queenRow;
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>(n);
        queenRow = new char[n];
        int[] curr = new int[n];
        
        boolean[] usedCols = new boolean[n];
        boolean[] usedDiagonals = new boolean[n * 2 - 1];
        boolean[] usedRevDiagonals = new boolean[n * 2 - 1];
        
        Arrays.fill(queenRow, '.');
        
        helper(result, curr, 0, usedCols, usedDiagonals, usedRevDiagonals);
        
        return result;
    }
    
    // int[] curr represents queen location.
    // index i: queen row;
    // curr[i]: queen column.
    private void helper(List<List<String>> result, int[] curr, int row,
            boolean[] usedCols, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
        if (row == curr.length) {
            List<String> temp = printQueen(curr);
            result.add(temp);
            
            return;
        }
        
        for (int i = 0; i < curr.length; i++) {
            if (valid(curr.length, i, row, usedCols, usedDiagonals, usedRevDiagonals)) {
                usedCols[i] = true;
                usedDiagonals[i + row] = true;
                usedRevDiagonals[i - row + curr.length - 1] = true;
                
                curr[row] = i;
                helper(result, curr, row + 1, usedCols, usedDiagonals, usedRevDiagonals);
                
                usedCols[i] = false;
                usedDiagonals[i + row] = false;
                usedRevDiagonals[i - row + curr.length - 1] = false;
            }
        }
    }
    
    private boolean valid(int n, int col, int row, boolean[] usedCols, 
                          boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
        return !usedCols[col] && !usedDiagonals[col + row] && !usedRevDiagonals[n - row + col - 1];
    }
    
    private List<String> printQueen(int[] queenList) {
        List<String> result = new LinkedList<>();
 
        for (int i : queenList) {
            queenRow[i] = 'Q';
            result.add(new String(queenRow));
            queenRow[i] = '.';
        }
        
        return result;
    }
}
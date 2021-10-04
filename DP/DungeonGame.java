/**
* Problem #174
*/
class DungeonGame {
  public int calculateMinimumHP(int[][] dungeon) {
    int rows = dungeon.length;
    int cols = dungeon[0].length;

    // dp[i][j]: fewest point to move to destination
    int[][] dp = new int[rows + 1][cols + 1];

    for(int i = 0; i <= rows; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }

    // Init: these two slot can move to the destination
    dp[rows][cols - 1] = 1;
    dp[rows - 1][cols] = 1;

    for (int i = rows - 1; i >= 0; i--) {
      for (int j = cols - 1; j >= 0; j--) {
        // Select the fewest point from down and right
        // Then minus the current "life boost"
        int minHP = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];

        dp[i][j] = minHP < 1 ? 1 : minHP;

      }
    }
    return dp[0][0];
  }
}
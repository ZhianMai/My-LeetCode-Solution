/**
 * Problem #121
 */
class StockI {
  // StockI: buy & sell stock exactlly once.
  public int maxProfit(int[] prices) {
    int buy = prices[0];
    int profit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (buy > prices[i]) {
        buy = prices[i]; // buy when price is minimum
      } else if (prices[i] - buy > profit) {
        profit = prices[i] - buy; // sell only when we have max profit
      }
    }
    return profit;
  }
}
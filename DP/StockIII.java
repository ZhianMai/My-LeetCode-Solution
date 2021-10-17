/**
 * Problem #123
 */
class StockIII {
  // Buy & sell stocks two times exactlly
  public int maxProfitI(int[] prices) {
    int buyFirst = Integer.MIN_VALUE;  // First time buying stock
    int buySecond = Integer.MIN_VALUE; // Second time buying stock
    int sellFirst = 0;  // First time selling stock
    int sellSecond = 0; // Second time selling stock

    for (int i : prices) {
      buyFirst = Math.max(buyFirst, i * -1);
      sellFirst = Math.max(sellFirst, buyFirst + i);
      buySecond = Math.max(buySecond, sellFirst - i);
      sellSecond = Math.max(sellSecond, buySecond + i);
    }
    return sellSecond;
  }
  
  public int maxProfitII(int[] prices) {
    int length = prices.length;
    int[] buyFirst = new int[length + 1];  // First time buying stock
    int[] buySecond = new int[length + 1]; // Second time buying stock
    int[] sellFirst = new int[length + 1];;  // First time selling stock
    int[] sellSecond = new int[length + 1];; // Second time selling stock
    buyFirst[0] = Integer.MIN_VALUE;
    buySecond[0] = Integer.MIN_VALUE;
    sellFirst[0] = 0;
    sellSecond[0] = 0;

    for (int i = 0; i < length; i++) {
      buyFirst[i + 1] = Math.max(buyFirst[i], -prices[i]);
      sellFirst[i + 1] = Math.max(sellFirst[i], buyFirst[i + 1] + prices[i]);
      buySecond[i + 1] = Math.max(buySecond[i], sellFirst[i + 1] - prices[i]);
      sellSecond[i + 1] = Math.max(sellSecond[i], buySecond[i + 1] + prices[i]);
    }
    return sellSecond[length];
  }
}
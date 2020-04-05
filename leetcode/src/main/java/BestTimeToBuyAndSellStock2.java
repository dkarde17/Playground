/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        boolean holdingStock = false;
        int profit = 0;
        int buyingPrice = 0;
        int i = 0;
        while(i < prices.length - 1) {
            if(!holdingStock && prices[i] <= prices[i+1]) {
                buyingPrice = prices[i];
                holdingStock = !holdingStock;
            }
            else if (holdingStock && prices[i] > prices[i + 1]){
                profit += prices[i] - buyingPrice;
                holdingStock = !holdingStock;
            }
            i++;
        }
        if (holdingStock)
            profit += prices[i] - buyingPrice;
        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock2 = new BestTimeToBuyAndSellStock2();
        int[] prices = {1, 2, 3, 4, 5};
        bestTimeToBuyAndSellStock2.maxProfit(prices);
    }

    public int maxProfit_leetCodeSolution(int[] prices) {
        int res = 0;
        for(int i = 1; i < prices.length; i++)
            if(prices[i] > prices[i - 1])
                res += prices[i] - prices[i - 1];
        return res;
    }
}

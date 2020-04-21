/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int buyingPriceIndex = 0, sellingPriceIndex = 0;
        int currentProfit = 0, maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[sellingPriceIndex]) {
                sellingPriceIndex = i;
                currentProfit = prices[sellingPriceIndex] - prices[buyingPriceIndex];
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            } else if (prices[i] < prices[buyingPriceIndex]) {
                buyingPriceIndex = i;
                sellingPriceIndex = i;
            }
        }
        return maxProfit;
    }

    /**
     * leetcode 100 percentile solution
     * @param prices
     * @return
     */
    public int maxProfit_lc(int prices[]) {
        int minprice, maxprofit;
        minprice = Integer.MAX_VALUE;
        maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int[] prices = {2,1,2,1,0,1,2};
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices));
    }
}

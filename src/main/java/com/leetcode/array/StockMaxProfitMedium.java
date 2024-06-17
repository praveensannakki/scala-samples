package com.leetcode.array;

/**
 * 122. Best Time to Buy and Sell Stock II
 *
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 *
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 *
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 *
 * Example 3:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 */
public class StockMaxProfitMedium {

    public static void main(String[] args) {
        StockMaxProfitMedium stockMaxProfitMedium = new StockMaxProfitMedium();
        System.out.println("Max profit for [7,1,5,3,6,4] is: " + stockMaxProfitMedium.maxProfitBruteForce(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("Max profit for [7,6,4,3,1] is: " + stockMaxProfitMedium.maxProfitBruteForce(new int[]{7, 6, 4, 3, 1}));
        System.out.println("******** Optimized with one pass *****************");
        System.out.println("Max profit for [7,1,5,3,6,4] is: " + stockMaxProfitMedium.maxProfitSinglePass(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("Max profit for [7,6,4,3,1] is: " + stockMaxProfitMedium.maxProfitSinglePass(new int[]{7, 6, 4, 3, 1}));
    }

    /**
     * Time complexity : O(n^n). Recursive function is called n^n times.
     * Space complexity : O(n). Depth of recursion is nnn.
     * @param prices
     * @return
     */
    public int maxProfitBruteForce(int[] prices) {
        return calculateMaxProfit(prices, 0);
    }

    private int calculateMaxProfit(int[] prices, int n) {
        if (n >= prices.length) return 0;
        int maxProfit = 0;
        for (int i = n; i< prices.length; i++) {
            int runningProfit = 0;
            for(int j = i+1; j< prices.length; j++) {
                int profit = calculateMaxProfit(prices, j + 1) + prices[j] - prices[i];
                if (profit > runningProfit) runningProfit = profit;
            }
            if (runningProfit > maxProfit) maxProfit = runningProfit;
        }
        return maxProfit;
    }

    /**
     * Time complexity : O(n). Single pass.
     * Space complexity: O(1). Constant space needed.
     * @param prices
     * @return
     */
    public int maxProfitSinglePass(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        for (int i = 1; i <prices.length; i++){
            if(prices[i] > prices[i-1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }


}

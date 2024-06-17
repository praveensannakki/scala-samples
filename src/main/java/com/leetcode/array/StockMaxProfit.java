package com.leetcode.array;

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class StockMaxProfit {
    public static void main(String[] args) {
        StockMaxProfit stockMaxProfit = new StockMaxProfit();
        System.out.println("Max profit for [7,1,5,3,6,4] is: " + stockMaxProfit.maxProfitNested(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("Max profit for [7,6,4,3,1] is: " + stockMaxProfit.maxProfitNested(new int[]{7, 6, 4, 3, 1}));
        System.out.println("******** Optimized with one pass *****************");
        System.out.println("Max profit for [7,1,5,3,6,4] is: " + stockMaxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("Max profit for [7,6,4,3,1] is: " + stockMaxProfit.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println("******** With Math function *****************");
        System.out.println("Max profit for [7,1,5,3,6,4] is: " + stockMaxProfit.maxProfitMath(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("Max profit for [7,6,4,3,1] is: " + stockMaxProfit.maxProfitMath(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int currentProfit = prices[i] - minPrice;
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }
        return maxProfit;
    }

    public int maxProfitNested(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public int maxProfitMath(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = prices[0];
        for (int price : prices) {
            int profit = price - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }
}

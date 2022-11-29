package org.example.leetCodeTask;

public class BestTimeToBuyAndSellStock121 {
    public static void main(String[] args) {

    }


    public int maxProfit1(int[] prices) {
        if (prices.length == 0) return 0;

        int minStockPrice = prices[0];
        int bestDeal = 0;


        for (int i = 0; i < prices.length; i++) {
            minStockPrice = Math.min(prices[i], minStockPrice);
            bestDeal = Math.max(prices[i] - minStockPrice, bestDeal);
        }

        return bestDeal;
    }
    public int maxProfit2(int[] prices) {

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int p:prices) {
            min = Math.min(min, p);
            max = Math.max(p-min, max);
        }

        return max;
    }
}

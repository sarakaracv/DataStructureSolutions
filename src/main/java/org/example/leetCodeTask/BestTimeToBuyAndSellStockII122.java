package org.example.leetCodeTask;

public class BestTimeToBuyAndSellStockII122 {
    public static void main(String[] args) {

    }
    public int maxProfit(int []prices){
        int min= Integer.MAX_VALUE;
        int inc=0;
        for (int each:prices){
            if (each==each) {
                min = Math.min(min, each);
                inc = Math.max(inc, each - min);
            }
        }
        return prices[0];
    }
}

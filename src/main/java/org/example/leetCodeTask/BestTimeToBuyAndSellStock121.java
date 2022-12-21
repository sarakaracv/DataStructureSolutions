package org.example.leetCodeTask;

public class BestTimeToBuyAndSellStock121 {
    public static void main(String[] args) {
    int [] nums= {12,15,10,25,32};
    BestTimeToBuyAndSellStock121 dnd= new BestTimeToBuyAndSellStock121();
        System.out.println(dnd.maxProfit3(nums));
    }
    public static int maxProfit(int[] prices) {
        int minimum= Integer.MAX_VALUE;
        int inc=0;
        for (int each:prices){
            minimum=Math.min(minimum,each);
            inc=Math.max(inc,each-minimum);
        }
        return inc;
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

    public static int maxProfit2(int[] prices) {

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int p : prices) {
            min = Math.min(min, p);
            max = Math.max(p - min, max);
        }

        return max;
    }

    public int maxProfit3(int[] prices) {

        return prices.length > 0 ? helper(prices, 0, prices.length - 1)[0] : 0;
    }

    /**
     * index 0 is max profit, index 1 is max price in the range and index 2 is min price in the range.
     */
    private int[] helper(int[] prices, int i, int j) {
        int[] result = {0, prices[i], prices[j]}; // base case
        if (i == j) return result;
        int m = i + (j - i) / 2;
        int[] left = helper(prices, i, m); // left half
        int[] right = helper(prices, m + 1, j); // right half
        result[0] = Math.max(left[0], Math.max(right[0], right[1] - left[2]));
        result[1] = Math.max(left[1], right[1]);
        result[2] = Math.min(left[2], right[2]);
        return result;
    }

    public int maxProfit4(int[] prices) {
        if (prices.length < 1)
            return 0;

        // keep track of the lowest price before the current value
        // Keep track of the max profit of the current index
        int lowest = prices[0];
        int maxp = 0;

        for (int i = 1; i < prices.length; i++) {
            lowest = Math.min(lowest, prices[i]);
            maxp = Math.max(maxp, prices[i] - lowest);
        }
        return maxp;

    }

    public int maxProfit5(int[] prices) {
    /*
    Bottom-up approach
    Profit(selldatelimit, buydatelimit) = max{Profit(selldate-1, buydate), Profit(selldate, buydate+1), p[selldate] - p[buydate]} this is the maximum profit we can get from the time range of buydatelimit to the selldatelimit
    Profit(selldatelimit, buydatelimit) = 0 if selldate = buydate
    Profit(selldatelimit, buydatelimit) doesn't exist if selldatelimit < buydatelimit
    i = selldatelimit
    j = buydatelimit
    i >= j
    */
        int l = prices.length;
        if (l == 0) {
            return 0;
        }
        int[][] profit = new int[l][l];
        for (int c = 0; c <= l - 1; c++) {
            for (int j = 0; j <= l - 1 - c; j++) {
                int i = j + c;
                if (i == j) {
                    profit[i][j] = 0; //buy and sell at the same day, profit is 0
                } else {
                    profit[i][j] = profit[i][j + 1] > profit[i - 1][j] ? profit[i][j + 1] : profit[i - 1][j];
                    profit[i][j] = profit[i][j] > (prices[i] - prices[j]) ? profit[i][j] : prices[i] - prices[j];
                    //profit[i][j] is the largest one among the three ones
                }
            }
        }

        return profit[l - 1][0]; //return the largest profit we can get from the time range of the first day to the last day
    }

    public int maxProfit6(int[] prices) {
        int min = 0;
        int mp = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[min] > prices[i]) min = i;
            else mp = Math.max(mp, prices[i] - prices[min]);
        }

        return mp;
    }

    public int maxProfit7(int[] prices) {
        if (prices.length < 1) return 0;

        int min = prices[0];
        int diff = 0;
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            diff = prices[i] - min;
            if (max < diff) max = diff;
        }

        return max;
    }

    public int maxProfit8(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int max = 0;
        int minPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > minPrice){
                max = Math.max(max,prices[i]-minPrice);
            }
            else {
                minPrice = prices[i];
            }
        }
        return max;
    }

    public int maxProfit9(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j >= 0; j--) {
                profit = Math.max(profit, prices[i]-prices[j]);
            }
        }
        return profit;
    }

    public int maxProfit10(int[] prices) {
        int[] minPrices = new int[prices.length];
        int currentMinPrice = prices.length > 0 ? prices[0] : 0;
        for (int i = 0; i < prices.length; i++) {
            currentMinPrice = Math.min(currentMinPrice, prices[i]);
            minPrices[i] = currentMinPrice;
        }

        int currentMaxPrice = prices.length > 0 ? prices[prices.length - 1] : 0;
        int profit = currentMaxPrice - currentMinPrice;
        for (int i = prices.length - 1; i >= 0 ; i--) {
            currentMaxPrice = Math.max(currentMaxPrice, prices[i]);
            profit = Math.max(profit, currentMaxPrice - minPrices[i]);
        }
        return profit;
    }

    public int maxProfit11(int[] prices) {
        int currentMinPrice = prices.length > 0 ? prices[0] : 0;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            currentMinPrice = Math.min(currentMinPrice, prices[i]);
            profit = Math.max(profit, prices[i] - currentMinPrice);
        }
        return profit;
    }

    public int maxProfit12(int[] prices) {
        int[] mins = new int[prices.length];
        int[] maxes = new int[prices.length];
        int currMin = Integer.MAX_VALUE;
        int currMax = 0;
        for(int i = 0; i < prices.length; i++) {
            currMin = Math.min(currMin, prices[i]);
            mins[i] = currMin;
        }
        for(int i = prices.length-1; i >= 0; i--) {
            currMax = Math.max(currMax, prices[i]);
            maxes[i] = currMax;
        }
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, maxes[i] - mins[i]);
        }
        return maxProfit;
    }
    public int maxProfit13(int[] prices) {
        if(prices.length < 2)
            return 0;
        int maxProf = 0;
        int min = 0, max = 0, prof;

        for(int i = 1; i < prices.length; ++i) {
            if(prices[i] < prices[min]) {
                min = i;
                max = max < min ? min : max;    // max keep up with min when get behind
            }

            if(prices[i] > prices[max])
                max = i;

            prof = prices[max] - prices[min];
            maxProf = prof > maxProf ? prof : maxProf;
        }

        return maxProf;
    }

    public int maxProfit14(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int price : prices) {
            if (price < min) min = price;
            else max = Math.max(max, price - min);
        }

        return max;
    }

    public int maxProfit15(int[] prices) {
        short maxProfit = 0, minCost = Short.MAX_VALUE;

        for(int i = 0; i < prices.length; ++i)
            if(prices[i] < minCost) minCost = (short)prices[i];
            else maxProfit = (short)Math.max(maxProfit, prices[i] - minCost);

        return maxProfit;
    }
}

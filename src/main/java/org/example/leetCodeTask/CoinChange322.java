package org.example.leetCodeTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange322 {

        public int coinChange1(int[] coins, int amount) {
            int[] dp = new int[amount+1];
            Arrays.fill(dp, amount+1);
            dp[0] = 0;
            for(int i=1; i<=amount; i++) {
                for(int j=0; j<coins.length; j++) {
                    if(coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    public int coinChange2(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1 ;i<=amount;i++){
            int val = 100000;
            for(int j : coins){
                if(j<=i){
                    val = Math.min(dp[i-j]+1,val);
                }
            }
            dp[i] = val;
        }
        return dp[amount]>=100000?-1:dp[amount];
    }
    public int coinChange3(int[] coins, int amount) {


        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i <= amount; i++) {
            for(var coin : coins) {
                if(i >= coin) {
                    int r = dp[i-coin];

                    if(r < Integer.MAX_VALUE) {

                        dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
                    }
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    public int coinChange4(int[] coins, int amount) {

        int[] hash = new int[amount + 1];
        for (int i = 1; i < hash.length; i++) {
            hash[i] = -1;
            for (var coin : coins) {
                int diff = i - coin;

                if (diff >= 0 && hash[diff] != -1) {
                    if (hash[i] == -1) hash[i] = 1 + hash[diff];
                    hash[i] = Math.min(hash[i], 1 + hash[diff]);
                }
            }
        }

        return hash[amount];

    }
    public int coinChange5(int[] coins, int amount) {
        if(amount==0) return 0;
        int[][] dp = new int[coins.length][amount+1];
        for(int rows[]:dp)
            Arrays.fill(rows,-1);

        int ans = helper(coins,amount,coins.length-1,dp);

        if(ans>=1e9) return -1;
        else
            return ans;
    }
    int helper(int[] arr,int ans,int ind,int[][] dp)
    {

        if(ind==0) {if(ans%arr[0]==0) return ans/arr[0];
        else return (int)1e9;}


        if(dp[ind][ans]!=-1) return dp[ind][ans];



        int nottaken = 0+helper(arr,ans,ind-1,dp);
        int taken = (int)1e9;
        if(ans>=arr[ind])
            taken = 1+helper(arr,ans-arr[ind],ind,dp);



        return dp[ind][ans] = Math.min(taken,nottaken);
    }
    public int coinChange6(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp, -2);
        return coin(coins, amount, dp);
    }

    public int coin(int[] coins, int amount, int[] dp){
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return -1;
        }
        if(dp[amount]!=-2){
            return dp[amount];
        }
        int ans=Integer.MAX_VALUE;
        for(int i:coins){
            if(coin(coins, amount-i, dp)!=-1){
                ans=Math.min(ans,1+coin(coins, amount-i, dp));
            }
        }
        if(ans==Integer.MAX_VALUE){
            ans=-1;
        }
        dp[amount]=ans;
        return dp[amount];
    }
    public int coinChange7(int[] coins, int amount) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        for(int i = 1;i < amount+1;i++){
            int curmax = -1;
            for(int coin : coins){
                if(i-coin >= 0 && dp.get(i-coin) != -1){
                    if(curmax == -1){
                        curmax = dp.get(i-coin)+1;
                    }else{
                        curmax = Math.min(curmax,dp.get(i-coin)+1);
                    }
                }
            }
            dp.add(curmax);
        }
        return dp.get(amount);
    }

}



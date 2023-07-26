package com.huang.medium.maxProfit;

public class Solution2 {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++){
                if(prices[j] < min){
                    min = prices[j];
                }
                dp[j] = Math.max(dp[j - 1], dp[j - i] + prices[j] - min);
//                if(dp[j - i] + prices[j] - min > )
            }
        }
        return dp[prices.length - 1];

    }
}

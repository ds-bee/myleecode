package com.huang.easy.maxProfit.Solution;

public class Solution {
    public static void main(String[] args) {
//        int[] arr = {7,1,5,3,6,4};
        int[] arr = {1,2};
//        int[] arr = {7,6,4,3,1};
        System.out.println(maxProfit(arr));

    }
//    public static int maxProfit(int[] prices) {
//
//        int[] dp = new int[prices.length];
//        dp[0] = 0;
//        int record = 0;
//        int min = prices[0];
//        int max = prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            if(max < prices[i]){
//                max = prices[i];
//            }
//            if(min > prices[i]){
//                min = prices[i];
//                max = 0;
//            }
//            if((max - min) > record){
//                record = max - min;
//            }
//        }
//        return record;
//    }

    public static int maxProfit(int[] prices) {

        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < min){
                min = prices[i];
            }
            dp[i] = Math.max(dp[i-1], prices[i] - min);
        }
        return dp[prices.length - 1];
    }

}

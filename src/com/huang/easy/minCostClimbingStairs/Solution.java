package com.huang.easy.minCostClimbingStairs;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {10,15,20};
        System.out.println(minCostClimbingStairs(arr));

    }
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        int record = 0;
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min((dp[i-1] + cost[i]),(dp[i-2]+cost[i]));

//            record = record + Math.min(cost[i], cost[i+ 1]);
        }
        return Math.min(dp[dp.length- 1],dp[dp.length -2]);
    }
}

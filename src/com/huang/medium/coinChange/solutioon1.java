package com.huang.medium.coinChange;

import java.util.Arrays;

public class solutioon1 {
    public static void main(String[] args) {
//        int[] arr = {1,2,5};
        int[] arr = {2};
        int amount = 27;
        System.out.println(coinChange(arr, amount));

    }
    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {

            for (int j = 1; j <= amount; j++) {
                if(j - coins[i] >= 0){
                    //这里加1真是这种题目的精髓
                dp[j] = Math.min(dp[j - coins[i]] + 1,dp[j]);
             }
            }
        }
        if(dp[amount] < 0 || dp[amount] == Integer.MAX_VALUE - 1){
            return -1;
        }
        return dp[amount];

    }

}

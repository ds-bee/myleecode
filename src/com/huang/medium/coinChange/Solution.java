package com.huang.medium.coinChange;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        int n = 11;
        System.out.println(coinChange(arr, n));

    }
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return amount;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = coins.length - 1; i > 0; i--) {

            for(int j = 0; j <= coins[i]; j++){
                if(coins[i] - j> 0)dp[j] += dp[coins[i] - j];
                if(dp[j] == amount){
                    return j;
                }
            }
        }
        return -1;
    }

}

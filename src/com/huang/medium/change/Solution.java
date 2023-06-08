package com.huang.medium.change;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        int n = 5;
        System.out.println(change(n, arr));

    }
    public static int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {

            for (int j = coins[i]; j < amount + 1; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount ];
    }
}

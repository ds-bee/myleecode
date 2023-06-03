package com.huang.medium.numTrees;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(numTrees(n));

    }
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
//        dp[1] = 1;
//        dp[2] = 2;
//        dp[3] = 5;
        for (int i = 2; i < n; i++) {

            for (int i1 = 1; i1 < i; i1++) {
                dp[i] = dp[i ] + dp[i1 -1]*dp[i - i1 ];
                System.out.println("dpi" + dp[i] + " i" + i1);
            }
        }
        dp[n] = dp[n];
        return dp[n];
    }

}

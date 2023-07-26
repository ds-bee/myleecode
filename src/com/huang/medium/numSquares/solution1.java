package com.huang.medium.numSquares;

public class solution1 {
    public static void main(String[] args) {
        int n = 12;
//        int n = 4;
        System.out.println(numSquares(n));

    }
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int record = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for(int j = 0;j*j <= i; j++){
                if(j ==0){
                    record = i*i;
                }
                if(j>0 && dp[i - j*j] < record){
                    record = Math.min(dp[i - j*j], record);
//                    record = dp[j*j];
                }
            }
            dp[i] = 1 + record;
        }
        return dp[n] ;

    }

}

package com.huang.easy.climbStairs;

public class Soultion1 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }
    static int record = 0;
    static int sum = 0;

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        int m = 2;
        dp[0] = 1;

        for (int i = 1; i <= n; i++) { // 遍历背包
            for (int j = 1; j <= m; j++) { //遍历物品
                if (i >= j) dp[i] += dp[i - j];
            }
        }

        return dp[n];


    }
//    public static void find(int n, int start, int sum){
//        if(sum == n){
////            sum = sum;
//            record++;
//            return;
//        }
//        if(sum > n){
//            return;
//        }
//        for (int i = start; i < n; i++) {
//            sum = sum + 1;
//            find(n, start+1,sum );
//            sum = sum - 1;
//
//            sum = sum + 2;
//            find(n, start+1,sum );
//            sum = sum - 2;
//        }
//    }
}

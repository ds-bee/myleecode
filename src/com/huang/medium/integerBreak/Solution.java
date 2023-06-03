package com.huang.medium.integerBreak;

public class Solution {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(integerBreak(n));
    }
    public static int integerBreak(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
//        int record = (int) Math.sqrt((double) n);
        int[] dp = new int[n];
        dp[0] = 3;
        dp[1] = 4;
        int a = n/3;
        int b = n%3;
        if(b == 1){
            a--;
            b = 4;
        }
        if(b == 0){
            b = 1;
        }
        return (int)(Math.pow(3,a) * b);

    }

}

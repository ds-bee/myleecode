package com.huang.easy.climbStairs;

public class Soultion {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(climbStairs(n));
    }
    static int record = 0;
    static int sum = 0;

    public static int climbStairs(int n) {
        int start = 0;
        find(n ,start, sum);
        return record;
    }
    public static void find(int n, int start, int sum){
        if(sum == n){
//            sum = sum;
            record++;
            return;
        }
        if(sum > n){
            return;
        }
        for (int i = start; i < n; i++) {
            sum = sum + 1;
            find(n, start+1,sum );
            sum = sum - 1;

            sum = sum + 2;
            find(n, start+1,sum );
            sum = sum - 2;
        }
    }
}

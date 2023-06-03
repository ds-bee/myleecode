package com.huang.easy.climbStairs;

public class Soultion {
    public static void main(String[] args) {
        int n = 30;
        System.out.println(climbStairs(n));
    }
    static int record = 0;
    static int sum = 0;

    public static int climbStairs(int n) {
        if(n<3){
            return n;
        }

        int r = 1,q = 2,sum = 0;
        for (int i = 2; i < n; i++) {
            sum = r + q;
            r = q;
            q = sum;
        }
        return sum;
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

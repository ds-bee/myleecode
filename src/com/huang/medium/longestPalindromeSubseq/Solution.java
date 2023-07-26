package com.huang.medium.longestPalindromeSubseq;

public class Solution {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq1(s));

    }

    public static int longestPalindromeSubseq(String s) {

        int len1 = s.length();
        int record = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = i + 1; j <= len1; j++) {
                if (find(s.substring(i,j))) {
                    if(j - i > record){
                        record = j - i;
                    }
                }

            }
        }
        return record;
    }

    public static boolean find(String s){
//        if(s.length() == 1){
//            return true;
//        }
        int j = s.length() ;
        for (int i = 0; i < s.length()/2; i++) {
            j--;
            if(s.charAt(i) != s.charAt(j )){
                return false;
            }
        }
        return true;
    }

    public static int longestPalindromeSubseq1(String s) {

        int len1 = s.length();
        int[][] dp = new int[len1][len1];
        int record = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = i ; j < len1; j++) {
                if( j == i){
                    dp[i][j] = 1;
                }else {
                    if(s.substring(j, j + 1).equals(s.substring(i, i + 1))){
                        dp[i][j] = dp[i][j - 1] + 1;
                    }else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
                if(dp[i][j] > record){
                    record = dp[i][j];
                }
            }
        }
        return record;
    }

    public int longestPalindromeSubseq2(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) { // 从后往前遍历 保证情况不漏
            dp[i][i] = 1; // 初始化
            for (int j = i + 1; j < len; j++) {
                //两个数值相等就会对左下角的值，实际是有一种从中心开始的思想
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
                }
            }
        }
        return dp[0][len - 1];
    }


}

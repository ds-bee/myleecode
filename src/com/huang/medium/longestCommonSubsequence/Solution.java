package com.huang.medium.longestCommonSubsequence;

public class Solution {
    public static void main(String[] args) {
//        String s1 = "bl";
//        String s2 = "yby";
//        String s1 = "abcde";
//        String s2 = "ace";
//        String s1 = "ezupkr";"bsbininm"
//"jmjkbkjkv"
//        String s2 = "ubmrapg";

        String s1 = "aaaaa";
        String s2 = "aaaaaaa";
        System.out.println(longestCommonSubsequence(s1, s2));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int max = 0;
        int[][] dp = new int[chars2.length ][chars1.length ];

        for (int i = 0; i < chars1.length; i++) {
            if(chars2[0] == chars1[i]){
                dp[0][i]++;
                max = 1;
            }
        }
//        if(dp[0][0] == 1){
//            for (int i = 0; i < dp.length; i++) {
//                dp[0][i] = 1;
//            }
//        }

        for (int i = 1; i < chars2.length; i++) {
            boolean flag = true;
            for (int j = 0; j < chars1.length; j++) {
                if(j>=1) {
                    if (chars2[i] == chars1[j] && flag) {
                        dp[i][j] =  dp[i - 1][j - 1] + 1;
//                        flag = false;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
                if(j==0){
                    if (chars2[i] == chars1[j]) {
                        dp[i][j] = dp[i - 1][j] + 1;
                        flag = false;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
//                else {
////                    dp[i][j]= dp[i-1][j-1];
//                    dp[i][j]++;
//                }
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        return max;

    }
}

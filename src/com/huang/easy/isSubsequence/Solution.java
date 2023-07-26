package com.huang.easy.isSubsequence;

import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ahbgdc";
        System.out.println(isSubsequence1(s1, s2));

    }

    /**
     * 使用dp矩阵
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        if(Objects.equals(s, "") ){
            return true;
        }
        if(Objects.equals(s, "") && !Objects.equals(t, "")){
            return false;
        }

        char[]  char1 = s.toCharArray();
        char[]  char2 = t.toCharArray();
        int[][] dp = new int[char1.length + 1][char2.length + 1];
//        dp[0] = 1;
        for (int i = 1; i <= char1.length; i++) {
            for (int j = 1; j <= char2.length; j++) {
                if(char1[i -1] == char2[j -1]){
                    dp[i][j] = dp[i-1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
        return dp[char1.length][char2.length]==char1.length || dp[char1.length][char2.length]==char2.length;
    }

    /**
     * 这里是有两个因素影响dp数组，所以，不能使用一维的数组来做这个
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence1(String s, String t) {
        if(Objects.equals(s, "") ){
            return true;
        }
        if(Objects.equals(s, "") && !Objects.equals(t, "")){
            return false;
        }
        char[]  char1 = s.toCharArray();
        char[]  char2 = t.toCharArray();
        int[] dp = new int[char2.length];
//        dp[0] = 1;
        if(char1[0] == char2[0]){
            dp[0] = 1;
        }

        for (int i = 1; i < char2.length; i++) {
            for (int j = 1; j < char1.length; j++) {
                if(char2[i -1] == char1[j -1]){
                    dp[i] = dp[i-1] + 1;
                }else {
                    dp[i] = dp[i-1];
                }

            }
        }
        return dp[char2.length -1] == char2.length -1;
//        return dp[char1.length][char2.length]==char1.length || dp[char1.length][char2.length]==char2.length;
    }

}

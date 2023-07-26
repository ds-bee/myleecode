package com.huang.medium.longestPalindrome;

public class Solution {
    public static void main(String[] args) {
//        String s = "babad";
//        String s = "cbbd";
        String s = "abc435cba";
//        String s = "aa";
        System.out.println(longestPalindrome1(s));

    }
    public static String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        int[][] dp = new int[s.length() ][s.length()];
        int len = s.length();
        int recordi = 0;
        int recordj = 0;
        int max = 0;
        for (int i = len-1; i >= 0; i--) {

            for (int j = i ; j < len; j++) {
                if(j == i){
                    dp[i][j] = 1;
                }
//                if(i < len - 1 ){
                if(find(s.substring(i,j))){
                    if(i == j){
                        dp[i][j] = dp[i + 1][j ] + 1;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                }
//                }
                if(dp[i][j] > max){
                    recordi = i;
                    recordj = j ;
                }
            }
        }
        return s.substring(recordi,recordj);
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
    public static String longestPalindrome1(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                /**********修改的地方*******************/
                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                    /*************************************/
                }
            }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }



}

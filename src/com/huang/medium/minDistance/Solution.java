package com.huang.medium.minDistance;

public class Solution {
    public static void main(String[] args) {
//        String arr1 = "sea";
//        String arr2 = "eat";
//        String arr1 = "park";
//        String arr2 = "spake";
//        String arr1 = "leetcode";
//        String arr2 = "etco";
        String arr1 = "plasma";
        String arr2 = "altruism";
        System.out.println(minDistance(arr1, arr2));

    }
    public static int minDistance(String word1, String word2) {
        int lemword1 = word1.length();
        int lemword2 = word2.length();
        int[][] dp = new int[lemword1 + 1][lemword2 + 1];
        int max = 0;
        for (int i = 1; i <= lemword1; i++) {

            for (int j = 1; j <= lemword2; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + 1;
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + 1;
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] =Math.max(dp[i-1][j], Math.max(dp[i][j-1],dp[i-1][j-1]));
                }
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }

        }
        return lemword1-max + lemword2-max;
//        return lemword1-dp[word1.length()][word2.length()] + lemword2-dp[word1.length()][word2.length()];

    }
}

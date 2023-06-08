package com.huang.medium.findMaxForm;

public class Solution {
    public static void main(String[] args) {
        String[] strings = {"10","0001","111001","1","0"};
        int m = 5, n = 3;
        System.out.println(findMaxForm(strings, m, n));


    }
    public static int findMaxForm(String[] strs, int m, int n) {
        int[] dp = new int[strs.length + 1];
        int[][] value = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            for (int i1 = 0; i1 < chars.length; i1++) {
                if(chars[i1] == '0'){
                    value[i][0]++;
                }
                if(chars[i1] == '1'){
                    value[i][1]++;
                }
            }
        }
        dp[0] = 1;
        for (int i = 0; i < strs.length; i++) {
            int b = m;int k = n;
            for(int j = strs.length ; b >value[i][0] && k>value[i][1]; j--){

                b = b - value[i][0];
                k = k - value[i][1];
                dp[j] =  Math.max(dp[j-1],dp[j - i] + 1) ;
//                dp[j] =  dp[j - 1] + 1 ;
            }

        }
        return dp[strs.length ];
    }
}

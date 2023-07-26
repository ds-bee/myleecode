package com.huang.medium.findLength;

public class Solution {
    public static void main(String[] args) {
//        int[] nums1 = {0,0,0,0,1};
//        int[] nums2 = {1,0,0,0,0};
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4};
        System.out.println(findLength(nums1, nums2));
    }
    public static int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums2.length][nums1.length];
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            if(nums2[0] == nums1[i]){
                dp[0][i]++ ;
                max = 1;
            }
        }
        for (int i = 1; i < nums2.length; i++) {
            if(nums1[0] == nums2[i]){
                dp[i][0]++ ;
                max = 1;
            }
        }
//        int max = 0;
        for (int i = 1; i < nums2.length; i++) {
            for (int j = 1; j < nums1.length; j++) {
                if(nums2[i] == nums1[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
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

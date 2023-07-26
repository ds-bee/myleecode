package com.huang.medium.canPartition;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int[] nums = {1,2,2,3};
//        int[] nums = {1,2,5};
//        int[] nums = {14,9,8,4,3,2};
//        int[] nums = {1,1};
        int[] nums = {9,1,2,4,10};
//        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1){
            return false;
        }
        int target = sum/2;
        int[] dp = new int[target+1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = target; j >= nums[i]; j--) {
//                if(i < j){
//                    dp[j] = Math.max(dp[j], nums[j]);
//                }else {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
//                }
            }
        }
        return dp[target] == target;
    }

//    public static boolean canPartition(int[] nums) {
//        int[][] dp = new int[nums.length][nums.length];
//        int sum = Arrays.stream(nums).sum();
////        Arrays.sort(nums);
//        if(sum % 2 == 1){
//            return false;
//        }
//        sum = sum/2;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//
//                if (i == j ) {
//                    dp[i][j] = nums[i];
//                    if (dp[i][j] == sum) {
//                        return true;
//                    }
//                    continue;
//                }
//                if (j == 0) dp[i][j] = nums[i] + nums[j];
//                if (j > 0) {
//                    if (i == j) {
//                        dp[i][j] = dp[i][j - 1];
//                    } else {
//                        dp[i][j] = dp[i][j - 1] + nums[j];
//                    }
//                }
//                if (dp[i][j] > sum) {
//                    dp[i][j] = dp[i][j] - nums[j];
//                    continue;
//                }
//                if (dp[i][j] == sum) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}

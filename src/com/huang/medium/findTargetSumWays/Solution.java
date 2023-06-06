package com.huang.medium.findTargetSumWays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }
    public static int findTargetSumWays(int[] nums, int target) {

        int[] dp = new int[target + 1];
        int record = 0;
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = target; j >= nums[i]; j--) {
                if(dp[j] > target){
                    dp[j] = dp[j - 1] - nums[i] ;
                }else {
                    dp[j] = Math.max(dp[j - 1], dp[j - nums[i]] + nums[j] );
                }
                if(dp[j] == target){
                    record++;
                }
            }
        }
        return record;
    }

}

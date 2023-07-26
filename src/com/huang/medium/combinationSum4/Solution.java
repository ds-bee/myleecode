package com.huang.medium.combinationSum4;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int target = 4;
        System.out.println(combinationSum4(arr, target));

    }

    public static int combinationSum4(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if(sum < target){
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= target; j ++){
                dp[j] = Math.max(dp[j-1], dp[j - nums[i] ] + 1);
            }
        }
        return dp[target];
    }

}

package com.huang.medium.rob;

import java.util.Arrays;

public class Solutions {
    public static void main(String[] args) {
        int[] arr = {2,1,1,2};
        System.out.println(rob(arr));

    }
    public static int rob(int[] nums) {
        if( nums.length == 1 ){
            return nums[0];
        }
        if( nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length ];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            for (int j = i; j <= i; j++){
                int record = 0;
                for (int i1 = 0; i1 < i-1; i1++) {
                    if(record < dp[i1]){
                        record = dp[i1];
                    }
                }
                dp[j] = Math.max(dp[j - 1], record + nums[i]);
            }
        }
        return dp[nums.length - 1];
    }

}

package com.huang.medium.findTargetSumWays;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
//        int[] nums = {1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if(sum < target || (sum + target)%2 == 1){
            return 0;
        }

        int[] dp = new int[(target + sum)/2 + 1];
        int record = 0;
        dp[0] = 1;
        /**
         * 已经有一个1（nums[i]） 的话，有 dp[4]种方法 凑成 容量为5的背包。
         * 已经有一个2（nums[i]） 的话，有 dp[3]种方法 凑成 容量为5的背包。
         * 这里为什么是2和dp[3]，因为实际上这里是容量为三有多少种方法能够凑成dp[5]。
         * dp[0]是装满背包容量为0的方法只有一种，然后下面有个累加。这里就不是更新数值了，因为dp数组的含义改变了。
         * dp[j] += dp[j - nums[i]];
         */
        for (int i = 0; i < nums.length; i++) {
            for (int j = (target + sum)/2; j >= nums[i]; j--) {
//                if(dp[j] > target){
//                    dp[j] = dp[j - 1] - nums[i] ;
//                }else {
//                    dp[j] = Math.max(dp[j - 1], dp[j - nums[i]] + nums[j] );
                dp[j] += dp[j - nums[i]];
//                }
//                if(dp[j] == target){
//                    record++;
//                }
            }
        }
        return dp[(target + sum)/2];
    }

}

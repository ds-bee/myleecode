package com.huang.medium.maxProduct;

public class solution {
    public static void main(String[] args) {
//        int[] nums = {-2};
//        int[] nums = {-2, 3, -4};
        int[] nums = {-5,2,4,1,-2,2,-6,3,-1,-1,-1,-2,-3,5,1,-3,-4,2,-4,6,-1,5,-6,1,-1,-1,1,1,-1,1,1,-1,-1,1,-1,-1,1,1,-1,1,1,1,-1,-1,-1,-1,1};
        System.out.println(maxProduct(nums));

    }
    public static int maxProduct(int[] nums) {
        int[] dp = new int[nums.length];
        int record = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            if(dp[i] > record){
                record = dp[i];
            }
            for (int j = i+1; j < nums.length; j++) {
                dp[j] = dp[j-1]*nums[j];
                if(dp[j] > record){
                    record = dp[j];
                }
            }
        }
        return record;
    }

    /**
     * 虽然使用动态规划勉强做出来了这道题，但是这道题还有维护两个动态数组的方法，分别是最大值和最小值，
     * 我最开始想的是使用dp[2]这种数组来分别存最大值和最小值，但是这种方法不能够获取各个情况下符合情况的值。
     * 这里相当于是分了情况，当前值是正值还是负值
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }



}

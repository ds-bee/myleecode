package com.huang.medium.maxSubArray;

public class Solution {
    /**
     * 简介的写法 可以多学习一下
     *         for (int x : nums) {
     *             pre = Math.max(pre + x, x);
     *             maxAns = Math.max(maxAns, pre);
     *         }
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(arr);
        System.out.println(i);

    }
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int record = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if(nums[i] > sum){
                sum = nums[i];
            }
            if(sum > record){
                record = sum;
            }

        }
        return record;
    }
}

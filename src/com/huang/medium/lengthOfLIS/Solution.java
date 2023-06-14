package com.huang.medium.lengthOfLIS;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
//        int[] arr = {7,7,7,7,7,7,7};
//        int[] arr = {4,10,4,3,8,9};
//        int[] arr = {0,1,0,3,2,3};
        System.out.println(lengthOfLIS(arr));
    }
    public static int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        int recordi = nums.length - 1;
        int record = 0;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1] && nums[i] > record){
                recordi = i - 1;
                record = nums[i];
            }
            else {
                recordi = recordi ;
            }
            dp[i] = Math.max(dp[i-1], dp[ recordi] + 1);

        }
        return dp[nums.length-1];
    }


}

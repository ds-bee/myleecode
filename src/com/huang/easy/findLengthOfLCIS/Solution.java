package com.huang.easy.findLengthOfLCIS;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,3,5,4,2,3,4,5};
//        int[] arr = {1,3,5,4,7};
//        int[] arr = {2,2,2,2,2};
        System.out.println(findLengthOfLCIS1(arr));

    }
//    public static int findLengthOfLCIS(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        int record = 1;
//        for (int i = 1; i < nums.length; i++) {
////            for (int j = 1; j < i; j++){
////                if(nums[j] > nums[j-1]){
////                    dp[j] = Math.max(dp[j-1], dp[i - j] + 1);
////                }
////            }
//            if(nums[i] < nums[i-1]){
//                record = i;
//            }
//            if(nums[i] > nums[i-1]){
//                if(i - record + 1 > dp[i-1]){
//                    dp[i] = Math.max(dp[i-1], dp[i - record] + 1);
//                }else {
//                    dp[i] = dp[i -1];
//                }
//            }
//            dp[i] = Math.max(dp[i], dp[i-1]);
//        }
//        return dp[nums.length - 1];
//    }
    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int record = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]){
                record++;
            }
            if(nums[i] < nums[i-1]){
                record = 1;
            }
            if(record > max){
                max = record;
            }
        }
        return max;
    }

    /**
     * 这里的问题是找到一个最大的dp后，能直接提出来表示最大值
     * dp的初始化也是关键
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS1(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            res = res > dp[i + 1] ? res : dp[i + 1];
        }
        return res;
    }

}

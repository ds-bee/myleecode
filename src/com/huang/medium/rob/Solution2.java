package com.huang.medium.rob;

public class Solution2 {
    public static void main(String[] args) {
//        int[] arr = {2,1,1,2};
//        int[] arr = {2,3,2};
        int[] arr = {1,2,1,1};
//        int[] arr = {1,2,3,1};
//        int[] arr = {1,7,9,2};
        System.out.println(rob(arr));

    }
    public static int rob(int[] nums) {
        if( nums.length == 1 ){
            return nums[0];
        }
        if( nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        if( nums.length == 3){
            return Math.max(nums[2], (Math.max(nums[0], nums[1])));
        }
        int[] dp = new int[nums.length - 1];
        int[] dp2 = new int[nums.length -1 ];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[2], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i-2] + nums[i]);
        }
        int i = 2;
        do{
            dp2[i ] = Math.max(dp2[i - 1], dp2[i-2] + nums[i + 1]);
            i++;
        }while ( i < nums.length - 1);
        return Math.max(dp[nums.length - 2],dp2[nums.length - 2]);
    }

    /**
     * 代码写得太不简洁了
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        if (len == 1)
            return nums[0];
        return Math.max(robAction(nums, 0, len - 1), robAction(nums, 1, len));
    }

    int robAction(int[] nums, int start, int end) {
        int x = 0, y = 0, z = 0;
        for (int i = start; i < end; i++) {
            y = z;
            z = Math.max(y, x + nums[i]);
            x = y;
        }
        return z;
    }
}

package com.huang.medium.canJump;

public class Solution {
    public static void main(String[] args) {
//        int[] arr = {2,3,1,1,4};
//        int[] arr = {0,2,3};
        int[] arr = {0};
//        int[] arr = {3,0,8,2,0,0,1};
//        int[] arr = {3,2,1,0,4};
        System.out.println(canJump(arr));

    }
    public static boolean canJump(int[] nums) {
        boolean flag = false;
        int record = 0;
        if (nums.length == 0){
            return flag;
        }
        for (int i = 0; i < nums.length ; i++) {
            if(record <  i){
                break;
            }
            if(nums[i] + i < nums.length -1){
                if(record < nums[i] + i){
                    record = nums[i] + i;
                }
                continue;
            }else {
                flag = true;
            }

        }
        return flag;
    }

}

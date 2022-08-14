package com.huang.easy.canJump;

import java.util.ArrayList;

public class Solution1 {
    public static void main(String[] args) {
//        int[] arr = {2,3,1,1,4};
//        int[] arr = {1,2};
//        int[] arr = {1,1,1,0};
        int[] arr = {0,2,3};
        System.out.println(canJump(arr));
    }

    public static boolean canJump(int[] nums) {
        boolean flag = true;
        if(nums == null || nums.length == 1){
            return true;
        }

        int[] ints = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + nums[i];
            ints[i] = j;
        }
        for (int i = 0; i < ints.length; i++) {
            for (int i1 = 0; i1 < i; i1++) {
                if(ints[i] >= nums.length - 1 ){
                    if(ints[i1] < i){
                        flag = false;
                    }
                }
                return flag;
            }
        }
        return false;
    }

}

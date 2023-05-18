package com.huang.easy.moveZeroes;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[]  nums = {0, 1, 0, 3, 12};
//        int[]  nums = {0,0,1};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public static void moveZeroes(int[] nums) {
        int first= 0  , tem = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                tem = nums[i];
                nums[i] = nums[first];
                nums[first] = tem;
                first++;
            }
        }

    }
}

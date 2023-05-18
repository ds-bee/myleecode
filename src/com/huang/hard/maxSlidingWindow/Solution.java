package com.huang.hard.maxSlidingWindow;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ints = new int[nums.length - k + 1];



        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            if(nums[i] == max || nums[k + i - 1] > max ){
                for (int i1 = i; i1 < k + i; i1++) {
                    if(nums[i1] > max){
                        max = nums[i1];
                    }
                }
            }
            ints[i] = max;
        }
        return ints;
    }
}

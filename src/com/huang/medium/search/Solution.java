package com.huang.medium.search;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(arr, target));

    }
    public static int search(int[] nums, int target) {
        int len = nums.length - 1;
        int record = -1;
        for (int i = 0; i < nums.length; i++) {
            if(i>len){
                break;
            }
            if(nums[i] < target ){
                continue;
            }
            if(nums[len] > target){
                len--;
                continue;
            }
            if(nums[i] == target){
                record = i;
                break;
            }
            if(nums[len] == target){
                record = len;
                break;
            }

        }
        return record;
    }
}

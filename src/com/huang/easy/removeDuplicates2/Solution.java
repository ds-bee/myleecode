package com.huang.easy.removeDuplicates2;

public class Solution {
    public static void main(String[] args) {
        int[] ints = {1,1,2};
        int i = removeDuplicates(ints);
        System.out.println(i);
    }
    public static int removeDuplicates(int[] nums) {
        int first = 1, record = 0;
        while (first < nums.length){
            if(nums[first] > nums[record]){
                record++;
                nums[record] = nums[first];
                first++;
            }
            if(first < nums.length) {
                if (nums[first] == nums[record]) {
                    first++;
                }
            }
        }
        return record;
    }
}

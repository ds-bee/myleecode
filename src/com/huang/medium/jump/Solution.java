package com.huang.medium.jump;

public class Solution {
    public static void main(String[] args) {
        int[] arr ={3,2,1,0,4};
        System.out.println(jump(arr));

    }


    public static int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
//    public static void find(int[] nums, int sum, int start, int record){
//        if((nums[start] + start) >= nums.length - 1 ){
//            sum++;
//            if(sum < record){
//                record = sum;
//            }
//            return;
////            return record;
//        }
//        for (int i = start; i < nums.length - 1; i++) {
//
//            sum++;
//            find(nums,sum,start+1,record);
//            sum--;
//        }
////        return record;
//    }

}

package com.huang.medium.nextPermutation;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int[] arr = {3,2,1};
        int[] arr = {1,2,3};
//        int[] arr = {1,3,2};
        nextPermutation(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    /**
     * 思路就是先给整体排序，将321这种单独排，但是错误了
     * @param nums
     */
//    public static void nextPermutation(int[] nums) {
//        if(nums.length == 0 || nums.length == 1){
//            return;
//        }
//        boolean flag = false;
////        int record = nums.length - 1;
//        for (int i = nums.length - 1; i > 0; i--) {
////            if(nums[i] < nums[record]){
////                int tem= nums[i];
////                nums[i ] = nums[record];
////                nums[record] = tem;
////                return;
////            }else {
//////                record = nums[i]>nums[record]?record:i;
////                int tem= nums[i];
////                nums[i ] = nums[record];
////                nums[record] = tem;
////                record--;
////            }
//            if(nums[i - 1] < nums[i]){
//                int tem= nums[i];
//                nums[i ] = nums[i - 1];
//                nums[i - 1] = tem;
//                return;
//            }else {
////                record = nums[i]>nums[record]?record:i;
//                int tem= nums[i];
//                nums[i ] = nums[i - 1];
//                nums[i - 1] = tem;
////                record--;
//            }
//
//        }
////        int j = nums.length - 1;
////        for (int i = 0; i < nums.length/2; i++) {
////            int tem = nums[i];
////            nums[i] = nums[j];
////            nums[j] = tem;
////            j--;
////        }
//
//
//    }

//    public static void nextPermutation(int[] nums) {
//        if(nums.length == 0 || nums.length == 1){
//            return;
//        }
//        int tem = nums[0];
//        int min = Integer.MAX_VALUE;
//        int record = 0;
//        boolean flag = false;
//        boolean flag2 = false;
//        for (int i = 1; i < nums.length; i++) {
//            if(nums[i] < nums[i - 1]){
//                flag2 = true;
//            }
//            if(nums[i] > tem && nums[i] < min){
//                record = i;
//                min = nums[i];
//                flag = true;
//            }
//        }
//        if(flag2 == false){
//            int tem3 = nums[nums.length - 1];
//            nums[nums.length - 1] = nums[nums.length - 2];
//            nums[nums.length - 2] = tem3;
//            return;
//        }
//
//        int tem2= nums[record];
//        nums[record ] = nums[0];
//        nums[0] = tem2;
////        Arrays.sort(nums[]);
//        if(flag == true) {
//            for (int i = 1; i < nums.length; i++) {
//                for (int i1 = i + 1; i1 < nums.length; i1++) {
//                    if (nums[i] > nums[i1]) {
//                        int tem3 = nums[i];
//                        nums[i] = nums[i1];
//                        nums[i1] = tem3;
////                    return;
//                    }
//                }
//            }
//        }else {
//            for (int i = 0; i < nums.length; i++) {
//                for (int i1 = i + 1; i1 < nums.length; i1++) {
//                    if (nums[i] > nums[i1]) {
//                        int tem3 = nums[i];
//                        nums[i] = nums[i1];
//                        nums[i1] = tem3;
////                    return;
//                    }
//                }
//            }
//        }
//    }

    public static void nextPermutation(int[] nums) {
        // 将i初始化为从倒数第二个元素开始的下标，找到第一个非逆序的数字对
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 如果找到了非逆序的数字对，则将该数字对中较小的数字与后面比它大的最小数字交换位置
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        // 将数字对后面的数字按照升序排列
        reverse(nums, i + 1);
    }

    // 交换nums数组中下标为i和j的元素的位置
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 将nums数组中下标从start开始的元素按照升序排列
    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}

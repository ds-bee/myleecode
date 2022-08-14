//package com.huang.easy.findKthLargest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution {
//    public int findKthLargest(int[] nums, int k) {
//
//    }
//
//    public int[] quickSort(int index,int length ,int[] nums){
//
//        if (nums == null){
//            return nums;
//        }
//        int zhongjian = (index + length)/2 ,count = 0;
//        int[] ints = new int[nums.length];
//        int compare = nums[zhongjian];
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            if(nums[i] <= compare){
//                ints[i] = nums[i];
//            }else {
//                ints[zhongjian + count] = nums[i];
//                count++;
//            }
//        }
//        int[] ints1 = ints;
//        int[] ints2 = new int[nums.length - count];
//
//
//
//    }
//}
////        for (int i = 0; i < nums.length - 1; i++) {
////        if(nums[i] <= compare){
////        integers.add(nums[i]);
////        }else {
////        integers1.add(nums[i]);
////        count++;
////        }
////        }
////
////        Integer[] array = (Integer[])integers.toArray();
////        Integer[] array1 = (Integer[])integers1.toArray();
////        quickSort(0,array.length,array);
////        quickSort(0,array.length,array1);

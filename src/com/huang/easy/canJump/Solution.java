//package com.huang.easy.canJump;
//
//public class Solution {
//    public boolean canJump(int[] nums) {
//        boolean flage = false;
//        if (nums.length == 1) {
//            return true;
//        }
//        int a = nums[0];
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int num : nums) {
//            list.add(num);
//        }
//        for (int i = 1; i <= a; i++) {
//            List<Integer> integers = list.subList(i, nums.length);
//            int[] ints = new int[integers.size()];
//            for (int i1 = 0; i1 < integers.size(); i1++) {
//                ints[i1] = integers.get(i1);
//            }
//            if (canJump(ints)) {
//                flage = true;
//                break;
//            }
//        }
//        return flage;
//    }
//}

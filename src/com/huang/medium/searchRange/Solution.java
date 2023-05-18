package com.huang.medium.searchRange;

public class Solution {
    public static void main(String[] args) {
//        int tem = 1/2;
//        System.out.println(tem);
        int[] ints = {5,7,7,8,8,10};
//        int[] ints = {8};
//        int[] ints = {6,6};
        int target = 8;
//        int target = 6;
        int[] ints1 = searchRange(ints, target);
        for (int anInt : ints1) {
            System.out.println(anInt);
        }
    }


    public static int[] searchRange(int[] nums, int target) {
        int first= 0, second = nums.length -1;
        int[] search = search(first, second, nums, target);
        return search;
    }

    public static int[] search(int first, int second, int[] nums, int target){
        int[] ints = new int[]{-1, -1};
        if((nums.length == 1 && nums[0] != target) || nums.length == 0){
            return new int[]{-1,-1};

        }
        if(second == first + 1 ){
            if(nums[first] == target){
                ints[0] = first;
                ints[1] = second;
            }
            if(nums[first] == target && nums[second] != target){
                ints[0] = first;
                ints[1] = first;
            }
            if(nums[first] != target && nums[second] == target){
                ints[0] = second;
                ints[1] = second;
            }
            return ints;
        }

        int record=  (first + second) / 2;
        if(nums[record] > target){
            ints = search(first ,record ,nums ,target);
        }else if(nums[record] < target){
            ints = search(record ,second ,nums ,target);
        }else {
            int i =1;
            ints[0] = record;
            ints[1] = record;
            while (true){
                if(record + i <= nums.length -1){
                    if(nums[record + i] == target){
                        ints[1] = record + i;
                        i++;
                    }else {
                        break;
                    }
                }else {
                    break;
                }

            }
            int b = 1;
            while (true) {
                if (record - b >= 0) {
                    if (nums[record - b] == target) {
                        ints[0] = record - b;
                        b++;
                    }else {
                        break;
                    }
                } else {
                    break;
                }
            }
            return ints;
        }
        return ints;
    }

}

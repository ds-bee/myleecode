package com.huang.easy.removeElement;

class Solution1 {
    public static void main(String[] args) {
//        int[] nums = {3,3,2};
        int[] nums = {0,1,2,2,3,0,4,2};
//        int[] nums = {2};
        int target = 2;
        int a = removeElement(nums,target);
        for(int i=0;i<nums.length;i++)
        {
            System.out.println(nums[i]);
        }
        System.out.println(a);
    }
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            if (nums[0] == val){
                return 0;
            }else {
                return 1;
            }
        }
        int record1 = 0, record2 = 0;
        for (int i = 0; i < nums.length; i++) {
            while (record2 < nums.length && nums[record2] == val){
                record2++;
//                if (record2 < nums.length) {
//                    record2++;
//                }

//                if(record2 < nums.length ){
//                    nums[i] = nums[record2];
//                }else {
//                    return record2 - record1;
//                }
            }
            if(record2 < nums.length){
                nums[i] = nums[record2];
            }
            record2++;
            record1++;

        }
        return nums.length - (record2 - record1);
    }
}

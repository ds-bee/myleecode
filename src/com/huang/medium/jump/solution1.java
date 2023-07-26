package com.huang.medium.jump;

public class solution1 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
//        if(nums.length == 0){
//            return 0;
//        }
        int end = 0;
        int record = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(i == end){
                record++;
            }
            if(i + nums[i] > end){
                end = i + nums[i];
            }

        }
        return end>=nums.length-1?record:-1;
    }

    /**
     * 有参数的递归怎么弄的
     * @param nums
     * @param start
     * @param record
     */
    public static void find(int[] nums, int start, int record){
        if(start == nums.length - 1){
            return ;
        }
        int tem = nums[start];
        for (int i = tem; i > 0; i--) {
            record++;
            find(nums, i, record);
            record--;
        }
    }

}

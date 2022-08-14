package com.huang.easy.minStartValue;

public class Solution {
    static int startValue = 1 ;

    public static void main(String[] args) {
        int[] ints = {-3,2,-3,4,2};
        System.out.println(minStartValue(ints));
    }
    public static int minStartValue(int[] nums) {
        int  tem = startValue;

        for (int i = 0; i < nums.length; i++) {
            tem = tem  + nums[i];
            if(tem < 1){
                startValue++;
                minStartValue(nums);
                break;
            }
        }

        return startValue;


    }
}

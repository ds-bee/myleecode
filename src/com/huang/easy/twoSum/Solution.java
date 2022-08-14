package com.huang.easy.twoSum;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {

        int first = 0;
        int end = numbers.length - 1;

        while (first< end) {
            if ((numbers[first] + numbers[end]) < target) {
                first++;
            }else if ((numbers[first] + numbers[end]) > target){
                end--;
            }else {
                return new int[]{first, end};
            }
        }
        return null;
    }

}

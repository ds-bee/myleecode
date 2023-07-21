package com.huang.medium.productExceptSelf;

import java.util.Arrays;

public class solution {
    public static void main(String[] args) {
        int[] arr = {5,9,2};
        int[] ints = productExceptSelf(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] productExceptSelf(int[] nums) {
//        int[] ints = new int[nums.length];
        int record = nums[0];
        nums[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            int tem = nums[0];
            for (int j = 0; j < i; j++) {
                nums[j] = nums[i] * nums[j];
            }
            nums[i] = tem;
        }
        nums[0] = nums[0] * record;
        return nums;
    }

    /**
     * 左右数组投递
     * @param nums
     * @return
     */

    public int[] productExceptSelf1(int[] nums) {
        int length = nums.length;

        // L 和 R 分别表示左右两侧的乘积列表
        int[] L = new int[length];
        int[] R = new int[length];

        int[] answer = new int[length];

        // L[i] 为索引 i 左侧所有元素的乘积
        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }

        // R[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;
    }
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }


    /**
     * 超出时间限制
     * @param nums
     * @return
     */
//    public static int[] productExceptSelf(int[] nums) {
//        int[] ints = new int[nums.length * 2];
//        for (int i = 0; i < nums.length; i++) {
//            ints[i] = nums[i];
//            ints[i+ nums.length] = nums[i];
//        }
//        for (int i = 1; i <= nums.length; i++) {
//            int tem = 1;
//            int record = 1;
//            while (tem < nums.length){
//                record = ints[i - 1+tem] * record;
//                tem++;
//            }
//            nums[i-1] = record;
//        }
//        return nums;
//    }
}

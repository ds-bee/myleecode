package com.huang.medium.nextGreaterElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
//        int[] arr = {1,2,1};
        int[] arr = {1,8,-1,-100,-1,222,1111111,-111111};
        Collections.sort(new ArrayList<Integer>());
//        int[] arr = {1,2,3,4,3};
//        int[] arr = {5,4,3,2,1};
        for (int i = 0; i < nextGreaterElements(arr).length; i++) {
            System.out.println(nextGreaterElements(arr)[i]);
        }
    }
    public static int[] nextGreaterElements(int[] nums) {
        int[] ints = new int[nums.length];
        Arrays.fill(ints,Integer.MIN_VALUE);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[stack.peek()]){
                while (!stack.isEmpty()&&nums[i] > nums[stack.peek()]){
                    Integer pop = stack.pop();
                    ints[pop] = nums[i];
                }
                stack.push(i);
            }else {
                stack.push(i);
            }
        }
        for (int i = 0; i < ints.length; i++) {
            if(ints[i] == Integer.MIN_VALUE){
                ints[i] = -1;
                for (int j = 0; j < nums.length; j++) {
                    if(nums[j]>nums[i] && i!=j ){
                        ints[i] = nums[j];
                        break;
                    }
                }
            }
        }

//        for (int i = nums.length - 1; i >= 0; i--) {
//            if(nums[i] > nums[nums.length - 1]){
//                ints[nums.length - 1] = nums[i];
//                break;
//            }
//        }
        return ints;
    }


}

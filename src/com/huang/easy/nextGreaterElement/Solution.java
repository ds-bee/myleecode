package com.huang.easy.nextGreaterElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
//        int[] nums1 = {4,1,2};
//        int[] nums1 = {1,3,4,2};
//        int[] nums2 = {1,3,4,2};
        int[] nums1 = {137,59,92,122,52,131,79,236,94,171};
        int[] nums2 = {137,59,92,122,52,131,79,236,94,171};
        for (int i = 0; i < nextGreaterElement(nums1, nums2).length; i++) {
            System.out.println(nextGreaterElement(nums1, nums2)[i]);
        }

    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr2 = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1;i < nums2.length; i++){
            if(nums2[i] > nums2[stack.peek()]){
                while (!stack.isEmpty()&&nums2[i] > nums2[stack.peek()]){
                    Integer pop = stack.pop();
                    arr2[pop] = i-pop;
                }
                stack.push(i);
            }else {
                stack.push(i);
            }
        }
        int[] arr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            arr[i] = -1;
            for (int j = 0; j < nums2.length; j++) {
                if(nums2[j] == nums1[i]){
                    if(arr2[j] == 0){
                        arr[i] = -1;
                    }else {
                        arr[i] = nums2[j + arr2[j]];
                    }
                    break;
                }
            }
        }
        return arr;
    }
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Stack<Integer> temp = new Stack<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0 ; i< nums1.length ; i++){
            hashMap.put(nums1[i],i);
        }
        temp.add(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[temp.peek()]) {
                temp.add(i);
            } else {
                while (!temp.isEmpty() && nums2[temp.peek()] < nums2[i]) {
                    if (hashMap.containsKey(nums2[temp.peek()])){
                        Integer index = hashMap.get(nums2[temp.peek()]);
                        res[index] = nums2[i];
                    }
                    temp.pop();
                }
                temp.add(i);
            }
        }

        return res;
    }
}

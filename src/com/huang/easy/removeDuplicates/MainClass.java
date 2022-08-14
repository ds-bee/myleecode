//package com.huang.easy.removeDuplicates;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//class Solution {
//    public int removeDuplicates(int[] nums) {
//        int index = 0;
//        int index1 = 0;
//
//        int[] ints = new int[nums.length - index];
//        for (int i = 1; i < nums.length; i++) {
//            ints[0] = nums[0];
//            if(nums[i-1] == nums[i]){
//                index++;
//                continue;
//            }else {
//                index1++;
//                ints[index1] = nums[i];
//            }
//        }
//        int[] ints = new int[nums.length - index];
//        return index;
//    }
//}
//
//public class MainClass {
//    public static int[] stringToIntegerArray(String input) {
//        input = input.trim();
//        input = input.substring(1, input.length() - 1);
//        if (input.length() == 0) {
//            return new int[0];
//        }
//
//        String[] parts = input.split(",");
//        int[] output = new int[parts.length];
//        for(int index = 0; index < parts.length; index++) {
//            String part = parts[index].trim();
//            output[index] = Integer.parseInt(part);
//        }
//        return output;
//    }
//
//    public static String integerArrayToString(int[] nums, int length) {
//        if (length == 0) {
//            return "[]";
//        }
//
//        String result = "";
//        for(int index = 0; index < length; index++) {
//            int number = nums[index];
//            result += Integer.toString(number) + ", ";
//        }
//        return "[" + result.substring(0, result.length() - 2) + "]";
//    }
//
//    public static String integerArrayToString(int[] nums) {
//        return integerArrayToString(nums, nums.length);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int[] nums = stringToIntegerArray(line);
//
//            int ret = new Solution().removeDuplicates(nums);
//            String out = integerArrayToString(nums, ret);
//
//            System.out.print(out);
//        }
//    }
//}
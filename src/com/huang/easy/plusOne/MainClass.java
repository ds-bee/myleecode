//package com.huang.easy.plusOne;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//class Solution {
//    public int[] plusOne(int[] digits) {
//        if(digits[digits.length - 1] < 9){
//            digits[digits.length - 1] = digits[digits.length - 1] + 1 ;
//            return digits;
//        }else{
//            int a = 0;
//            int b = 9;
//            for (int i = digits.length -1; i < 0 ; i--) {
//                if (digits[i] == 9 && b==9){
//                    b = digits[i-1];
//
//                    a++;
//                }
//            }
//            int i = digits.length;
//            int[] digits1 = new int[i + a ];
//            while((digits[i] + 1) == 10){
//                digits1[i ] = 0;
//                digits1[i -1] = 1;
//
//            }
//            return digits1;
//        }
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
//            int[] digits = stringToIntegerArray(line);
//
//            int[] ret = new Solution().plusOne(digits);
//
//            String out = integerArrayToString(ret);
//
//            System.out.print(out);
//        }
//    }
//}
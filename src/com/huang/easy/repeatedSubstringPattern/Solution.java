package com.huang.easy.repeatedSubstringPattern;

public class Solution {
    public static void main(String[] args) {
        String str = "aabaaba";
        boolean b = repeatedSubstringPattern(str);
        System.out.println(b);
    }
//    public static boolean repeatedSubstringPattern(String s) {
//        char[] chars = s.toCharArray();
//        if(chars.length ==2){
//            if(chars[0] == chars[1]){
//                return true;
//            }
//        }
//        int first = 0, end = 0;
//        for (int i = 0; i < chars.length; i++) {
//            end++;
//            if(end> chars.length-1){
//                break;
//            }
//            while (end!= chars.length-1 && chars[first] == chars[end]){
//                first++;
//                end++;
//                if(end == chars.length -1 && chars[first] == chars[end]){
//                    return true;
//                }
//            }
//            first = 0;
//        }
//        return false;
//    }

    public static boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i < s.length(); i++) {


        }
        return false;
    }

}

package com.huang.medium.restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "011";
        StringBuilder stringBuilder = new StringBuilder(s);
//        for (int i = 0; i < stringBuilder.length(); i++) {
//            System.out.println(stringBuilder.indexOf(i));
//
//        }
        System.out.println(stringBuilder);

    }
    static List<String> list = new ArrayList<>();
    static StringBuilder str = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder(s);




        return null;
    }
    public static void find(char[] chars, StringBuilder stringBuilder,int start){
        if(start == stringBuilder.length()){
            list.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if(chars[start] == '0'){
                stringBuilder.append(chars[start]);
                stringBuilder.append(".");
                str.append(chars[start]);
            }
        }
    }
//    public static boolean justic(StringBuilder stringBuilder){
//
//
//    }


}

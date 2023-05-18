package com.huang.easy.reverseLeftWords;

public class Solution {
    public static void main(String[] args) {
        String str = "abcdefg";
        String s = reverseLeftWords(str, 2);
        System.out.println(s);


    }

//    public static String reverseLeftWords(String s, int n) {
//        StringBuilder stringBuilder = new StringBuilder();
//        StringBuilder stringBuilder1 = new StringBuilder();
////        int k = 0;
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if(i<n){
//                stringBuilder.append(chars[i]);
//            }else {
//                stringBuilder1.append(chars[i]);
//            }
//        }
//        StringBuilder append = stringBuilder1.append(stringBuilder);
//        return append.toString();
//
//    }

    public static String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        reverseStringv1(chars);
        int first = 0,end = 0;
        for (int i = 0; i < chars.length; i++) {
            if(end== chars.length-n -1 || end == chars.length-1){
                reverseString(chars,first,end);
                first = end + 1;
            }
            end++;
        }
        return new String(chars);


    }
    public static void reverseString(char[] s, int first, int end) {
//        int first = 0, end = s.length - 1;
        for (int i = end; i >= first; i--) {
            if (first < end) {
                char tem = s[i];
                s[i] = s[first];
                s[first] = tem;
                first++;
                end--;
            } else {
                break;
            }
        }
    }
    public static void reverseStringv1(char[] s) {
        int first = 0, end = s.length - 1;
        for (int i = s.length - 1; i >= 0; i--) {
            if(first<end) {
                char tem = s[i];
                s[i] = s[first];
                s[first] = tem;
                first++;
                end--;
            }else {
                break;
            }
        }

    }


}

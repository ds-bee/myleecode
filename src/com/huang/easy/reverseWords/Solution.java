package com.huang.easy.reverseWords;

public class Solution {
    public static void main(String[] args) {
        String ste = "is  ue";
        removeSpace(ste);
        String s = reverseWords(ste);
        System.out.println(s);
    }
//    public static String reverseWords(String s) {
//        char[] chars = s.toCharArray();
////        char[] chars1 = chars;
//        int first = chars.length - 1;
//        int end = chars.length -1;
//        int reduce = 0;
//        for (int i = chars.length - 1; i >= 1; i--) {
////            while (chars[i-1] == ' ' && chars[i-2] == ' '){
//            if(chars[i -1] == ' '){
//                chars = reverse(chars,first,end );
//                first = end;
//            }
//            if(i == 1 ){
//                end--;
//                first--;
//                chars = reverse(chars,first,end );
//                break;
//            }
//            while (chars[i - 1] == ' ' ){
//                end--;
//                i--;
//                reduce++;
//            }
//
//            end--;
//
//        }
//        char[] chars2 = new char[chars.length - reduce];
//        int tem = 0;
//        for (int i = chars.length - 1; i >= 0; i--) {
//            while (chars[i] == ' ' ){
////                end--;
//                i--;
//            }
//            chars2[tem] = chars[i];
//            tem++;
//        }
//        return new String(chars2);
//    }

    private static StringBuilder removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
//        char[] chars1 = chars;
        int first = 0;
        int end = 0;
        int reduce = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if(chars[i + 1] == ' '){
                if(chars[i] == ' '){
                    reduce++;
                }
                chars = reverse(chars, first, end);
                end++;
                first = end;
                first++;
            }
            end++;
        }
        end--;
        if(chars[chars.length-1] != ' '){
            chars = reverse(chars, first, end);
        }
        char[] chars1 = new char[chars.length - reduce];



        return new String(chars);

    }

    public static char[] reverse(char[] chars, int frist, int end){
        while (frist < end){
            char tem = chars[frist];
            chars[frist] = chars[end];
            chars[end] = tem;
            end--;
            frist++;
        }
        return chars;
    }

}

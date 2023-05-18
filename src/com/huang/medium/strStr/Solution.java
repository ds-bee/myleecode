package com.huang.medium.strStr;

public class Solution {
    public static void main(String[] args) {
//        String a = "sadbutsad", b = "sad";"mississippi"
//"issip"
//        String a = "hello", b = "ll";
//        String a = "mississippi", b = "issip";
//        String a = "ippi", b = "pi";
        String a = "aabaaf", b = "aabaaf";
        int i = strStr(a, b);
        System.out.println(i);
    }
//    public static int strStr(String haystack, String needle) {
//        char[] chars = haystack.toCharArray();
//        char[] chars1 = needle.toCharArray();
//        int flag = 0 ,record = 0;
////        haystack.indexOf()
//        for (int i = 0; i < chars.length; i++) {
//            int tem = i;
//            for (int i1 = 0; i1 < chars1.length; i1++) {
//                if(i<chars.length && chars[i] == chars1[i1]){
//                    flag = 0;
//                }else {
//                    flag = -1;
////                    i--;
//                    break;
//                }
//                i++;
//            }
//            if(flag == 0){
//                record = i;
//                break;
//            }
////            if()
//            if(i - tem > 0){
//                i= i -1;
//                if(i-tem> 1){
//                    i--;
//                }
//            }
//
//        }
//        if(flag == 0){
//            return record-needle.length();
//        }
//        return -1;
//    }
    public static void getNext(int[] next, String s){
    int j = -1;
    next[0] = j;
    for (int i = 1; i < s.length(); i++){
        while(j >= 0 && s.charAt(i) != s.charAt(j+1)){
            j=next[j];
        }

        if(s.charAt(i) == s.charAt(j+1)){
            j++;
        }
        next[i] = j;
    }
}
    public static int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }

        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for(int i = 0; i < haystack.length(); i++){
            while(j>=0 && haystack.charAt(i) != needle.charAt(j+1)){
                j = next[j];
            }
            if(haystack.charAt(i) == needle.charAt(j+1)){
                j++;
            }
            if(j == needle.length()-1){
                return (i-needle.length()+1);
            }
        }

        return -1;
    }

}

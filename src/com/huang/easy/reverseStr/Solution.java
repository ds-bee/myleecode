package com.huang.easy.reverseStr;

public class Solution {
    public static void main(String[] args) {
        String str = "abcdefg";
//        String str = "abcd";
        String s = reverseStr(str, 3);
        System.out.println(s);

    }
    //数组 直接传地址 直接操作数组 我是想通过其他进行赋值操作
    public static String reverseStr(String s, int k) {
        if(s.length() == 0 || s.length() == 1){
            return s;
        }
        int frist = 0, end = k;
        char[] chars = s.toCharArray();
        char[] chars1 = new char[k];
//        char[] chars2 = new char[2 * k];
        for (int i = 0; i < chars.length; i++) {
            int i2 = i % (2 * k);
            while (i2 < k ){
                chars1[i2] = chars[i];
                i2++;
            }
//            if( i % (2 * k) < 2*k && i % (2 * k) > k ){
//                chars2[i % (2 * k)] = chars[i];
//            }
            int tem1 = 0;
            if( i % (2 * k ) == 0){
                for (int i1 = frist; i1 < end; i1++) {
                    chars1[tem1] = chars[i1];
                    tem1++;
//                    chars1[2] = chars[2];
                }
//                continue;
            }
            if((i % (2 * k )) == 0){
                reverseString(chars1);
                int tem = 0;
                for (int i1 = frist; i1 < end; i1++) {
                    chars[i1] = chars1[tem];
                    tem++;
                }
                frist = frist + 2*k ;
                end = end + 2*k ;
            }
        }
        return new String(chars);
    }
    public static void reverseString(char[] s) {
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

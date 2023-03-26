package com.huang.easy.reverseString;

public class Solution {
    public static void main(String[] args) {
        char[] chars = {'h','e','l','l','o'};
        reverseString(chars);
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

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

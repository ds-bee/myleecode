package com.huang.medium.countSubstrings;

public class Solution {
    public static void main(String[] args) {
//        String s = "abc";
//        String s = "aaa";
        String s = "lcttgteqthcvyoueyftiwgww";
        System.out.println(s.length());
        System.out.println(countSubstrings(s));

    }
    public static int countSubstrings(String s) {
        int[] dp = new int[s.length()];
        int record = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1 ; j <= s.length(); j++) {
//                String substring = s.substring(i, j);
                if (find(s.substring(i,j))) {
                    record++;
                }
            }
        }
        return record;
    }

    public int countSubstrings1(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        //dp数组的定义是字符串下标i，j是否是回文字符串
        boolean[][] dp = new boolean[len][len];
        int result = 0;
        //为了将所有的dp矩阵相关的信息都利用起来，需要从后遍历
        //做了最长回文数子串之后，感觉这个也有倒置遍历的思想
        for (int i = len - 1; i >= 0; i--) {
            //实际是从左下角推导右上角
            for (int j = i; j < len; j++) {
                if (chars[i] == chars[j]) {
                    //这里的情况是基于dp数组的定义来定义的
                    if (j - i <= 1) { // 情况一 和 情况二
                        result++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) { //情况三
                        result++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return result;
    }

    public static boolean find(String s){
//        if(s.length() == 1){
//            return true;
//        }
        int j = s.length() ;
        for (int i = 0; i < s.length()/2; i++) {
            j--;
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }

        }
        return true;
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;  // 发现不匹配的字符，不是回文字符串
            }
            left++;
            right--;
        }

        return true;  // 没有发现不匹配的字符，是回文字符串
    }


}

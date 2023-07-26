package com.huang.medium.partition;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "abab";
        partition(s).forEach(list -> {
            System.out.println();
            list.forEach(item -> {
                System.out.print(item);
                System.out.print(",");
            });
        });
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        List<String> arr = new ArrayList<>();
//        StringBuilder str = new StringBuilder(s);
//        String str = "";
        find(lists,arr,0,s.length(),s);
        return lists;
    }

    public static void find(List<List<String>> lists, List<String> arr,int start,int end, String s ){
        if(  start == s.length()  ){
            lists.add(new ArrayList<>(arr));
            return;
        }
        //这里优化的逻辑是如果从startIndex开始剩下的数没有足够的k个则不用遍历这些数，实现了剪枝
//        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if(isPalindrome(str)){
                arr.add(str);
                find(lists,arr,i,end,s);
                arr.remove(arr.size() - 1);
            }

        }
    }

//    public static boolean justic(String s){
//        int len = s.length()-1;
//        for (int i = 0; i < s.length()/2; i++) {
//            if(s.substring(i,i+1) != s.substring(len-1,len)){
//                return false;
//            }
//            len--;
//        }
//        return true;
//    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}

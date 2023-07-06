package com.huang.medium.generateParenthesis;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int n = 3;
        generateParenthesis(n).forEach(item -> System.out.println(item));

    }
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String s = "";
        find(0,n,list,s);
        return list;
    }

    public static void find(int start ,int n , List<String> list,String s){
        if(start == n){
            for (int i1 = 0; i1 < start + 1; i1++) {
                s = s + ")";
            }
            list.add(s);
            return ;
        }
        for (int i = start; i < n; i++) {
            s = s + "(";
            find(start + 1,n,list,s);
//            s = s + ")";
            s = s.substring(0,start + 1);
        }

    }

    /**
     * 回溯算法忘了很多了，需要去刷一刷，复习一下
     * 回溯算法一个是终止条件，一个是遍历的方式，这里一个是忘了回溯算法基本的使用方法
     * 还有就是这里两个括号都需要使用回溯来进行删减
     * 同时操作字符串需要用到StringBuilder，方便进行字符的删减
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


}

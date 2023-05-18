package com.huang.easy.removeDuplicates3;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
//        String a = "aabaaf";
        String a = "abbaca";
        String i = removeDuplicates(a);
        char[] chars = i.toCharArray();
        for (int i1 = 0; i1 < chars.length; i1++) {
            System.out.println(chars[i1]);
        }
    }
    public static String removeDuplicates(String s) {
//        int flag = 0;
        while (judge(s)){
//            flag = 0;
            char[] chars = s.toCharArray();
            StringBuilder builder = new StringBuilder();
            Stack<Character> characters = new Stack<>();
            for (int i = 0; i < chars.length; i++) {
                characters.push(chars[i]);
            }
            while (!characters.isEmpty() ){
                int flag = 0;
                Character pop = characters.pop();
                if (!characters.isEmpty() && characters.peek()==pop) {
                    characters.pop();
                    flag = 1;
                }
                if(flag == 0){
                    builder.append(pop);
                }else {
                    if(!characters.isEmpty()){
                        builder.append(characters.pop());
                    }
                }
            }
            s = builder.toString();
        }
        return s;
    }
    public static boolean judge(String s){
        char[] chars = s.toCharArray();
        char record = 0;
        for (int i = record + 1; i < chars.length; i++) {
            if(chars[record] == chars[i]){
                return true;
            }
            record++;
        }
        return false;
    }

}

package com.huang.easy.isValid;

import com.huang.utils.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        String a = "()[]{}";
        boolean valid = isValid(a);
        System.out.println(valid);

    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> characters2 = new Stack<>();
        Queue<Character> characters1 = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            characters1.offer(chars[i]);
            characters2.push(chars[i]);
        }
        boolean flag = true;
        while (!characters1.isEmpty()){
            Character character = characters1.poll();
            if(character == '(' && characters2.pop() != ')'){
                flag = false;
            }

            if(character == '[' && characters2.pop() != ']'){
                flag = false;
            }

            if(character == '{' && characters2.pop() != '}'){
                flag = false;
            }
            if(!flag){
                return flag;
            }
        }
        return flag;
    }

    public static boolean isValid1(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> characters1 = new Stack<>();
        Stack<Character> characters2 = new Stack<>();
        Stack<Character> characters3 = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '(' ){
                characters1.push(chars[i]);
            }
            if(chars[i] == '['){
                characters2.push(chars[i]);
            }
            if(chars[i] == '{'){
                characters3.push(chars[i]);
            }
            if(chars[i] == ')'){
                if(characters1.isEmpty()){
                    return false;
                }else {
                    characters1.pop();
                }
            }
            if(chars[i] == ']'){
                if(characters2.isEmpty()){
                    return false;
                }else {
                    characters2.pop();
                }
            }
            if(chars[i] == '}'){
                if(characters3.isEmpty()){
                    return false;
                }else {
                    characters3.pop();
                }
            }
        }
        if (characters1.isEmpty() && characters2.isEmpty()&&characters3.isEmpty()){
            return true;
        }
        return false;
    }
}
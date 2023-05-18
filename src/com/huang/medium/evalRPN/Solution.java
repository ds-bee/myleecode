package com.huang.medium.evalRPN;

import java.util.Objects;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
//        String[] strs = {"2","1","+","3","*"};
        String[] strs = {"4","13","5","/","+"};
        int i = evalRPN(strs);
        System.out.println(i);
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> strings = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(Objects.equals(tokens[i], "+")){
                Integer pop = strings.pop();
                Integer pop1 = strings.pop();
                strings.push(pop1 + pop);
            }else if(Objects.equals(tokens[i], "-")){
                Integer pop = strings.pop();
                Integer pop1 = strings.pop();
                strings.push(pop1 - pop);
            }
            else if(Objects.equals(tokens[i], "*")){
                Integer pop = strings.pop();
                Integer pop1 = strings.pop();
                strings.push(pop1 * pop);
            }
            else if(Objects.equals(tokens[i], "/")){
                Integer pop = strings.pop();
                Integer pop1 = strings.pop();
                strings.push(pop1 / pop);
            }else {
                strings.push(Integer.parseInt(tokens[i]));
            }
        }
        return strings.pop();
    }
}

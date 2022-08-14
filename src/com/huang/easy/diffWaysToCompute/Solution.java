package com.huang.easy.diffWaysToCompute;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    ArrayList<Integer> integers = new ArrayList<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if(expression.length() == 3){
            integers.add(twoSum(expression));
        }
        diffWaysToCompute(expression.substring(1));
        char[] chars = expression.toCharArray();

        return integers;
    }


//    public static int threeSum(char[] chars){
//        if(chars.length == 3){
//            //进行运算
//            return twoSum(chars);
//        }
////        threeSum(chars.)
//
//    }
    public static int twoSum(char[] chars){
        if(chars[1] == '+'){
            return (int)chars[0] + (int) chars[2];
        }else if(chars[1] == '-'){
            return (int)chars[0] - (int) chars[2];
        }else if(chars[1] == '*'){
            return (int)chars[0] * (int) chars[2];
        }else if (chars[1] == '/'){
            return (int)chars[0] / (int) chars[2];
        }
        return -1;
    }
    public static int twoSum(String expression){
        char[] chars = expression.toCharArray();
        if(chars[1] == '+'){
            return (int)chars[0] + (int) chars[2];
        }else if(chars[1] == '-'){
            return (int)chars[0] - (int) chars[2];
        }else if(chars[1] == '*'){
            return (int)chars[0] * (int) chars[2];
        }else if (chars[1] == '/'){
            return (int)chars[0] / (int) chars[2];
        }
        return -1;
    }
}

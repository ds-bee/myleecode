package com.huang.medium.monotoneIncreasingDigits;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        int n = 101;
//        int n = 101;
        int n = 100;
//        int n = 332;
//        int n = 1231;
        System.out.println(monotoneIncreasingDigits(n));
    }
    public static int monotoneIncreasingDigits(int N) {
        //分割数字
        String[] strings = (N + "").split("");
        int start = strings.length;
        for (int i = strings.length - 1; i > 0; i--) {
            if (Integer.parseInt(strings[i]) < Integer.parseInt(strings[i - 1])) {
                strings[i - 1] = (Integer.parseInt(strings[i - 1]) - 1) + "";
                start = i;
            }
        }
        for (int i = start; i < strings.length; i++) {
            strings[i] = "9";
        }
        return Integer.parseInt(String.join("",strings));
    }

    public static boolean find(List<Integer> list){
        boolean flag = true;
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i) < list.get(i + 1)){
                flag = false;
                break;
            }

        }
        return flag;
    }

}

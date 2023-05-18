package com.huang.easy.isHappy;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        boolean happy = isHappy(10);
        System.out.println(happy);
    }
    private static HashSet<Integer> flag  = new HashSet<Integer>();
    public static boolean isHappy(int n) {
//        HashSet<Integer> flag;
//        HashSet<Integer> flag = new   HashSet<Integer>();
        if(flag.contains(n)){
            return false;
        }
        int i = 10;
        int record = n ;
        int sum = 0;
        flag.add(n);
        while ( (record) != 0){
            sum = (int) (sum + Math.pow(record % 10,2));
//            i = i * 10;
            record = record/i;
        }

        if(sum == 1 ){
            return true;
        }else {
            return isHappy(sum);
        }
    }

}

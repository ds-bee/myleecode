package com.huang.easy.lemonadeChange;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        System.out.println(lemonadeChange(arr));
    }
    public static boolean lemonadeChange(int[] bills) {
//        Map<Integer, Integer> billMap = new HashMap<>();
        int sum5 = 0;
        int sum10 = 0;
        int sum20 = 0;
        for (int i = 0; i < bills.length; i++) {
            System.out.println(i);
            if(bills[i] == 5){
                sum5++;
            }
            if(bills[i] == 10){
                if(sum5>0){
                    sum5--;
                    sum10++;
                }else {
                    return false;
                }
            }
            if(bills[i] == 20){
                if(sum10 > 0){
                    sum10--;
                    if(sum5 > 0){
                        sum5--;
                    }else {
                        return false;
                    }
                }else if(sum5 > 2){
                    sum5 = sum5 - 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}

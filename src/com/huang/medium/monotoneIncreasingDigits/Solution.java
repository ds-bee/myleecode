package com.huang.medium.monotoneIncreasingDigits;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        int n = 101;
        int n = 101;
//        int n = 100;
//        int n = 332;
//        int n = 1234;
        System.out.println(monotoneIncreasingDigits(n));
    }
    public static int monotoneIncreasingDigits(int n) {
        int record = n;
        ArrayList<Integer> list = new ArrayList<>();
        while (record > 0){
            list.add(record % 10);
            record = record / 10;
        }
        boolean flag = false;
//        while (!flag) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) < list.get(i + 1) && list.get(i+1)!=0) {
                    list.set(i, 9);
                    list.set(i + 1, list.get(i + 1) - 1);
                    continue;
                }
                if(list.get(i) < list.get(i + 1) && list.get(i+1)==0){
                    list.set(i, 9);
//                    list.set(i + 1, 9);
                }
                if (list.get(i) == list.get(i + 1) && list.get(i) == 0) {
                    list.set(i, 9);
                }
            }
//            flag = find(list);
//        }
        int a = 1;
        for (int i = 0; i < list.size(); i++) {
            record = list.get(i) * a + record;
            a = a*10;
        }
        return record;
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

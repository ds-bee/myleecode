package com.huang.hard.maxSlidingWindow.solveNQueens;

import java.util.ArrayList;
import java.util.List;


public class Solution {

    public static void main(String[] args) {
        List<List<String>> lists1 = solveNQueens(4);
        for (int i = 0; i < lists1.size(); i++) {
            List<String> list = lists1.get(i);
            System.out.println();
            for (int i1 = 0; i1 < list.size(); i1++) {
                System.out.println(list.get(i1));
            }
        }
    }

    static List<List<String>> lists = new ArrayList<>();
    static List<String> str = new ArrayList<>();

    static List<int[]> integerList = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                s = s.append(".");
            }
            str.add(String.valueOf(s));
        }
        find(0, 0, str, 0 ,n);
        return lists;
    }

    public static void find(int start, int end, List<String> str, int nums, int n){
        if(nums == n){
            lists.add(new ArrayList<>(str));
            return;
        }
        if (!judge(start, end, integerList)) {
            find(start, end+1, str, nums, n );
            return;
        }
        for (int i = start; i < n; i++) {
//            if(judge(start, end, integerList)){
            integerList.add(new int[]{start, end});
            nums++;
            String newStr = str.get(start).substring(0, end) + "Q" + str.get(start).substring(end + 1);
            str.set(start,newStr) ;
//            }
            find(start, end+1, str, nums, n );
            nums--;
            str.remove(str.size() - 1);
            integerList.remove(start);
        }
    }

    public static boolean judge(int start, int end, List<int[]> integerList){
        if(integerList.size() == 0){
//            integerList.add(new int[]{start, end});
            return true;
        }
        boolean flag = true;
        for (int i = 0; i < integerList.size(); i++) {
            if((end - integerList.get(i)[1]) == 0 ){
                return false;
            }
            int record = (start - integerList.get(i)[0]) / (end - integerList.get(i)[1]);
            if(record == 1 || record == -1){
                flag = false;
            }
        }
        return flag;
    }
}

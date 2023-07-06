package com.huang.medium.combinationSum3;

import java.util.ArrayList;
import java.util.List;

public class Solutiion1 {
    public static void main(String[] args) {
        List<List<Integer>> combine = combinationSum3(4, 15);
        for (int i = 0; i < combine.size(); i++) {
            List<Integer> list = combine.get(i);
            System.out.println();
            for (int i1 = 0; i1 < list.size(); i1++) {
                System.out.print(list.get(i1));
            }
        }

    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        find(lists,arr,1,0,n,k);
        return lists;
    }

    public static void find(List<List<Integer>> lists, List<Integer> arr,int start,int record , int n ,int k){
        if(record == n && arr.size() == k){
            lists.add(new ArrayList<>(arr));
        }
        /**
         *    if (sum > targetSum) { // 剪枝操作
         *         sum -= i; // 剪枝之前先把回溯做了
         *         path.pop_back(); // 剪枝之前先把回溯做了
         *         return;
         *     }
         */
        for (int i = start; i <= 9; i++) {
            arr.add(i);
            record = record + i;
            find(lists,arr,i+ 1,record,n,k);
            record = record - i;
            arr.remove(arr.size() - 1);
        }
    }
}

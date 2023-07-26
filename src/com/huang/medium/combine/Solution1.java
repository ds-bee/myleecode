package com.huang.medium.combine;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        int n = 4 ,k =2;
        combine(n,k).forEach(list -> list.forEach(System.out::print));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        find(lists,arr,1,n,k);
        return lists;

    }

    public static void find(List<List<Integer>> lists, List<Integer> arr,int start, int n ,int k){
        if(arr.size() == k){
            lists.add(new ArrayList<>(arr));
            return;
        }
        //这里优化的逻辑是如果从startIndex开始剩下的数没有足够的k个则不用遍历这些数，实现了剪枝
//        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
        for (int i = start; i <= n; i++) {
            arr.add(i);
            find(lists,arr,i+ 1,n,k);
            arr.remove(arr.size() - 1);
        }
    }

}

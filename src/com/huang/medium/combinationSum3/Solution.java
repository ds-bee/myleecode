package com.huang.medium.combinationSum3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
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

    static List<List<Integer>> reult = new ArrayList<>();
    static List<Integer> path = new LinkedList<>();
    public static List<List<Integer>> combinationSum3(int k, int n) {

        find(k,n,1);
        return reult;

    }
    public static void find(int k, int n, int start){
        if(path.size() == k){
            int a = n;
            for (int i = 0; i < path.size(); i++) {
                a = a - path.get(i);
            }
            if(a == 0){
                reult.add(new ArrayList<>(path));
            }
        }
        for (int i = start; i < n-1; i++) {
            path.add(i);
            find(k, n, i+1);
            path.remove(path.size() - 1);
        }

    }


}

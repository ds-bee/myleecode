package com.huang.medium.combine;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        for (int i = 0; i < combine.size(); i++) {
            List<Integer> list = combine.get(i);
            for (int i1 = 0; i1 < list.size(); i1++) {
                System.out.println(list.get(i1));
            }
        }

    }
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {

//        for (int i = 1; i <= n; i++) {
//        }
        find(n,k,1);
        return result;
    }
    public static void find(int n, int k, int start){
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < n; i++) {
            path.add(i);
            find(n, k, i+1);
            path.remove(path.size()-1);
        }
    }
}

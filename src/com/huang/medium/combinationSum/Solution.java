package com.huang.medium.combinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
//        int[] arr = {2,3,6,7};
        int[] arr = {2,3,5};
        List<List<Integer>> combine = combinationSum(arr, 8);
        for (int i = 0; i < combine.size(); i++) {
            List<Integer> list = combine.get(i);
            System.out.println();
            for (int i1 = 0; i1 < list.size(); i1++) {
                System.out.print(list.get(i1));
            }
        }

    }
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        find(candidates,target,0);
        return result;
    }
    public static void find(int[] candidates, int target, int start){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target<0){
            return;
        }
        for (int i = start; i < candidates.length; i++) {

            path.add(candidates[i] );
            target = target - candidates[i];
            find(candidates, target, i);
            target = target + candidates[i];
            path.remove(path.size() - 1);

        }
    }

}

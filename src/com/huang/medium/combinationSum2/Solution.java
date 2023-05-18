package com.huang.medium.combinationSum2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        int[] arr = {2,3,6,7};
        int[] arr = {10,1,2,7,6,1,5};
//        int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        Arrays.sort(arr);
        List<List<Integer>> combine = combinationSum2(arr, 8);
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

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
//        result.clear();
        find(candidates,target,0);
//        Set<List<Integer>> uniqueResult = new HashSet<>(result);
//        for (List<Integer> list : uniqueResult) {
//            System.out.println(list);
//        }
//        result = new ArrayList<>(uniqueResult);

        return result;
    }
    public static void find(int[] candidates, int target, int start){
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //这里是找到了一个组合以后，如果下一个数字还是跟组合的最后一个名字相同就进行剪枝
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue; // 剪枝：跳过重复的数字
            }
            path.add(candidates[i]);
            target = target - candidates[i];
            find(candidates, target, i + 1);
            target = target + candidates[i];
            path.remove(path.size() - 1);
        }

    }
}

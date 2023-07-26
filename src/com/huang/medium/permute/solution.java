package com.huang.medium.permute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class solution {
    public static void main(String[] args) {
//        int[] nums = {1,2,3};
        int[] nums = {0,3};
//        List<List<Integer>> permute = permute(nums);
        permute(nums).forEach(list -> {
            System.out.println();
            list.forEach(System.out::print);
        });
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 0);
        }

        find(lists,arr,0,nums,map);
        return lists;

    }
    public static void find(List<List<Integer>> lists, List<Integer> arr, int start,int[] nums, HashMap<Integer, Integer> map){
        if(arr.size() == nums.length){
            lists.add(new ArrayList<>(arr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == 0){
                arr.add(nums[i]);
                map.put(nums[i], 1);
            }else {
                continue;
            }
            find(lists,arr,0,nums,map);
            if(map.get(nums[i]) == 1){
                arr.remove(arr.size() - 1);
                map.put(nums[i], 0);
            }
        }

    }


}

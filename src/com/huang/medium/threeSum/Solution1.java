package com.huang.medium.threeSum;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        int[] ints = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(ints);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println("==");
        }


    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        HashMap<List<Integer>, Integer> listIntegerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                List<Integer> integers = new ArrayList<>();
                integers.add(nums[i]);
                integers.add(nums[i1]);
                listIntegerHashMap.put(integers, nums[i] + nums[i1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(listIntegerHashMap.containsValue(-nums[i])){
                for(Map.Entry<List<Integer>, Integer> entry:listIntegerHashMap.entrySet()){
                    if(entry.getValue() == -nums[i] && !entry.getKey().contains(i)){
                        entry.getKey().add(nums[i]);
                        lists.add(entry.getKey());
                        break;
                    }
                }
            }
        }
//        for (List<Integer> list : lists) {
//
//
//        }
        return lists;
    }
}

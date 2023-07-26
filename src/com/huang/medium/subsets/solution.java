package com.huang.medium.subsets;

import java.util.ArrayList;
import java.util.List;

public class solution {

    static List<List<Integer>> lists = new ArrayList<>();
    static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        lists.add(new ArrayList<>(arr));
        find(nums,0);
        return lists;
    }
    public static void find(int[] nums, int start){
        if(!arr.isEmpty()){
            lists.add(arr);
        }
        for (int i = start; i < nums.length; i++) {
            arr.add(nums[i] );
            find(nums,i+1);
            arr.remove(arr.size()-1);
        }

    }

}

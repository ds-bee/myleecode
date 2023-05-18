package com.huang.medium.fourSumCount;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        int index = 0;
        for (int j : nums1) {
            for (int i : nums2) {
                map.put(index, j + i);
                index++;
            }
        }
        index = 0;
        for (int j : nums3) {
            for (int i : nums4) {
                map1.put(index, i + j);
                index++;
            }
        }
        index = 0;
        //这里多了循环
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(map1.containsValue(-entry.getValue())){
                for(Map.Entry<Integer, Integer> entry1: map1.entrySet()){
                    if(entry1.getValue() == -entry.getValue()){
                        index++;
                    }
                }
            }
        }
        return index;
    }
}

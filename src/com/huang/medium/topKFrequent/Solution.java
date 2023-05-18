package com.huang.medium.topKFrequent;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] a = {4,1,-1,2,-1,2,3};
        int k = 2;
        int[] ints = topKFrequent(a, k);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null){
                map.put(nums[i], 1 );
            }else {
                map.put(nums[i], map.get(nums[i]) + 1 );
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // 遍历map，用最小堆保存频率最大的k个元素 这个东西可以直接实现k个元素的排序
//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                return map.get(a) - map.get(b);
//            }
//        });


        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int[] ints = new int[k];
        int i = 0;
//        Deque<Integer> deque = new LinkedList<Integer>();
//        Queue<Integer> queue = new LinkedList<Integer>();
//        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
//            ints[i] = entry.getKey();
//            if(i == k-1){
//                break;
//            }
//            i++;
//        }
        for(Map.Entry<Integer, Integer> entry:list){
            ints[i] = entry.getKey();
            if(i == k-1){
                break;
            }
            i++;
        }
        return ints;

    }
}

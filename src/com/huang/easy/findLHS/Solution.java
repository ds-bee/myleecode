package com.huang.easy.findLHS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
//        int[] ints = {1,3,2,2,5,2,3,7};
        int[] ints = {0,3,1,3,3,3,0,1,0,2,0,3,1,3,-3,2,0,3,1,2,2,-3,2,2,3,3};
        System.out.println(findLHS(ints));
    }

    public static int findLHS(int[] nums) {


        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],1  );
            }else {
                hashMap.put(nums[i],(hashMap.get(nums[i]) + 1) );
            }
        }
//        ArrayList<Integer> integers = new ArrayList<>();
        int[] ints = new int[hashMap.size()];
        int i = 0;
        for (Integer key : hashMap.keySet()) {
            ints[i] = key;
            i++;
        }
        Arrays.sort(ints);
        int tem = 0;
        for (int i1 = ints.length - 1; i1 >= 1; i1--) {
            if((Math.abs(ints[i1] - ints[i1-1])) == 1 ){
                if (tem < hashMap.get(ints[i1]) + hashMap.get(ints[i1 - 1])){
                    tem =  hashMap.get(ints[i1]) + hashMap.get(ints[i1 - 1]);
                }
            }
        }

        return tem;
    }
}

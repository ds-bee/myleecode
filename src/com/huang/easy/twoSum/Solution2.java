package com.huang.easy.twoSum;

import java.util.HashMap;

public class Solution2 {
    public static void main(String[] args) {
//        int[] ints = {2,7,11,15};
        int[] ints = {3,2,4};
        int[] ints1 = twoSum(ints, 6);
        for (int i = 0; i < ints1.length; i++) {
            System.out.println(ints1[i]);
        }

    }
    public static int[] twoSum(int[] nums, int target) {
//        int[] ints = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int i1 = target - nums[i];
            if(map.containsKey(i1) && i != map.get(i1)){
//                ints[0] = i;
//                ints[1] = map.get(i1);
                return new int[]{i,map.get(i1)};
            }

        }
        return null;
    }

}

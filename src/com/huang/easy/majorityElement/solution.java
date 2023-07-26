package com.huang.easy.majorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class solution {
    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        int record = 0;
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for(Map.Entry<Integer, Integer> item:map.entrySet()){
            if(item.getValue()>nums.length/2){
                record = item.getKey();
                break;
            }
        }
        return record;
    }

}

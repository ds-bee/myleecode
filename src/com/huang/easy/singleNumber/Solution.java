package com.huang.easy.singleNumber;

import java.util.HashMap;
import java.util.Map;

public class Solution {
public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if ((hashMap.get(nums[i]) == null)) {
                hashMap.put(nums[i],1);
            }else {
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            }

        }
        int a = 0;
//        hashMap.forEach((key, value) -> {
//            if(value==1){
//               a = key;
//               return a;
//            }
//        });
        for (Integer i : hashMap.keySet()) {
            Integer count = hashMap.get(i);
            if (count == 1) {
                return i;
            }
        }


        return -1;

    }
}

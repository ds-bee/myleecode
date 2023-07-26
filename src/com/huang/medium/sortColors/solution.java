package com.huang.medium.sortColors;

import java.util.ArrayList;
import java.util.List;

public class solution {
    public void sortColors(int[] nums) {
//        int tem = nums[0];
//        List<Integer> arr1 = new ArrayList<>();
//        List<Integer> arr2 = new ArrayList<>();
//        List<Integer> arr3 = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//
//            if(nums[i] == 0){
//                arr1.add(nums[i] );
//            }
//            if(nums[i] == 1){
//                arr2.add(nums[i] );
//            }
//            if(nums[i] == 2){
//                arr3.add(nums[i] );
//            }
//        }
//        int record = 0;
//        for (int i = 0; i < arr1.size(); i++) {
//            nums[record] = arr1.get(i);
//            record++;
//        }
//        for (int i = 0; i < arr2.size(); i++) {
//            nums[record] = arr2.get(i);
//            record++;
//        }
//        for (int i = 0; i < arr3.size(); i++) {
//            nums[record] = arr3.get(i);
//            record++;
//        }
//        return;
        for (int i = 0; i < nums.length; i++) {
            int tem = nums[i];
            int record = i + 1;
            while (record < nums.length){
                if(nums[record] < tem){
                    nums[i] = nums[record];
                    nums[record] = tem;
                    tem = nums[i];
                }
                record++;
            }
        }


    }

}

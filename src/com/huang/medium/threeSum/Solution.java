package com.huang.medium.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {1,2,-2,-1};
//        int[] nums = {3,-2,1,0};
//        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
//        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
//        int[] nums = {0,0,0,0};
        List<List<Integer>> lists = threeSum(nums);

        for (List<Integer> list : lists) {
            System.out.println("---------");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));

            }
        }
        System.out.println(lists.size());

    }

    public static List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int first = 0;
        int  third = first;
        boolean finalFlag = false;
        for (int i = 0; i < nums.length -1; i++) {
            for (int j = 0; j < nums.length; j++) {
                third = 0;
                int second = j;
                if((second == i ) && second + 1 <=nums.length -1){
                    second++;
                }
                int tem = nums[i] + nums[second];
                while (true){

                    if((third == i )){
                        third++;
                    }
                    if(( third == second) ){
                        third++;
                    }
                    if((third == i )){
                        third++;
                    }
                    if(( third == second) ){
                        third++;
                    }
                    if(third > nums.length -1){
                        break;
                    }

                    if(tem + nums[third] == 0){
                        boolean flag = true;

                        List<Integer> integerList = new ArrayList<>();
                        integerList.add(nums[i]);
                        integerList.add(nums[second]);
                        integerList.add(nums[third]);
                        for (List<Integer> list : lists) {
                            if(list.contains(nums[i]) && list.contains(nums[second]) && list.contains(nums[third]) ){
                                flag = false;
                            }
                            if((nums[i] ==0 && nums[second] == 0 && nums[third] == 0)){
                                finalFlag = true;
                            }
                        }
                        if(flag ){
                            lists.add(integerList);
                        }
                        break;
                    }
                    if(third  <= nums.length -1){
                        third++;
                    }
                }

            }
            }
        boolean finalfinalFlag = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                finalfinalFlag = true;
            }
        }
        if(finalFlag && finalfinalFlag){
            List<Integer> integerList = new ArrayList<>();
            integerList.add(0);
            integerList.add(0);
            integerList.add(0);
            lists.add(integerList);
        }
        return lists;

    }


}

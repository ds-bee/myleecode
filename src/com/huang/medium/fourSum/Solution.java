package com.huang.medium.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        int[] ints = {1,0,-1,0,-2,2};
//        int[] ints = {2,2,2,2,2};
        int[] ints = {-2,-1,-1,1,1,2,2};
        int target = 0;
        List<List<Integer>> lists = fourSum(ints,target);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println("==");
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int one = 0, two = 0, three = nums.length -1, four = nums.length - 1;
        Arrays.sort(nums);
        if(nums[0] > target){
            return null;
        }
        List<List<Integer>> lists =  new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            four = nums.length - 1;
            while (four - i > 2) {
                List<Integer> integers1 = new ArrayList<>();
                if(nums[i] == nums[four] ){
                    integers1.add(nums[i]);
                    integers1.add(nums[two]);
                    integers1.add(nums[three]);
                    integers1.add(nums[four]);
                    lists.add(integers1);
                    return lists;
                }

                int num2 = nums[i];
                if(num2 == nums[i+1]){
                    while (num2 == nums[i]){
                        i++;
                    }
                    i--;
                }

                int num3 = nums[four];
                if(num3 == nums[four-1]) {
                    while (num3 == nums[four]) {
                        four--;
                    }
                    four++;
                }
                int record = 0;
                two = i + 1;
                three = four - 1;
                while (two < three) {
                    List<Integer> integers = new ArrayList<>();
                    record = target - nums[i] - nums[four];
                    if (record - nums[two] == nums[three]) {
                        int num = nums[two];
                        if(num == nums[two+1]){
                            while (num == nums[two]){
                                two++;
                            }
                            two--;
                        }
                        int num4 = nums[three];
                        if(num4 == nums[three-1]) {
                            while (num4 == nums[three]) {
                                three--;
                            }
                            three++;
                        }
                        integers.add(nums[i]);
                        integers.add(nums[two]);
                        integers.add(nums[three]);
                        integers.add(nums[four]);
                        lists.add(integers);
                        two++;
                        three--;

                    } else if (record - nums[two] < nums[three]) {
                        three--;
                    } else {
                        two++;
                    }
                }
                four--;
            }
        }
        return lists;
    }
}

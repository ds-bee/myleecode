package com.huang.medium.canCompleteCircuit;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int[] arr1 = {2,3,4};
//        int[] arr2 = {3,4,3};
//        int[] arr1 = {1,2,3,4,5};
//        int[] arr2 = {3,4,5,1,2};
        int[] arr1 = {5,1,2,3,4};
        int[] arr2 = {4,4,1,5,1};
        System.out.println(canCompleteCircuit(arr1, arr2));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        Arrays.sort(gas);
//        Arrays.sort(cost);
        boolean flag = false;
        int record = 0;
        int sum = 0;
        ArrayList<Integer> listpre = new ArrayList<>();
        for (int i = 0; i < gas.length; i++) {
            int remain = gas[i] - cost[i];
            if(flag){
                sum = sum + remain;
            }
            if(remain > 0 && !flag){
                sum = sum + remain;
                record = i;
                flag = true;
            }
            if(remain < 0 && !flag){
                listpre.add(remain);
            }
            if(sum <= 0 && flag){
                return -1;
            }
        }
        for (int i = 0; i < listpre.size(); i++) {
            sum = sum + listpre.get(i);
            if(i == listpre.size()-1 && sum == 0 ){
                return record;
            }
            if(sum <= 0){
                return -1;
            }
        }
        return record;
    }
}
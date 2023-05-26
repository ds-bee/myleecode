package com.huang.medium.canCompleteCircuit;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int[] arr1 = {2,3,4};
//        int[] arr2 = {3,4,3};
//        int[] arr1 = {1,2,3,4,5};
//        int[] arr2 = {3,4,5,1,2};
        int[] arr1 = {5,8,2,8};
        int[] arr2 = {6,5,6,6};
//        int[] arr1 = {5,1,2,3,4};
//        int[] arr2 = {4,4,1,5,1};
        System.out.println(canCompleteCircuit(arr1, arr2));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        Arrays.sort(gas);
//        Arrays.sort(cost);
        boolean flag = false;
        int record = 0;
        int sum = 0;
        int remain = 0;
        ArrayList<Integer> listpre = new ArrayList<>();
        ArrayList<Integer> listcur = new ArrayList<>();
        for (int i = 0; i < gas.length; i++) {
//            listpre.add(gas[i] - cost[i]);
            if(remain < gas[i] - cost[i]){
                remain = gas[i] - cost[i];
                record = i;
            };

        }
        for (int i = 0; i < gas.length; i++) {
            remain = gas[i] - cost[i];
            if(record > i){
                listpre.add(remain);
            }else {
                sum = sum + remain;
            }
//            if(sum <= 0){
//                return -1;
//            }
        }
        for (int i = 0; i < listpre.size(); i++) {
            sum = sum + listpre.get(i);
            if(i == listpre.size()-1 && sum == 0 ){
                return record;
            }
            if(sum <= 0 ){
                return -1;
            }
        }
        if(sum <= 0 ){
            return -1;
        }
        return record;
    }
}
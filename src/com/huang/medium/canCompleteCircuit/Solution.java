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
        int n = gas.length;
        // 相当于图像中的坐标点和最低点
        int sum = 0, minSum = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {
                // 经过第 i 个站点后，使 sum 到达新低
                // 所以站点 i + 1 就是最低点（起点）
                start = i + 1;
                minSum = sum;
            }
        }
        if (sum < 0) {
            // 总油量小于总的消耗，无解
            return -1;
        }
        // 环形数组特性
        return start == n ? 0 : start;
    }
}
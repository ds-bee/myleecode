package com.huang.medium.findMinArrowShots;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
//        int[][] arr = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] arr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
//        int[][] arr = {{-2147483646,-2147483645}, {2147483646,2147483647}};
//        int[][] arr = {{-2,-1}, {1,2}};
//        int[][] arr = {{1,2},{-2,-1}};
        int ints = findMinArrowShots(arr);
        System.out.println(ints);
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
//        long[][] pointslong =  points; 记住对二维数组排序使用这个方法就行了
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
//        ArrayList<Integer> list = new ArrayList<>();
        int sum = 1;
        long record = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] > record ){
                record = points[i][1];
                sum++;
            }

        }
        return sum;
    }
}



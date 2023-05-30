package com.huang.medium.findMinArrowShots;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[][] arr = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
//        int[][] arr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int ints = findMinArrowShots(arr);
        System.out.println(ints);
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 1;
        list.add(points[0][0]);
        list.add(points[0][1]);
        for (int i = 1; i < points.length; i++) {
            Collections.sort(list);
            int[] point = points[i];
            if(point[1] < list.get(0)){
                list.add(point[1] );
                list.add(point[1] );
                sum++;
            }else if(point[0] > list.get(list.size() - 1)){
                list.add(point[0]);
                sum++;
            }else{
//                sum++;
                list.add(point[0]);
                list.add(point[1]);
            }

        }
        return sum;
    }
}



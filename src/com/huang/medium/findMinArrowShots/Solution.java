package com.huang.medium.findMinArrowShots;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
//        int[][] arr = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] arr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int ints = findMinArrowShots(arr);
        System.out.println(ints);
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 1;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            for (int i1 = 0; i1 < point.length; i1++) {
                if (i1 % 2 == 0) {
                    int i2 = 0;
                    while (i2 < list.size()) {
                        if (i2 % 2 == 0) {
                            if (point[i1] > list.get(i2)) {
                                sum++;
                                break;
                            }
                        }
                        i2 = i2 + 2;
                    }
                    }
                    if (i1 % 2 == 1) {
                        int i2 = 0;
                        while (i2 < list.size()) {
                            if (i2 % 2 == 1) {
                                if (point[i1] > list.get(i2)) {
                                    sum++;
                                    break;
                                }
                            }
                            i2 = i2 + 2;
                        }
                    }
//                        i2++;
                list.add(point[i1]);
            }
        }
        return sum;
    }
}



package com.huang.medium.merge;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int[][] arr = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
//        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] arr = {{1,3},{0,3}};
//        int[][] arr = {{1,4},{2,3}};
//        int[][] arr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[][] arr = {{3, 4}, {5, 6}, {7, 8}, {1, 10}};
        int[][] ints = merge(arr);
        for (int i = 0; i < ints.length; i++) {
            for (int i1 = 0; i1 < ints[i].length; i1++) {
                System.out.print(ints[i][i1]);
            }
            System.out.println();
        }
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int record = Integer.MIN_VALUE;
        int index = -1;
        ArrayList<int[]> ints = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if(interval[0] > record){
                ints.add(interval);
                record = interval[1];
                index++;
            }else {
                if(interval[1] > record){
                    ints.set(index,new int[]{ints.get(index)[0], interval[1]});
                    record = interval[1];
                }
                if(interval[0] < ints.get(index)[0]){
                    ints.set(index,new int[]{interval[0], interval[1]});
                    record = interval[1];
                }
            }
        }
        return ints.toArray(new int[ints.size()][]);
    }

}

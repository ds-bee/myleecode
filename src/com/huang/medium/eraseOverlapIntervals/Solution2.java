package com.huang.medium.eraseOverlapIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
    public static void main(String[] args) {

    }
    public static int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int record = intervals[0][1];
        int sum = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (record > intervals[i][0]) {
                sum++;
            }else {
                record = intervals[i][1];
            }
        }
        return sum;
    }
}

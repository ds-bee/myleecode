package com.huang.medium.reconstructQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int[][] arr = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] ints = reconstructQueue(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println();
            for (int i1 = 0; i1 < ints[i].length; i1++) {
                System.out.print(ints[i][i1]);
            }

        }
    }
    public static int[][] reconstructQueue(int[][] people) {
//        Comparator<int[]> comparator = Comparator.comparingInt(a ->a[1]);
//        Arrays.sort(people, comparator);
//        int[][] arr = people;
//        for (int i = 0; i < people.length; i++) {
//            int re1 = people[i][0];
//            int re2 = people[i][1];
//            for (int i1 = i; i1 < people.length; i1++) {
//                if()
//
//            }
//        }
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            //这里p是数组的第二个数
            que.add(p[1],p);
        }

        return que.toArray(new int[people.length][]);


    }
}

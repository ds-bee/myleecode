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
//        Comparator<int[]> comparator = Comparator.comparingInt(int[] a -> a[0]) ;
//        Arrays.sort(people, comparator);
//        Arrays.sort(people, (a, b) -> {
//            // 比较数组的第一个元素
//            int cmp = Integer.compare(a[0], b[0]);
//            if (cmp != 0) {
//                return cmp;
//            }
//            // 如果第一个元素相等，比较数组的第二个元素
//            return Integer.compare(a[1], b[1]);
//        });
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        LinkedList<int[]> list = new LinkedList<int[]>();
        for (int i = 0; i < people.length ; i++) {
            list.add(people[i][1], people[i]);
        }
        return list.toArray(new int[people.length][]);
//        不能够这么弄，而需要创建新的数组
//        int[][] objects = (int[][]) list.toArray();
//        return objects;

    }
}

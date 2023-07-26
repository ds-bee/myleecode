package com.huang.medium.canFinish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class solution {
    public static void main(String[] args) {
        int numCourses = 3;
//        int[][] prerequisites = {{1,0}};
//        int[][] prerequisites = {{0,1}};
//        int[][] prerequisites = {{0,1},{1,0}};
//        int[][] prerequisites = {{1,0},{0,1}};
//        int[][] prerequisites = {{1,0},{0,2},{2,1}};
        int[][] prerequisites = {{0,2},{2,1},{1,0}};
//        int[][] prerequisites = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
//        int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}};
//        int[][] prerequisites = {{}};
        System.out.println(canFinish(numCourses, prerequisites));

    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0){
            return true;
        }
        int record =0;
        HashMap<Integer,int[]> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            map.put( prerequisites[i][1],prerequisites[i]);
            set.add(prerequisites[i][1]);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            if(map.containsKey(prerequisites[i][0]) && set.contains(prerequisites[i][0])) {
                int j = i;
                while (map.containsKey(prerequisites[j][1])) {
                    if (map.get(prerequisites[j][0])[0] == prerequisites[i][1]) {
                        return false;
                    }
                    j = map.get(prerequisites[j][0])[0];
                    if(j > prerequisites.length - 1){
                        break;
                    }
                }
            }else {
                set.add(prerequisites[i][1]);
                record = record + 2;
            }
        }
//        if(record == numCourses){
//            return true;
//        }
        return true;
    }
}

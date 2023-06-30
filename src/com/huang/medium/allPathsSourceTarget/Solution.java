package com.huang.medium.allPathsSourceTarget;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        List<List<Integer>> lists = allPathsSourceTarget(graph);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println();
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j));
            }
        }
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < graph[0].length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            lists = find(lists,graph,0,i,list);
        }
        return lists;
    }

    public static List<List<Integer>> find(List<List<Integer>> lists,int[][] graph,int a,int b, List<Integer> list){
        if(graph[a][b] == graph.length - 1){
            list.add(graph[a][b]);
            lists.add(list);
            return lists;
        }
        for(int i = 0; i < graph[graph[a][b]].length; i++){
            int record = graph[graph[a][b]][i];
            list.add(record);
            if(record == graph.length-1){
                list.add(graph[a][b]);
//                list.add(record);
                lists.add(list);
                return lists;
            }else {
//                list.add(record);
                lists = find(lists,graph,record,i,list);
            }
            list.remove(list.size() - 1);
        }
        return null;
    }

}

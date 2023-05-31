package com.huang.medium.partitionLabels;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> list = partitionLabels(s);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
    public static List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        List<int[]> intlist = new ArrayList<>();
        HashMap<Character, int[]> characterHashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(!characterHashMap.containsKey(chars[i])){
                characterHashMap.put(chars[i],new int[] {i,i});
//                intlist.add(new int[] {i,0});
            }else {
                characterHashMap.put(chars[i],new int[] {characterHashMap.get(chars[i])[0],i});
            }
        }
        for(Map.Entry<Character,int[]> entry : characterHashMap.entrySet()){
            intlist.add(entry.getValue());
        }
//        intlist.sort(Comparator.comparing());
//        Collections.sort(intlist,new CustomComparator());
        int record = intlist.get(0)[1];
        int record1 = intlist.get(0)[1];
        for (int i = 1; i < intlist.size(); i++) {
            if(record < intlist.get(i)[0] && record1 > intlist.get(i)[1]){
                list.add(intlist.get(i)[0] );
                record = intlist.get(i)[1];
            }
            if(record1 < intlist.get(i)[1]){
                record1 = intlist.get(i)[1];
            }

        }
//        list.set(0,list.get(0) + intlist.get(0)[1]);
        return list;
    }

}
class CustomComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] arr1, int[] arr2) {
        // 根据数组的第二个数进行排序
        if (arr1[1] < arr2[1]) {
            return -1;
        } else if (arr1[1] > arr2[1]) {
            return 1;
        } else {
            return 0;
        }
    }
}
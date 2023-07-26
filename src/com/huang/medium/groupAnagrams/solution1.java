package com.huang.medium.groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class solution1 {
    public static void main(String[] args) {
//        String[] strs ={"eatt","teta","tan","ate","nat","bat"};
//        String[] strs ={"eat","eet","tee","ate","nat","bat"};
        String[] strs ={"eat","eet","tee"};
        System.out.println(groupAnagrams(strs));

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        boolean[] arr = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if(arr[i]){
                continue;
            }
            List<String> list = new ArrayList<>();
            for (int j = i; j < strs.length; j++) {
                if(judge(strs[i], strs[j])){
                    arr[i] = true;
                    arr[j] = true;
                    list.add(strs[j]);
                }
            }
            lists.add(new ArrayList<>(list));
        }
        return lists;
    }
    public static void find(List<List<String>> lists, List<String> list, String[] strs, int record, int start){
        if(record == strs.length ){
            list.add(strs[start]);
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < strs.length ; i++) {
            if (judge(strs[start], strs[record] )) {
                list.add(strs[record]);
//                record++;
            }
//            record =
            find(lists, list, strs,record + 1,start);
            if (judge(strs[start], strs[record] )) {
                list.remove(list.size() - 1);
//                record--;
            }
        }
    }
    public static boolean judge(String s1, String s2){
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if(!map.containsKey(s1.substring(i,i+1))){
                map.put(s1.substring(i, i+1),1);
            }else {
                map.put(s1.substring(i , i +1), map.get(s1.substring(i, i + 1)) + 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if(map.containsKey(s2.substring(i, i +1))){
                map.put(s2.substring(i , i +1), map.get(s2.substring(i, i + 1)) - 1);
            }else {
                return false;
            }
        }
        for(Map.Entry<String, Integer> item: map.entrySet()){
            if(item.getValue() != 0){
                return false;
            }
        }
        return true;
    }


}

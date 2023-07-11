package com.huang.medium.groupAnagrams;

import java.util.*;

public class solution {
    public static void main(String[] args) {
        String[] strs ={"eatt","teta","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
//        strs.length
        List<List<String>> arrs = new ArrayList<>();
        List<String> strarr = new ArrayList<>();
        find(arrs, strarr,strs,0, 0);
        return arrs;
    }
    public static void find(List<List<String>> arrs, List<String> strarr,String[] strs,int record, int start){
        if(record == strs.length - 1){
            arrs.add(new ArrayList<>(strarr));
            return;
        }
        for(int i = start; i < strs.length; i++){
//            str = strs[i];
//            strarr.add(strs[i]);
            if(judge(strs[start], strs[record])){
                strarr.add(strs[start]);
            }
            record++;
            find(arrs, strarr,strs,record, start );
            if(judge(strs[start], strs[i])){
                strarr.remove(strarr.size() - 1);
            }
            record--;
//            strarr.remove(strs.length - 1);
        }
    }
    public static boolean judge(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        HashMap<String, Integer> strmap1 = new HashMap<>();
        HashMap<String, Integer> strmap2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if(strmap1.get(s1.substring(i,i+1)) == null){
                strmap1.put(s1.substring(i,i+1), 1);
            }else {
                strmap1.put(s1.substring(i,i+1),strmap1.get(s1.substring(i,i+1)) + 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if(strmap2.get(s2.substring(i,i+1)) == null){
                strmap2.put(s2.substring(i,i+1), 1);
            }else {
                strmap2.put(s2.substring(i,i+1),strmap2.get(s2.substring(i,i+1)) + 1);
            }

        }
        for(Map.Entry<String, Integer> item:strmap1.entrySet()){
            if(!Objects.equals(item.getValue(), strmap2.get(item.getKey()))){
                return false;
            }

        }
        return true;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        // 创建一个空的 Map 对象
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        // 遍历字符串数组
        for (String str : strs) {
            // 将字符串转换为字符数组，并对字符数组进行排序
            char[] array = str.toCharArray();
            Arrays.sort(array);
            // 将排序后的字符数组转换为字符串作为 Map 的键
            String key = new String(array);
            // 如果 Map 中已经包含了该键，则将原始字符串添加到该键对应的值列表中
            // 否则，创建一个新的值列表，并将原始字符串添加到该列表中
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        // 将 Map 中的值列表转换为一个 List<List<String>> 类型的对象，并返回该对象
        return new ArrayList<List<String>>(map.values());
    }

}

package com.huang.easy.commonChars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[] list = {"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"};
        List<String> list1 = commonChars(list);
        for (String s : list1) {
            System.out.println(s);
        }

    }
    public static List<String> commonChars(String[] words) {
        HashMap<Character, Integer> sort1 = new HashMap<>();
        List<String> list = new ArrayList<>();

        char[] chars = words[0].toCharArray();
        for (char aChar : chars) {
            if (!sort1.containsKey(aChar)) {
                sort1.put(aChar, 1);
            } else {
                sort1.put(aChar, sort1.get(aChar) + 1);
            }
        }
        for (int i = 1; i < words.length; i++) {
            HashMap<Character, Integer> sort2 = new HashMap<>();
            char[] chars1 = words[i].toCharArray();
            for (char aChar : chars1) {
                if (!sort2.containsKey(aChar)) {
                    sort2.put(aChar, 1);
                } else {
                    sort2.put(aChar, sort1.get(aChar) + 1);
                }
            }

        }


        for (Map.Entry<Character, Integer> entry : sort1.entrySet()){
            int tem = entry.getValue()/ words.length;
            if(tem > 0){
                for (int i = 0; i < tem; i++) {
                    list.add((entry.getKey()).toString());
                }
            }

        }
        return list;
    }

}

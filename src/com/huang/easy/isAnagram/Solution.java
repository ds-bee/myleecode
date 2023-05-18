package com.huang.easy.isAnagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        String str = "anagram";
        String str1 = "nagaram";
        boolean anagram = isAnagram(str, str1);
        System.out.println(anagram);

    }

    public static boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        HashMap<Character, Integer> sort1 = new HashMap<>();
        HashMap<Character, Integer> sort2 = new HashMap<>();
        for (char aChar : chars) {
            if (!sort1.containsKey(aChar)) {
                sort1.put(aChar, 1);
            } else {
                sort1.put(aChar, sort1.get(aChar) + 1);
            }
        }
        for (char aChar1 : chars1) {
            if (!sort2.containsKey(aChar1)) {
                sort2.put(aChar1, 1);
            } else {
                sort2.put(aChar1, sort2.get(aChar1) + 1);
            }
        }
        if(sort1.size() != sort2.size()){
            return false;
        }
        for(Map.Entry<Character, Integer> entry : sort1.entrySet()){
            if(!sort2.containsKey(entry.getKey()) || !Objects.equals(sort2.get(entry.getKey()), entry.getValue())){
                return false;
            }
        }
        return true;
    }

}

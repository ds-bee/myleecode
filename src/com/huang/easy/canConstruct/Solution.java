package com.huang.easy.canConstruct;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
//        String a = "bg";
//        String b = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";
        String a = "a";
        String b = "b";
        boolean b1 = canConstruct(a, b);
        System.out.println(b1);
    }
    //这个题还是应该用hash原理来做
    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = ransomNote.toCharArray();
        char[] chars1 = magazine.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if(!map.containsKey(chars[i])){
                map.put(chars[i],1);
            }else {
                map.put(chars[i], map.get(chars[i]) + 1);
            }
        }
        for (int i = 0; i < chars1.length; i++) {
            if(!map1.containsKey(chars1[i])){
                map1.put(chars1[i],1);
            }else {
                map1.put(chars1[i], map1.get(chars1[i]) + 1);
            }
        }
//        Boolean flag = true;
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(map1.get(entry.getKey()) == null){
                return false;
            }else if (entry.getValue() > map1.get(entry.getKey()) ){
                return false;
            }
        }
        return true;

    }

}

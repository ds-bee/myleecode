package com.huang.medium.letterCombinations;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        String arr = "234";
        List<String> list1 = letterCombinations(arr);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));

        }

    }

    static List<String> stringList = new ArrayList<>();
    static List<String> list = new LinkedList<>();

    public static List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        if(chars.length == 0){
            return null;
        }

        HashMap<Character, char[]> characterListHashMap = new HashMap<>();
        characterListHashMap.put('2', new char[]{'a', 'b', 'c'});
        characterListHashMap.put('3', new char[]{'d', 'e', 'f'});
        characterListHashMap.put('4', new char[]{'g', 'h', 'i'});
        characterListHashMap.put('5', new char[]{'j', 'k', 'l'});
        characterListHashMap.put('6', new char[]{'m', 'n', 'o'});
        characterListHashMap.put('7', new char[]{'p', 'q', 'r', 's'});
        characterListHashMap.put('8', new char[]{'t', 'u', 'v'});
        characterListHashMap.put('9', new char[]{'w', 'x', 'y', 'z'});

        find(chars, characterListHashMap, 0,0);

        return stringList;

    }
    public static void find(char[] chars, HashMap<Character, char[]> characterListHashMap, int start, int record){
        if(record == chars.length ) {
            stringList.add(String.join( "",list));
            return;
        }
        char[] chars1 = characterListHashMap.get(chars[record]);
        for (int i = 0; i < chars1.length; i++) {
            list.add(String.valueOf(chars1[i]));
            find(chars, characterListHashMap, i,record+1);
            list.remove(list.size() - 1);
        }

    }

}

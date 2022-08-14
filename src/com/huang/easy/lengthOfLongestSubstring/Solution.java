package com.huang.easy.lengthOfLongestSubstring;

import javax.xml.ws.EndpointReference;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        String s = "abcabcbb";
        lengthOfLongestSubstring(s);

    }

    public static int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        int flag ;
        int tem = 0;
        Queue<Character> characters1 = new LinkedList<>();
        HashMap<Character, Integer> characterObjectHashMap = new HashMap<>();
        characterObjectHashMap.put(chars[0], (int) chars[0]);
        characters1.offer(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            characterObjectHashMap.put(chars[i], (int) chars[i]);
            System.out.println(characterObjectHashMap);
            characters1.offer(chars[i]);
            System.out.println(characters1);
            if (characterObjectHashMap.containsKey(chars[i])) {
                if(chars[i] == characters1.peek()) {
                    flag = 0;
                    for (int i1 = 0; i1 < characters1.size(); i1++) {
                        flag++;
                    }
                    if (flag > tem) {
                        tem = flag;
                        for (int i1 = 0; i1 < characters1.size(); i1++) {
                            flag++;
                            characters1.poll();
                        }
                    }
                }
            }
        }
        return tem;
    }

}
//public class MainClass {
//    public static String stringToString(String input) {
//        return JsonArray.readFrom("[" + input + "]").get(0).asString();
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            String s = stringToString(line);
//
//            int ret = new Solution().lengthOfLongestSubstring(s);
//
//            String out = String.valueOf(ret);
//
//            System.out.print(out);
//        }
//    }
//}
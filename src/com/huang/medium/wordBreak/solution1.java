package com.huang.medium.wordBreak;

import java.util.*;

public class solution1 {
    public static void main(String[] args) {
//        String s = "leetcode";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");

//        String s = "aaaaaaa";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("aa");
//        wordDict.add("aaaa");
//        wordDict.add("rs");
//        wordDict.add("bbb");

        String s = "catsandogcat";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        wordDict.add("an");
        System.out.println(wordBreak(s, wordDict));

    }
    public static boolean wordBreak(String s, List<String> wordDict) {
//        String substring = s.substring(0, 1);
        HashMap<String, List < String >> map = new HashMap<>();
        for (int i = 0; i < wordDict.size(); i++) {
            if(map.get(wordDict.get(i).substring(0, 1)) == null){
                List<String> list = new ArrayList<>();
                list.add(wordDict.get(i));
                map.put(wordDict.get(i).substring(0, 1),list);
            }else {
                List<String> list = map.get(wordDict.get(i).substring(0, 1));
                list.add(wordDict.get(i));
                map.put(wordDict.get(i).substring(0, 1),list);
            }
        }
        return find(map, s, 0) || flag1;
    }
    static boolean flag = true;
    static boolean flag1 = false;
    public static boolean find(HashMap<String, List < String >> map, String s, int start){
        if(start == s.length()){
            flag1 = true;
            return flag = true;
        }
        if(start > s.length()){
            return flag = false;
        }
//        for (int i = 0; i < s.length(); i++) {
//            String s1 = s.substring(i, i + 1);
//
//        }
        String s1 = s.substring(start, start + 1);
        List<String> list = map.get(s1);
        if(list == null){
            return flag = false;
        }else {
            for (int i = 0; i < list.size(); i++) {
                String s2 = list.get(i);
                for (int i1 = 0; i1 < s2.length(); i1++) {
                    if(i1 + 1 + start <= s.length()) {
                        if (s2.length() > s.length() || !s2.substring(i1, i1 + 1).equals(s.substring(i1 + start, i1 + 1 + start))) {
                            return flag = false;
                        }
                    }
                    else {
                        return flag = false;
                    }
                }
                if (find(map, s, start + s2.length())) {
                    return flag;
                }
            }
        }
        return flag;
    }

    /**
     * 动态规划
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String word : wordDict) set.add(word);
        int n = s.length();
        boolean[] f = new boolean[n + 10];
        f[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i && !f[i]; j++) {
                String sub = s.substring(j - 1, i);
                if (set.contains(sub)) f[i] = f[j - 1];
            }
        }
        return f[n];
    }
    boolean[] mem;
    public boolean backtrack(String s, int start, Set<String> set) {
        if (s.length() == 0) return true;
        if (mem[start]) return false;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.substring(0, i + 1))){
                if (backtrack(s.substring(i + 1), start + i + 1, set)) return true;
            }
        }
        mem[start] = true;
        return false;
    }
    public boolean wordBreak2(String s, List<String> wordDict) {
        this.mem = new boolean[s.length()];
        Set<String> set = new HashSet<>(wordDict);
        return backtrack(s, 0, set);
    }

}

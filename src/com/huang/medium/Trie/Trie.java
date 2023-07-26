package com.huang.medium.Trie;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("rental");
//        trie.insert("rest");
//        trie.insert("app");
        System.out.println(trie.startsWith("rest"));
    }
    HashMap<String, String> map;
    HashMap<String, ArrayList<String>> mappre;
    public Trie() {
        map = new HashMap<String, String>();
        mappre = new HashMap<String, ArrayList<String>>();
    }
    public void insert(String word) {
        map.put(word,word.substring(0,1));
        if(mappre.containsKey(word.substring(0,1))){
            mappre.get(word.substring(0,1)).add(word);
        }else {
            ArrayList<String> strings = new ArrayList<>();
            strings.add(word);
            mappre.put(word.substring(0,1),strings);
        }
    }

    public boolean search(String word) {
        if(map.containsKey(word)){
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        boolean flag = false;
        if(mappre.containsKey(prefix.substring(0,1))){
            ArrayList<String> strings = mappre.get(prefix.substring(0, 1));
            for (int i = 0; i < strings.size(); i++) {
                if(prefix.length()>strings.get(i).length()){
                    flag = false;
                    continue;
                }
                for (int j = 0; j < prefix.length(); j++) {
                    flag = true;
                    if(!prefix.substring(j, j + 1).equals(strings.get(i).substring(j, j + 1))){
                        flag =  false;
                        break;
                    }
                }
                if(flag ){
                    break;
                }
            }

        }
        return flag;
    }

}

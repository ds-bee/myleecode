package com.huang.easy.findContentChildren;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};
        int contentChildren = findContentChildren(g, s);
        System.out.println(contentChildren);


    }
    public static int findContentChildren(int[] g, int[] s) {
        int recordg = g.length - 1;
        int record = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = s.length - 1; i >= 0; i--) {
            while (recordg >= 0){
                if(s[i] >= g[recordg]){
                    record++;
                    recordg--;
                    break;
                }
                recordg--;
            }
        }
        return record;
    }
}

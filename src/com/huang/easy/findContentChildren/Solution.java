package com.huang.easy.findContentChildren;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
//        int[] ints = {1,2,3};
//        int[] ints1 = {1,1};
        int[] ints = {10,9,8,7};
        int[] ints1 = {5,6,7,8};
        System.out.println(findContentChildren(ints, ints1));
    }

    public static int findContentChildren(int[] g, int[] s) {
        sort(g,0, g.length-1);
        sort(s,0, s.length-1);
        Arrays.sort(g);
        int first = g.length -1;
        int second = s.length-1;
        int count = 0;
        while (first>= 0 && second >= 0) {
            if (s[second ] >= g[first ]) {
                count++;
                first--;
                second--;
            }else {
                first--;
            }
        }

        return count;
    }
    public static void sort(int[] array,int start,int end){
        if(start>=end){
            return;
        }
        int i = start;
        int j = end;
        int mid = array[start];
        while(i<j){
            while(i<j&&array[j]>mid){
                j--;
            }
            if(i<j){
                array[i] = array[j];
                array[j] = mid;
            }
            while(i<j&&array[i]<=mid){
                i++;
            }
            if(i<j){
                array[j] = array[i];
                array[i] = mid;
            }
        }
        sort(array,start,i-1);
        sort(array,i+1,end);
    }
}

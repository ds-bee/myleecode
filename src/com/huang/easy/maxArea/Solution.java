package com.huang.easy.maxArea;

public class Solution {
    public static void main(String[] args) {
//        int[] arr = {1,8,6,2,5,4,8,25,7};
//        int[] arr = {1,8,6,2,5,4,8,3,7};
        int[] arr = {1,1};
        System.out.println(Math.min(1, 1));
        System.out.println(maxArea(arr));

    }

    public static int maxArea(int[] height) {
        int first,second,tem = 0;
        for (int i = 0; i < height.length; i++) {
            first = height[i];
            while ((i + 1) >= height.length || first >= height[i + 1]) {
                i++;
            }
            for (int j = height.length - 1; j > i ; j--) {
                second = height[j];
                tem = Math.max((Math.min(first ,second) * (j-i)),tem);
                if(j > i + 1 && second > height[j ]){
                    j--;
                }
            }
        }
        return tem;
    }

}

package com.huang.hard.maxSlidingWindow.candy;

public class Solution {
    public static int candy(int[] ratings) {

        int record1 = 1;
        int recordrise = 1;

        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i - 1] > ratings[i]){
                recordrise++;
            }else {
                for (int i1 = 0; i1 <= recordrise ; i1++) {
                    record1 = record1 + i1;
                }
                recordrise = 1;
            }

        }
    }
}

package com.huang.hard.maxSlidingWindow.candy;

public class Solution {
    public static void main(String[] args) {
//        int[] ratings = {3,2,1,2,3};
//        int[] ratings = {1,2,2};
        int[] ratings = {1,0,2};
        System.out.println(candy(ratings));

    }
    public static int candy(int[] ratings) {

        int record1 = 0;
        int recordrise = 1;
        int recorddown = 1;
        int flag = 0;
        int record2 = 0;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] > ratings[i]) {
                recorddown++;
            } else if (ratings[i - 1] < ratings[i]) {
                recordrise++;
            } else {
                record1 = record1 + 1;
                recordrise = 1;
                recorddown = 1;
            }
            if (recordrise != 1) {
                while (recordrise > 0) {
                    record1 = record1 + recordrise + 1;
                    recordrise--;
                }
//                record1  = record1 + recorddown;
//                recordrise = 1;
                flag++;
            }
            if (recorddown != 1) {
                while (recorddown > 0) {
                    record1 = record1 + recorddown + 1;
                    recorddown--;
                }
//                record1 = record1 + recordrise;
//                recorddown = 1;
                flag++;
            }
        }
        record1 = record1 - flag;
        return record1;
    }
}

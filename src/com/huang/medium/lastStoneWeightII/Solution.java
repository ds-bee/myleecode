package com.huang.medium.lastStoneWeightII;

import java.util.ArrayList;

public class Solution {
    public int lastStoneWeightII(int[] stones) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < stones.length; i++) {
            list.add(stones[i]);
        }

        int[] dp = new int[stones.length];
        int record = 0;
        int lengthrecord = stones.length;
        for (int i = 0; i < stones.length; i++) {

            for (int j = lengthrecord - record; j > 0; j = j - record) {
                int x = 0;
                int y = 0;

                record = 0;
                if(x != y){
                    record++;
                }
                if(x == y){
                    record = record + 2;
                }
//                lengthrecord = lengthrecord - record;
            }

        }
        return 0;
    }

}

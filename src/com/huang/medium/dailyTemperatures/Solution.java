package com.huang.medium.dailyTemperatures;

public class Solution {
    public static void main(String[] args) {

    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] record = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i; j < temperatures.length; j++) {
                if(temperatures[j] > temperatures[i] ){
                    record[i] = j - i;
                    break;
                }
            }
        }
        return record;
    }

    public int[] dailyTemperatures1(int[] temperatures) {
        int[] record = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i; j < temperatures.length; j++) {
                if(temperatures[j] > temperatures[i] ){
                    record[i] = j - i;
                    break;
                }
            }
        }
        return record;
    }

}

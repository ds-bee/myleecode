package com.huang.medium.maxProfit;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));

    }
    public static int maxProfit(int[] prices) {
        int sum = 0;
        int pre = 0;
        int cur = 0;
        boolean flag = false;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]){
                pre = prices[i] - prices[i - 1];
                flag = true;
            }else {
                flag = false;
            }
            if(flag){
                sum = sum + pre;
            }
        }
        return sum;
    }

}

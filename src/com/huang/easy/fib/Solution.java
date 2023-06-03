package com.huang.easy.fib;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(n));
    }
    public static int fib(int n) {
        return find(5);
    }
    public static int find(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return find(n - 1)  +find(n - 2);
    }



}

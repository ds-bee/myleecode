package com.huang.exam;

import java.util.Arrays;
import java.util.Scanner;

public class main1 {
//    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
//        int t = 1; // 询问次数
//
//        for (int i = 0; i < t; i++) {
//            int n = 6; // 数组大小
//            int x = 10; // 修改成的元素
//            int[] arr = {4 ,-2 ,-11, -1, 4 ,-1 }; // 输入的数组
//
//            // 读取数组
////            for (int j = 0; j < n; j++) {
////                arr[j] = scanner.nextInt();
////            }
//
//            // 输出最大和的连续子数组
//            System.out.println(getMaxContinuousSum(n, x, arr));
//        }
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            long[] dp = new long[n];
            long[] dp2 = new long[n];
            dp[0] = arr[0];
            dp2[0] = x;

            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
                dp2[i] = Math.max(dp2[i - 1] + x, dp[i - 1] + arr[i]);
            }

            long maxSum = 0;
            for (int i = 0; i < n; i++) {
                maxSum = Math.max(maxSum, Math.max(dp[i], dp2[i]));
            }

            System.out.println(maxSum);
        }
    }


    public static long getMaxContinuousSum(int n, int x, int[] arr) {
        long maxSum = Long.MIN_VALUE;

        // Try all possible modifications and find the maximum sum
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long currentSum = 0;

                // Modify the selected elements and calculate the sum of the modified subarray
                for (int k = 0; k < n; k++) {
                    if (k >= i && k <= j) {
                        currentSum += x;
                    } else {
                        currentSum += arr[k];
                    }
                }
                // Update the maximum sum if needed
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }


}

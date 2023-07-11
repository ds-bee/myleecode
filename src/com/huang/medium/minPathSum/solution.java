package com.huang.medium.minPathSum;

public class solution {
    public static void main(String[] args) {
        int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(arr));

    }
    public static int minPathSum(int[][] grid) {

        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(j == 0 ){
                    dp[j] = dp[j] + grid[i][j];
                }
                if(j > 0){
                    dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[grid[0].length - 1];

    }

}

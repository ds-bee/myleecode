package com.huang.medium.uniquePathsWithObstacles;

public class Solution {
    public static void main(String[] args) {
//        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] obstacleGrid = {{0,0},{1,1},{0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));

    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + dp[0][i];
            if(obstacleGrid[0][i] == 1){
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i][0];
            if(obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

}

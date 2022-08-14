package com.huang.easy.minPathSum;

public class Solution {

    static int tem = 0;

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));

    }

    public static int minPathSum(int[][] grid) {

        int m = 0,n = 0 ;
        int just = just(m, n, grid);
        return just;

    }

    public static int just(int m,int n, int[][] grid){
//        if(m == grid.length-1  && n == grid[0].length){
//            return grid[m][n];
//        }
//        if(m == grid.length-1  && n < grid[0].length ){
//            return grid[m][n] + just(m ,n + 1,grid);
//        }
//        if(n == grid[0].length-1  && m < grid.length ){
//            return grid[m][n] + just(m + 1,n,grid);
//        }
        if(m < grid.length-1  && n < grid[0].length ){
            if(grid[m + 1][n] < grid[m][n + 1]){
                return grid[m][n] + just(m + 1,n,grid);

            }else {
                return grid[m][n] + just(m ,n + 1,grid);
            }
        }else if(m == grid.length-1  && n < grid[0].length){
            return grid[m][n] + just(m ,n + 1,grid);
        }else if(n == grid[0].length-1  && m < grid.length ){
            return grid[m][n] + just(m + 1,n,grid);
        }else {
            return grid[m][n];
        }

    }

}

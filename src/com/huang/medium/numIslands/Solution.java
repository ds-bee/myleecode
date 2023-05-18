package com.huang.medium.numIslands;

public class Solution {
    public static void main(String[] args) {
//        char[][] chars = {{1,1,1,1,0},
//                {1,1,0,1,0},
//                {1,1,0,0,0},
//                {0,0,0,0,0},
//        };
//        char[][] chars = {{1,1,0,0,0},
//                {1,1,0,0,0},
//                {0,0,1,0,0},
//                {0,0,0,1,1},
//        };
        char[][] chars = {{1,1,1},
                {0,1,0},
                {1,1,1},
        };
        System.out.println(numIslands(chars));
//        boolean[][] booleans = {{1,2,3},{1,2,3},{1,2,3}};
//        System.out.println(booleans[0][0]);
    }
    public static int numIslands(char[][] grid) {
        int length = grid.length;
        int wide = grid[0].length;
        int record =0;
        boolean[][] booleans = new boolean[length][wide];
        for (int i1 = 0; i1 < grid.length; i1++) {
            for (int i2 = 0; i2 < grid[0].length; i2++) {

                if(grid[i1][i2] == 1 && !booleans[i1][i2]){
                    findOne(grid,i1,i2,booleans);
                    record++;
                }
            }
        }

        return record;
    }
    public static void findOne(char[][] grid, int i ,int b,boolean[][] booleans){
//        for (int i1 = i; i1 < grid.length; i1++) {
//
//            for (int i2 = b; i2 < grid[0].length; i2++) {
//
//            }
//        }
        booleans[i][b] = true;
        if(i == grid.length || b == grid[0].length || grid[i][b] == 0){
            return;
        }
        if(i + 1 < grid.length ){
//            booleans[i + 1][b] = true;
            findOne( grid,  i + 1 , b, booleans);
        }
        if(b + 1 < grid[0].length){
//            booleans[i ][b + 1] = true;
            findOne( grid,  i  , b + 1, booleans);
        }
        if(i - 1 > 0 ){
//            booleans[i + 1][b] = true;
            findOne( grid,  i - 1 , b, booleans);
        }
        if(b - 1 > 0){
//            booleans[i ][b + 1] = true;
            findOne( grid,  i  , b - 1, booleans);
        }
    }

}

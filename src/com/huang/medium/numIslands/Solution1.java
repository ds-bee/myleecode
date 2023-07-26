package com.huang.medium.numIslands;

public class Solution1 {
    public static void main(String[] args) {
//        [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]

            char[][] chars = {
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,1,0,0,0},
                {0,0,0,0,0},
        };
//        char[][] chars = {{1,1,0,0,0},
//                {1,1,0,0,0},
//                {0,0,1,0,0},
//                {0,0,0,1,1},
//        };
//        char[][] chars = {{1,1,1},
//                {0,1,0},
//                {1,1,1},
//        };
        System.out.println(numIslands(chars));

    }

    public static int numIslands(char[][] grid) {

//        Boolean[][] judge = new Boolean[grid[0].length+ 2][grid.length+ 2];
//        char[][] grid1 =  new char[grid[0].length + 2][grid.length + 2];

        boolean[][] judge = new boolean[grid.length][grid[0].length];
        int record = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && judge[i][j] == false){
                    find(judge,grid,i,j);
                    record++;
                }
            }
        }
        return record;
    }

    public static void find(boolean[][] judge, char[][] grid,int i ,int j){
        if(i == grid.length  || j == grid[0].length  || grid[i][j] == 0 || judge[i][j] == true){
            return;
        }
        if(grid[i][j] == 1){
            judge[i][j] = true;
        }
        if(j+1 < grid[0].length&& judge[i][j  + 1] == false ){
            find(judge,grid,i,j+1);
        }
        if(i+1 < grid.length&& judge[i+ 1 ][j  ] == false){
            find(judge,grid,i+1,j);
        }
        if(j-1 >= 0 && judge[i][j  - 1] == false){
            find(judge,grid,i,j-1);
        }
        if(i-1 >= 0 && judge[i-1][j] == false){
            find(judge,grid,i-1,j);
        }
    }
//    public static void find(Boolean[][] judge, char[][] grid,int i ,int j){
//        if(grid[i][j] == '0'){
//            return;
//        }
//        judge[i][j] = true;
//        if(i==0 && ){
//
//        }
//        if(!judge[i + 1][j]){
//            find(judge,grid,i+1,j);
//        }
//        if(!judge[i + 1][j+1]){
//            find(judge,grid,i+1,j+1);
//        }
//        if(i>0&&!judge[i - 1][j]){
//            find(judge,grid,i+1,j+1);
//        }
//        if(j>0&&!judge[i ][j-1]){
//            find(judge,grid,i+1,j+1);
//        }
//        if(!judge[i + 1][j+1]){
//            find(judge,grid,i+1,j+1);
//        }
//        if(!judge[i + 1][j+1]){
//            find(judge,grid,i+1,j+1);
//        }
//
//        find(judge,grid,i+1,j+1);
//        find(judge,grid,i-1,j);
//
//    }

}

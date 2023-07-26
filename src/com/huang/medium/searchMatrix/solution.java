package com.huang.medium.searchMatrix;

public class solution {
    public static void main(String[] args) {
        int[][] arr = {{1,4,7,11,15},
                        {2,5,8,12,19},
                        {3,6,9,16,22},
                        {10,13,14,17,24},
                        {18,21,23,26,30},
        };
//        int[][] arr = {{-5}};
        int num = 70;
        System.out.println(searchMatrix(arr, num));

    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int w = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] > target){
                break;
            }
            l = i;
        }
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][l] == target){
                return true;
            }
            if(matrix[i][l] < target){
                continue;
            }
            int tem = 0;
            while (l - tem > 0){
                if(matrix[i][l-tem-1] <target){
                    break;
                }
                if(matrix[i][l-tem-1] == target){
                    return true;
                }
                tem++;
            }

        }
        return false;

    }
}

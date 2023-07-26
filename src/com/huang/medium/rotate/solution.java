package com.huang.medium.rotate;

public class solution {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] arr = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }

        }
    }
    public static void rotate(int[][] matrix) {
        int len = matrix.length - 1;
        for (int i = 0; i < matrix[0].length /2 + matrix[0].length %2; i++) {
//            int a = i;
            for (int j = i; j < matrix.length- i - 1; j++) {
                int tem = matrix[j][len-i];
                matrix[j][len-i] = matrix[i][j];
//                matrix[i][j] = matrix[j][len-i];
                int tem1 = matrix[len-i][len-j];
                matrix[len-i][len-j] = tem;

                tem = matrix[len-j][i];
                matrix[len-j][i] = tem1;

                matrix[i][j] = tem;
            }
        }

    }

}

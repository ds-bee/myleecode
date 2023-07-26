package com.huang.medium.maximalSquare;

public class solution {
    public static void main(String[] args) {
//        char[][] matrix = {{'1','0'},{'0','1'}};
// String[][] matrix ={{"0","0","0","1","0","1","1","1"}
//                    ,{"0","1","1","0","0","1","0","1"}
//                    ,{"1","0","1","1","1","1","0","1"}
//                    ,{"0","0","0","1","0","0","0","0"}
//                    ,{"0","0","1","0","0","0","1","0"}
//                    ,{"1","1","1","0","0","1","1","1"}
//                    ,{"1","0","0","1","1","0","0","1"}
//                    ,{"0","1","0","0","1","1","0","0"}
//                    ,{"1","0","0","1","0","0","0","0"}
//        };
        String[][] matrix ={{"1","1","1"}
                            ,{"1","0","1"}
                            ,{"1","0","1"}
        };
        System.out.println(maximalSquare(matrix));

    }
    public static int maximalSquare(String[][] matrix) {
        int recordlen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == "1" && i+recordlen<matrix.length && j +recordlen<matrix[0].length){
                    int tem = find(matrix, i, j);
                    if(tem > recordlen){
                        recordlen = tem;
                    }

                }
                j = j + recordlen;
            }
            i = i + recordlen;
        }
        return recordlen * recordlen;
    }
    public static int find(String[][] matrix, int i, int j){
        int record = 1;
        while (i + record < matrix.length&&j+record < matrix[0].length){
            for(int a = j; a < j+record; a++){
                if(matrix[i + record][a] != "1"){
                    return record;
                }
            }
            for(int a = i; a < i+record; a++){
                if(matrix[a][j + record] != "1"){
                    return record;
                }
            }
            if(matrix[i+record][j+record] != "1"){
                return record;
            }
            record++;
        }
        return record;
    }
}

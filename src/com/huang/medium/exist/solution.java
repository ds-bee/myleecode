package com.huang.medium.exist;

public class solution {
    static boolean flag = false;
    public static void main(String[] args) {
//        char[][] board = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
//        String s = "abcced";
//        char[][] board = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
//        String s = "abcb";
        char[][] board = {{'a','b'}};
        String s = "ba";
        System.out.println(exist(board, s));

    }

    public static boolean exist(char[][] board, String word) {
//        boolean[][] booleans = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int record = 0;
                boolean[][] booleans = new boolean[board.length][board[0].length];
                if(board[i][j] == word.charAt(0)) {
                    booleans[i][j] = true;
                    find(board, word, i, j, record,booleans);
                    booleans[i][j] = false;
                    if(flag){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void find(char[][] board, String word,int i, int j,int record, boolean[][] booleans){
        if(record == word.length()-1){
            flag = true;
            return ;
        }
//        if(i == 0 && ){
//
//        }

        if(i + 1 < board.length && !booleans[i + 1][j]){
            if(board[i + 1][j] == word.charAt(record+1)){
                booleans[i + 1][j] = true;
                find(board, word, i + 1, j, record+1,booleans);
                booleans[i + 1][j] = false;
            }
        }
        if(i  > 0){
            if(board[i - 1][j] == word.charAt(record+1) && !booleans[i - 1][j]){
                booleans[i - 1][j] = true;
                find(board, word, i - 1, j, record+1,booleans);
                booleans[i - 1][j] = false;
            }
        }
        if(j + 1 < board[0].length && !booleans[i][j + 1]){
            if(board[i][j + 1] == word.charAt(record+1)){
                booleans[i][j + 1] = true;
                find(board, word, i , j + 1, record+1,booleans);
                booleans[i][j + 1] = false;
            }
        }
        if(j  > 0){
            if(board[i][j - 1]== word.charAt(record+1) && !booleans[i][j - 1]){
                booleans[i][j - 1] = true;
                find(board, word, i , j - 1, record+1,booleans);
                booleans[i][j - 1] = false;
            }
        }
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

}

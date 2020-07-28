package leetcode.wyj;

import java.util.HashSet;
import java.util.Set;

public class LeetCode36 {
    public static void main(String[] args) {
        char[][] a = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        isValidSudoku(a);
    }

    public static boolean isValidSudoku(char[][] board) {


        //判断列是否重复

        for (int i = 0; i < board.length; i++) {
            //行
            Set<Character> lineSet = new HashSet<>();
            //列
            Set<Character> rowSet = new HashSet<>();
            //
            Set<Character> childSet = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (lineSet.contains(board[i][j])) {
                        return false;
                    }
                    lineSet.add(board[i][j]);
                }

                if (board[j][i] != '.') {
                    if (rowSet.contains(board[j][i])) {
                        return false;
                    }
                    rowSet.add(board[j][i]);
                }

                if (board[i - i % 3 + j / 3][j / 3] != '.') {
                    if (rowSet.contains(board[j][i])) {
                        return false;
                    }
                    childSet.add(board[j][i]);
                }
            }
        }

        for (int i = 0; i < 7; i += 3) {
            for (int j = 0; j < 7; j += 3) {
                //列
                Set<Character> set = new HashSet<>();
                for (int n = i; n < i + 3; n++) {
                    for (int m = j; m < j + 3; m++) {
                        if (board[m][n] != '.') {
                            if (set.contains(board[m][n])) {
                                return false;
                            }
                            set.add(board[m][n]);
                        }
                    }
                }
            }
        }


        return true;

    }
}

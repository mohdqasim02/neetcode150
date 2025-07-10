package arrays.validsudoku;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> columnSet = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                char rowChar = board[i][j];
                char columnChar = board[j][i];

                if (rowChar != '.' && rowSet.contains(rowChar)) return false;
                rowSet.add(rowChar);

                if (columnChar != '.' && columnSet.contains(columnChar)) return false;
                columnSet.add(columnChar);
            }
        }

        HashMap<String, HashSet<Character>> squares = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                char currentChar = board[r][c];
                String squareKey = (r / 3) + "," + (c / 3);

                if (currentChar == '.') continue;

                if (squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(currentChar)) return false;
                squares.get(squareKey).add(currentChar);
            }
        }

        return true;
    }
}


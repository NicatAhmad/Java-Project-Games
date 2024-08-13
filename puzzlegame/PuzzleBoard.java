
package puzzlegame;

import java.util.Arrays;
import java.util.Collections;

public class PuzzleBoard {
    private PuzzlePiece[][] board;
    private int emptyRow, emptyCol; // Boş karenin konumu

    public PuzzleBoard(int size) {
        board = new PuzzlePiece[size][size];
        Integer[] values = new Integer[size * size];
        for (int i = 0; i < size * size; i++) {
            values[i] = i;
        }
        Collections.shuffle(Arrays.asList(values)); // Parçaları karıştır

        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new PuzzlePiece(values[index]);
                if (values[index] == 0) {
                    emptyRow = i;
                    emptyCol = j;
                }
                index++;
            }
        }
    }

    public boolean move(int row, int col) {
        if (Math.abs(emptyRow - row) + Math.abs(emptyCol - col) == 1) {
            board[emptyRow][emptyCol] = board[row][col];
            board[row][col] = new PuzzlePiece(0);
            emptyRow = row;
            emptyCol = col;
            return true;
        }
        return false;
    }

    public boolean isSolved() {
        int value = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i == board.length - 1 && j == board.length - 1) {
                    return board[i][j].getValue() == 0;
                }
                if (board[i][j].getValue() != value) {
                    return false;
                }
                value++;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PuzzlePiece[] row : board) {
            for (PuzzlePiece piece : row) {
                sb.append(piece).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

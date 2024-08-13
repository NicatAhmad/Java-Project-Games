
package puzzlegame;

import java.util.Scanner;

public class PuzzleGame {
    private PuzzleBoard board;

    public PuzzleGame(int size) {
        board = new PuzzleBoard(size);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (!board.isSolved()) {
            System.out.println(board);
            System.out.print("Taşıma yapmak istediğiniz parçanın satır ve sütun numarasını girin (örnek: 2 1): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (!board.move(row, col)) {
                System.out.println("Geçersiz hamle! Lütfen tekrar deneyin.");
            }
        }

        System.out.println("Tebrikler! Bulmacayı çözdünüz.");
        scanner.close();
    }

    public static void main(String[] args) {
        PuzzleGame game = new PuzzleGame(3); // 3x3 boyutunda bir bulmaca
        game.play();
    }
}
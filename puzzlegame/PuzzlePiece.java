
package puzzlegame;


public class PuzzlePiece {
    private int value;

    public PuzzlePiece(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value == 0 ? " " : Integer.toString(value);
    }
}

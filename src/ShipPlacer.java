import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShipPlacer {
    Random rand = new Random();

    public void placeShips(Board board, int[] shipSizes) {
        for (int size : shipSizes) {
            boolean placed = false;
            while (!placed) {
                boolean horizontal = rand.nextBoolean();
                int row = rand.nextInt(10);
                int col = rand.nextInt(10);

                if (canPlace(board, row, col, size, horizontal)) {
                    place(board, row, col, size, horizontal);
                    placed = true;
                }
            }
        }
    }

    private boolean canPlace(Board board, int row, int col, int size, boolean horizontal) {
        if (horizontal && col + size > 10) return false;
        if (!horizontal && row + size > 10) return false;

        for (int i = 0; i < size; i++) {
            int r = row + (horizontal ? 0 : i);
            int c = col + (horizontal ? i : 0);
            if (board.getCell(r, c).isOccupied()) return false;
        }
        return true;
    }

    private void place(Board board, int row, int col, int size, boolean horizontal) {
        Ship ship = new Ship(size);
        List<int[]> positions = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int r = row + (horizontal ? 0 : i);
            int c = col + (horizontal ? i : 0);
            positions.add(new int[]{r, c});
        }

        board.addShip(ship, positions.toArray(new int[0][0]));
    }
}

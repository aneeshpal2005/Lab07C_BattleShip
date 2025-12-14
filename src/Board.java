import java.util.ArrayList;
import java.util.List;

public class Board {
    Cell[][] grid = new Cell[10][10];
    List<Ship> ships = new ArrayList<>();
    ShipPlacer placer = new ShipPlacer();

    public Board() {
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                grid[r][c] = new Cell();
            }
        }
        placeShips();
    }

    public void placeShips() {
        ships.clear();
        placer.placeShips(this, new int[]{5, 4, 3, 3, 2});
    }

    public boolean isHit(int row, int col) {
        return grid[row][col].isOccupied();
    }

    public void markHit(int row, int col) {
        grid[row][col].markHit();
    }

    public void markMiss(int row, int col) {
        grid[row][col].markMiss();
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public boolean isShipSunk(int row, int col) {
        Cell cell = grid[row][col];
        if (cell.getShip() != null) {
            return cell.getShip().isSunk();
        }
        return false;
    }

    public boolean allShipsSunk() {
        for (Ship s : ships) {
            if (!s.isSunk()) return false;
        }
        return true;
    }

    public void addShip(Ship ship, int[][] positions) {
        ships.add(ship);
        ship.setPositions(positions);
        for (int[] pos : positions) {
            int r = pos[0], c = pos[1];
            grid[r][c].setOccupied(true, ship);
        }
    }

    public void reset() {
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                grid[r][c].reset();
            }
        }
        ships.clear();
        placeShips();
    }

    public List<Ship> getShips() {
        return ships;
    }

    public boolean verifyNoOverlaps() {
        int occupiedCount = 0;
        for (int r = 0; r < 10; r++)
            for (int c = 0; c < 10; c++)
                if (grid[r][c].isOccupied()) occupiedCount++;
        return occupiedCount == 17;
    }
}

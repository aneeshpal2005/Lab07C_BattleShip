public class Ship {
    int length;
    int hitCount = 0;
    boolean sunk = false;

    private int[][] positions;

    public Ship(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void addHit() {
        hitCount++;
        if (hitCount >= length) sunk = true;
    }

    public boolean isSunk() {
        return sunk;
    }

    public void setPositions(int[][] pos) {
        this.positions = pos;
    }

    public int[][] getPositions() {
        return positions;
    }

    public void reset() {
        hitCount = 0;
        sunk = false;
    }
}

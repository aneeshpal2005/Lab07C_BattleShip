public class Cell {
    boolean occupied;
    boolean hit;
    Ship ship;

    public Cell() {
        this.occupied = false;
        this.hit = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied, Ship ship) {
        this.occupied = occupied;
        this.ship = ship;
    }

    public boolean isHit() {
        return hit;
    }

    public void markHit() {
        this.hit = true;
        if (ship != null) ship.addHit();
    }

    public void markMiss() {
        this.hit = true;
    }

    public Ship getShip() {
        return ship;
    }

    public void reset() {
        this.occupied = false;
        this.hit = false;
        this.ship = null;
    }
}

public class GameStats {
    int missCount = 0;
    int strikeCount = 0;
    int totalMisses = 0;
    int totalHits = 0;

    public void addMiss() {
        missCount++;
        totalMisses++;
        if (missCount >= 5) {
            strikeCount++;
            missCount = 0;
        }
    }

    public void addHit() {
        totalHits++;
        missCount = 0; // reset streak
    }

    public void reset() {
        missCount = 0;
        strikeCount = 0;
        totalMisses = 0;
        totalHits = 0;
    }

    public int getMissCount() {
        return missCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getTotalMisses() {
        return totalMisses;
    }

    public int getTotalHits() {
        return totalHits;
    }
}

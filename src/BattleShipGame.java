import javax.swing.*;
import java.awt.*;

public class BattleShipGame {
    Board board = new Board();
    GameStats stats = new GameStats();
    BattleShipGUI gui;

    public BattleShipGame(BattleShipGUI gui) {
        this.gui = gui;
    }

    public void cellClick(int row, int col) {
        if (board.isHit(row, col)) {
            board.markHit(row, col);
            stats.addHit();
            gui.updateButton(row, col, "X", Color.RED);
            gui.updateStatus(stats.getMissCount(), stats.getStrikeCount(),
                    stats.getTotalMisses(), stats.getTotalHits());
            if (board.isShipSunk(row, col)) gui.showMessage("You sunk a ship!");
            if (board.allShipsSunk()) {
                gui.showMessage("Congratulations! You win!");
                resetGame();
            }
        } else {
            board.markMiss(row, col);
            stats.addMiss();
            gui.updateButton(row, col, "M", Color.YELLOW);
            gui.updateStatus(stats.getMissCount(), stats.getStrikeCount(),
                    stats.getTotalMisses(), stats.getTotalHits());
            if (stats.getStrikeCount() >= 3) {
                gui.showMessage("Game Over! You lose!");
                resetGame();
            }
        }
    }

    public void resetGame() {
        board.reset();
        stats.reset();
        gui.dispose();
        new BattleShipGUI();
    }
}

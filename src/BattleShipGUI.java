import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BattleShipGUI extends JFrame {
    JButton[][] buttons = new JButton[10][10];
    JLabel missLabel = new JLabel("Miss Counter: 0");
    JLabel strikeLabel = new JLabel("Strike Counter: 0");
    JLabel totalMissLabel = new JLabel("Total Misses: 0");
    JLabel totalHitLabel = new JLabel("Total Hits: 0");
    BattleShipGame game = new BattleShipGame(this);

    public BattleShipGUI() {
        super("Single Player Battleship");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(10, 10));
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                JButton btn = new JButton("~");
                btn.setBackground(Color.CYAN);
                btn.setFont(new Font("Arial", Font.BOLD, 16));
                int row = r, col = c;
                btn.addActionListener((ActionEvent e) -> game.cellClick(row, col));
                buttons[r][c] = btn;
                gridPanel.add(btn);
            }
        }

        JPanel statusPanel = new JPanel(new GridLayout(2, 2));
        statusPanel.add(missLabel);
        statusPanel.add(strikeLabel);
        statusPanel.add(totalMissLabel);
        statusPanel.add(totalHitLabel);

        JPanel controlPanel = new JPanel();
        JButton playAgain = new JButton("Play Again");
        playAgain.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to play again?");
            if (choice == JOptionPane.YES_OPTION) game.resetGame();
        });
        JButton quit = new JButton("Quit");
        quit.addActionListener(e -> System.exit(0));
        controlPanel.add(playAgain);
        controlPanel.add(quit);

        add(gridPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setSize(500,500);
        setVisible(true);
    }

    public void updateButton(int row, int col, String symbol, Color color) {
        JButton btn = buttons[row][col];
        btn.setText(symbol);
        btn.setBackground(color);
        btn.setEnabled(false);
    }

    public void updateStatus(int miss, int strike, int totalMiss, int totalHit) {
        missLabel.setText("Miss Counter: " + miss);
        strikeLabel.setText("Strike Counter: " + strike);
        totalMissLabel.setText("Total Misses: " + totalMiss);
        totalHitLabel.setText("Total Hits: " + totalHit);
    }

    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

}

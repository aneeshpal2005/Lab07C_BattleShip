# Battleship (Java Swing)

Single-player Battleship game built in Java using Swing. The game uses a 10x10 grid with randomly placed ships and a strike-based loss condition.

## Features

- 10x10 clickable game board
- Random ship placement at game start/reset
- Standard fleet sizes: 5, 4, 3, 3, 2
- Hit and miss feedback with color + symbol updates
- Ship-sunk notifications
- Win condition when all ships are sunk
- Loss condition based on strike system
- In-game counters for misses, strikes, total misses, and total hits
- `Play Again` and `Quit` controls

## Game Rules (This Implementation)

- Click a cell to fire.
- If a ship is present, the cell becomes a hit (`X`) and turns red.
- If no ship is present, the cell becomes a miss (`M`) and turns yellow.
- Consecutive misses are tracked by `Miss Counter`.
- Every 5 misses adds 1 strike and resets the miss counter.
- Any hit resets the miss counter to 0.
- Reaching 3 strikes ends the game with a loss.
- Sinking all ships ends the game with a win.

## Project Structure

```
src/
	BattleShipRunner.java   # Entry point (main)
	BattleShipGUI.java      # Swing UI and button/status updates
	BattleShipGame.java     # Game flow/controller logic
	Board.java              # Grid, ship storage, placement/reset
	Cell.java               # Per-cell state (occupied/hit/ship)
	Ship.java               # Ship state (length, hits, sunk)
	ShipPlacer.java         # Random non-overlapping ship placement
	GameStats.java          # Miss/strike/total hit/miss tracking
```

## Requirements

- Java JDK 8 or newer
- Any OS with Java installed (Windows/macOS/Linux)

## Compile and Run

From the project root:

```bash
javac src/*.java
java -cp src BattleShipRunner
```

Windows PowerShell (alternative):

```powershell
javac .\src\*.java
java -cp .\src BattleShipRunner
```

## Controls

- Click board cells to attack
- `Play Again` resets the game with new random ship placements
- `Quit` exits the application

## Notes

- Ships are randomly placed each game and do not overlap.
- Total ship cells are 17 (5 + 4 + 3 + 3 + 2).
- The UI disables a cell after it is clicked.

## Future Improvements

- Add difficulty levels and custom board sizes
- Add optional ship adjacency rules (no touching)
- Add sound effects/animations
- Add persistent high scores and game history
- Add unit tests for placement and rules

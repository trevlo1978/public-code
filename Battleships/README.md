# Battleships

### Problem Statement
- This is a command line, text-only game to simulate battleship against an easy computer opponent.
- The game is played between 2 players, who each have a 10x10 grid with columns A-J and rows 1-10
- Ships are all 1 square wide and the player gets 1 each of length 2, 3, 4, and 5.
- The user types a command to start battleship game and the computer lays out the ships for both players. Ships can only be horizontal or vertical and cannot intersect.
- The players alternate turns and pick a coordinate to fire upon during each turn.
- After the user selects a square, the computer informs them of the result. If the square has no ship, it was a miss. If the square has a ship that has not been hit, it was a hit. When the user hits all of the squares of the ship, they have sunk the ship. When they have sunk all of the opponents' ships, they win. The user should be allowed to hit the same square twice.
- The computer is an easy opponent: it needs only to make a random selection from the squares it has not selected.
- Displaying the board graphically is not required.
- The purpose of this exercise is to demonstrate program design and code readability with a program that is relatively quick to implement. A pretty user interface is not required.

### Solution

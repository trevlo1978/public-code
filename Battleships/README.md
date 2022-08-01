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
- Entry point is the main method of the Battleships class.
- 2 Gameboard are created 1 for the Human Player and 1 for the Computer Player.
- The Gameboard was choosen to be a 2D integer array as we are not required to display the board, if this became a requirement a character array could be used in its place (better ability to convey hits, water etc. to the user).
- Ships are allocated using random co-ordinates and an orientation (Bow -> vertical, Port -> horizontal), each co-ordinate is checked if it fits on the board or intersects another ship. Only then a Ship is created and the board updated. 
- The Ship class provides a HitMap which keeps track of the damage done to the ship and its sunk status.
- Each Ship is stored in a Map with the length of the Ship as the key (if Ships of the same length became a requirement we would switch to names).

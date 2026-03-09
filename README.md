Console-Based Tic-Tac-Toe in Java
A simple, interactive 2-player Tic-Tac-Toe game built in Java. It runs entirely in the terminal and automatically handles user turns, input validation, and win/draw conditions.
Features
Classic 2-Player Gameplay: Pass-and-play style between Player 'X' and Player 'O'.

Real-Time Board Display: The board updates and prints to the console after every valid move.

Input Validation: Prevents players from overwriting existing moves or entering out-of-bounds positions.

Win/Draw Detection: Automatically checks rows, columns, and diagonals for a winner, or declares a draw if all 9 spaces are filled.

Quick Exit: Enter 999 at any time to immediately end the game.
How to Play
The game uses a 0-8 numbered system to place your 'X' or 'O'. When prompted to enter a position, use the following grid mapping as your guide:
  0 | 1 | 2
 ---|---|---
  3 | 4 | 5
 ---|---|---
  6 | 7 | 8

  Low-Level Design (LLD) Overview
This project is contained within a single TicTacToe class, structured to be highly readable and efficient:

State Management: The board state is maintained using a static 3x3 2D character array (char board[][]).

display(): Iterates through the 2D array to print the current visual state of the board to the console.
checkWin(int x, int y, char c): Optimized win-checking logic. Instead of scanning the whole board, it only checks the row, column, and diagonals associated with the most recent move (x, y).

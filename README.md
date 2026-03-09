# Console-Based Tic-Tac-Toe in Java

A simple, interactive 2-player Tic-Tac-Toe game built in Java. It runs entirely in the terminal and automatically handles user turns, input validation, and win/draw conditions.
===

#  Tic-Tac-Toe Java Code Logic Explained

This document breaks down the core logic behind the console-based Tic-Tac-Toe game. The code is highly optimized, particularly in how it handles grid coordinates and win checking.

---

## 1. The 1D to 2D Grid Conversion (The Cleverest Part)
Instead of asking the user to type a row and a column separately, the game asks for a single number from `0` to `8`. It then uses math to convert that single number into a 2D grid coordinate (`x` for row, `y` for column).

* **Row Calculation (`x = p / 3`):** Dividing the position by 3 gives the row index (0, 1, or 2) because integer division drops the remainder. 
    * *Example:* If the user enters `7`, `7 / 3 = 2`. So, it goes in row 2.
* **Column Calculation (`y = p % 3`):** The modulo operator (`%`) gives the remainder, which corresponds to the column index (0, 1, or 2). 
    * *Example:* If the user enters `7`, `7 % 3 = 1`. So, it goes in column 1.

---

## 2. The Game Loops and Input Validation
The `main` method uses a two-loop system to keep the game running smoothly and prevent bad inputs.

* **The Outer Loop (`while(9 > i)`):** This loop ensures the game only runs for a maximum of 9 turns (the total number of squares on the board). The variable `i` keeps track of successful moves.
* **The Inner Loop (`while(true)`):** This loop acts as an "input trap." It will not let the player progress until they provide a valid move. 
* **Validation Logic:** The statement `if(p<0 || p>8 || board[x][y]!=' ')` checks three things:
    1. Is the number less than 0?
    2. Is the number greater than 8?
    3. Is the chosen spot already taken by an 'X' or 'O'?
    
    If any of these are true, it prompts the user to try again and repeats the inner loop. If valid, it places the piece and breaks out of the inner loop to continue the game.

---

## 3. The Optimized Win Logic (`checkWin` method)
Instead of scanning the entire board for all 8 possible winning lines every single turn, this logic is highly targeted. It passes the `x` and `y` coordinates of the *most recent move* into the method and only checks the lines connected to that specific move:

* **Row Check:** `board[x][0] == c && board[x][1] == c && board[x][2] == c` 
  *(Only checks the row where the piece was just placed).*
* **Column Check:** `board[0][y] == c && board[1][y] == c && board[2][y] == c` 
  *(Only checks the column where the piece was just placed).*
* **Main Diagonal Check (`x == y`):** A piece is only on the top-left to bottom-right diagonal if its row and column indexes are exactly the same (0,0 or 1,1 or 2,2).
* **Secondary Diagonal Check (`x + y == 2`):** A piece is only on the top-right to bottom-left diagonal if its row and column indexes add up to exactly 2 (0,2 or 1,1 or 2,0). 

---

## 4. Switching Players
At the end of a successful turn, the game uses a **Ternary Operator** to switch players efficiently: 

```java
currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
```
+++++
## How to Play

The game uses a 0-8 numbered system to place your 'X' or 'O'. When prompted to enter a position, use the following grid mapping as your guide:

```text
  0 | 1 | 2
 ---|---|---
  3 | 4 | 5
 ---|---|---
  6 | 7 | 8```


## Features

* **Classic 2-Player Gameplay:** Pass-and-play style between Player 'X' and Player 'O'.
* **Real-Time Board Display:** The board updates and prints to the console after every valid move.
* **Input Validation:** Prevents players from overwriting existing moves or entering out-of-bounds positions.
* **Win/Draw Detection:** Automatically checks rows, columns, and diagonals for a winner, or declares a draw if all 9 spaces are filled.
* **Quick Exit:** Enter `999` at any time to immediately end the game.


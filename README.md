# u5pp - Chess

## Overview

### Files

- `Chess.java` - The main game loop, various game logic, UI
- `ChessPiece.java` - Parent class of all the chess pieces
  - `King.java`
  - `Queen.java`
  - `Bishop.java`
  - `Knight.java`
  - `Rook.java`
  - `Pawn.java`
- `InputHelper.java` - add functionality for chess notation

## Chess

You will be implementing a simplified version of chess. The rules are given in the sections below.  

If you already know chess rules, our version has the following differences:

- no check/checkmate/stalemate
- no en passant
- no castling
- no pawn promotion.
- Games end when one side has no kings

The `Chess` class has multiple helper functions already made for you. Use these to implement the main game loop in `Chess.play()`.  

## General Chess Rules

*Italicized* rules are different from normal chess.
**Bold** moves are often forgotten

- Piece cannot move out of bounds
- piece cannot move onto a piece of the same color
- piece moving onto a piece of the other color is a 'take', and removes that other piece from the game
- *game is decided when one color does not have a king on board. Winner is the one with king(s) left*
- pieces cannot move through other pieces.
- white pieces are on the bottom of the board, black pieces start at the top
- White pieces are represented with capital letters, black pieces with lower case
- **rows are labeled 1 to 8**
- **columns are labeled a-h**
- White pieces start in rows 7 and 8. Black pieces start in rows 1 and 2.
- ***White pieces are denoted by uppercase letters, black by lowercase letters***

### Starting board arrangement

``` ASCII_ART
    a   b   c   d   e   f   g   h  
  ┌───┬───┬───┬───┬───┬───┬───┬───┐
1 │ r │ n │ b │ q │ k │ b │ n │ r │ 1
  ├───┼───┼───┼───┼───┼───┼───┼───┤
2 │ p │ p │ p │ p │ p │ p │ p │ p │ 2
  ├───┼───┼───┼───┼───┼───┼───┼───┤
3 │   │   │   │   │   │   │   │   │ 3
  ├───┼───┼───┼───┼───┼───┼───┼───┤
4 │   │   │   │   │   │   │   │   │ 4
  ├───┼───┼───┼───┼───┼───┼───┼───┤
5 │   │   │   │   │   │   │   │   │ 5
  ├───┼───┼───┼───┼───┼───┼───┼───┤
6 │   │   │   │   │   │   │   │   │ 6
  ├───┼───┼───┼───┼───┼───┼───┼───┤
7 │ P │ P │ P │ P │ P │ P │ P │ P │ 7
  ├───┼───┼───┼───┼───┼───┼───┼───┤
8 │ R │ N │ B │ Q │ K │ B │ N │ R │ 8
  └───┴───┴───┴───┴───┴───┴───┴───┘
    a   b   c   d   e   f   g   h  
```

## Piece Movement Rules

``` ASCII_ART
┌───┬───┬───┬───┬───┐ ┌───┬───┬───┬───┬───┐ ┌───┬───┬───┬───┬───┐ 
│   │   │   │   │   │ │   │ x │   │ x │   │ │   │   │   │   │   │
├───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┤
│   │ x │ x │ x │   │ │ x │   │   │   │ x │ │   │ * │ o │ * │   │
├───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┤
│   │ x │ K │ x │   │ │   │   │ N │   │   │ │   │   │ P │   │   │
├───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┤
│   │ x │ x │ x │   │ │ x │   │   │   │ x │ │   │   │   │   │   │
├───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┤
│   │   │   │   │   │ │   │ x │   │ x │   │ │   │   │   │   │   │
└───┴───┴───┴───┴───┘ └───┴───┴───┴───┴───┘ └───┴───┴───┴───┴───┘
┌───┬───┬───┬───┬───┐ ┌───┬───┬───┬───┬───┐ ┌───┬───┬───┬───┬───┐ 
│ x │   │ x │   │ x │ │ x │   │   │   │ x │ │   │   │ x │   │   │
├───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┤
│   │ x │ x │ x │   │ │   │ x │   │ x │   │ │   │   │ x │   │   │
├───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┤
│ x │ x │ Q │ x │ x │ │   │   │ B │   │   │ │ x │ x │ R │ x │ x │
├───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┤
│   │ x │ x │ x │   │ │   │ x │   │ x │   │ │   │   │ x │   │   │
├───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┤ ├───┼───┼───┼───┼───┤
│ x │   │ x │   │ x │ │ x │   │   │   │ x │ │   │   │ x │   │   │
└───┴───┴───┴───┴───┘ └───┴───┴───┴───┴───┘ └───┴───┴───┴───┴───┘
┌───┐
│ x │ is a valid move anytime
└───┘
┌───┐
│ * │ is a valid move only when taking
└───┘
┌───┐
│ o │ is a valid move only when not taking
└───┘
```

- King
  - represented with a `K` or a `k`
  - can only move 1 square in any of the 8 directions
  - **cannot move to a square next to another king**
- Pawn:
  - represented with a `P` or `p`
  - forward is defined as away from the side of the board where it started
  - can move straight forward, and cannot take when doing so
  - can move forward diagonally, only when taking
  - **if a pawn has never taken a move, it can move 2 squares directly forward** (cannot take with this move)
- Queen
  - represented with a `Q` or a `q`
  - can move in any of the 8 directions, any number of squares
- Rook
  - represented with a `R` or a `r`
  - can move in any of the 4 orthogonal directions (right, left, up, down) any number of squares
- Bishop
  - represented with a `B` or a `b`
  - can move in any diagonal direction any number of squares
- Knight
  - represented with a `N` or an `n` (k is taken by the king)
  - **can jump over pieces**
  - can move 2 squares in any orthogonal direction, then one square at a 90 degree angle from the first move. See below for example.

## Implementation

### `Chess.java`

In the `Chess` class, you will implement the following `public` methods:

- `void play(Scanner scanner)` - the main game loop. Example output in `ChessExample.txt`
- `int getWinner(ChessPiece[][] board)` - a `static` method that returns `1` if white has won, returns `-1` if black has won, and `0` otherwise.

### `ChessPiece.java`

You will create a `ChessPiece.java`. All the other pieces will inherit from this class.  
Any functionality that is shared between most of the types of pieces should be placed in this class.  
The class must include the following methods:

- `public ChessPiece(ChessPiece[][] board, int row, int col, boolean isWhite)` self-explanatory
- `public boolean canMoveTo(int row, int col)` which returns true if the indicated space is a valid move for this piece, false otherwise. Does not alter the board.
- `public boolean tryDoMove(int row, int col)` which tries to move the piece to the indicated space. It returns `true` if successful, and `false` if the move is not allowed.
- `public String toString()` to be implemented by each child class, based on how they are to be represented
- `public boolean getIsWhite()` self-explanatory

### Specific Chess Pieces

You will also implement all the pieces as child classes of `ChessPiece`.  
Each child class should override `canMoveTo()` and `toString()` when appropriate.  

### `InputHelper.java`

You will implement the `InputHelper` class, with the following method:

- `public int[] getChessLocation(String prompt)` - repeats the prompt until the user has inputted a correctly formatted chess location, such as 'a1' or 'h8'. Returns an `int` array of size 2, where the first element is the row (0-7) and the second element is the col (0-7)

### Recommended implementation order

1. Dummy version of every class, with nearly empty version of every method, just so that everything compiles
1. InputHelper `getChessLocation`
1. `ChessPiece.java` (until `mvn package` is success for all related tests)
1. `toString` for all the piece classes
1. `Chess.getWinner()`
1. `Chess.play()` method.
1. play a couple times, moving your kings around
1. All the other pieces

### Hints

- the `play()` method is a monster. Try method decomposition (making smaller methods) to break up the work, and to make it easier to read/write.
- Test as frequently as possible - every time you finish a segment of code that you can test, just throw in a `println()` as a quick sanity check. Managing complexity this way will save **so** much debugging time in the long run.
  
## Extra Credit - Skipped chess rules

Extra credit for each additional rule you implement, based on the complexity of the task.  
Sorted roughly from easiest to hardest.  

- castling
- en passant
- pawn promotion
- Rules that require calculating the future (check, checkmate, stalemate, & related rules)
  - (Instead of checkmate, our win condition is taking their king, which is much simpler to verify through code)
  - king may not move into check, and check must be ended during your turn
    - Calculating check can be done by precomputing all possible moves for all pieces 1 turn into the future)
    - Can also be done by keeping a "heat map" of what spaces are currently dangerous to each player. Heat map is updated every time a piece moves.
  - Game is a draw when there is a stalemate
    - Stalemate occurs when one side has no more legal moves
    - requires calculating all possible moves for a player
  - Game ends when there is a checkmate
    - Calculating checkmate requires precomputing all possible moves for all pieces, 2 turns into the future

### Grading Breakdown

- idk: 5 pts
  
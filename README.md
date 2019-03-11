# Tic Tac Toe Command Line Program
### Description
This is a command line interface program to play tic tac toe with the computer or with another user.

### Code Implementation
- main/ This folder contains the TTTDriver.java file, to start the game please run this file.
- controller/ This folder contains the controller for providing the main with functions to interact with the game objects.
- other/ This folder contains all the object definitions used by this program
- test/ This folder contains all the unit tests.

### Rules
- The rules are the same as regular 3X3 tic tac toe
- Users can input coordinates in this fashion "x y" where x represents columns, y is rows (EX: 0 0)
- Users can input a one character marker that is different from the computer player and the default value, the computer player has "#" as its marker and the default value is "0"
- Users can set time out for each turn, 100 seconds is the maximum limit. Time limit if 0 is unlimited time for each turn.
- If the user did not make a move before time out, the user loses a turn.
- You will be able to start over and play again after the round is over. 
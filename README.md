# connect4

This is a Java program for the game of Connect Four. It uses a 2D array to represent the game board, with characters 'X' and 'O' representing the players, and a space ' ' representing an empty cell on the board.

The program starts by initializing an empty game board, with 6 rows and 7 columns. The players take turns making moves by selecting a column (numbered from 1 to 7) where they want to drop their piece. The program checks if the move is valid (i.e., the selected column is not full), and then drops the player's piece to the lowest unoccupied cell in that column.

The program checks after each move if there is a winner by checking if there are four consecutive pieces of the same player in a row, column, or diagonal on the board. If a winner is found, the program displays the final board and prints a message announcing the winner. If there is no winner, the program checks if the game has ended in a draw (i.e., all cells on the board are occupied), and if so, it prints a message announcing the draw.

The program uses a loop to keep the game running until a winner or a draw is found. Within the loop, it alternates between the two players and prompts the current player to make a move.

The program also includes several helper methods to facilitate the game logic, such as a method to display the game board, a method to check if a move is valid, and methods to check for a win or a draw.

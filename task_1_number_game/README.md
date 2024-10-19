# Number Guessing Game

## Overview

A simple number guessing game implemented in Java.


## GuessingGameEngine Class

### Features

*   Generates a random target number within a specified range
*   Initializes game with minimum, maximum, and maximum attempts
*   Processes user guesses and provides feedback (too high/low)
*   Tracks attempts and score
*   Ends game when maximum attempts are reached
*   Provides game over message with target number
*   Allows user to play again


### Methods

*   `launchGame(int min, int max, int maxAttempts)`: Initializes game
*   `guessNumber(int guess)`: Processes user guess
*   `getScore()`: Returns current score
*   `randomNumberGenerator(int min, int max)`: Generates random target number
*   `gameOverMessage()`: Returns game over message 
*   `isGameOver()` | Checks if the game has ended (won or game-over)
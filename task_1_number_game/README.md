# Number Guessing Game

## Overview

A simple number guessing game implemented in Java.


## GameConfig Class


### Features

*   Represents game configuration with minimum range, maximum range, and maximum attempts
*   Validates configuration values to ensure game boundaries are non-negative and max attempts are positive
*   Provides getter methods for configuration values


### Methods

*   `GameConfig(int minRange, int maxRange, int maxAttempts)`: Constructs game configuration
*   `getMinRange()`: Returns minimum range
*   `getMaxRange()`: Returns maximum range
*   `getMaxAttempts()`: Returns maximum attempts


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


## UserInput Class


### Features

*   Handles user input for guesses and play again choices
*   Validates input to ensure integers are entered
*   Provides error messages for invalid input
*   Closes scanner to prevent resource leaks


### Methods

*   `getUserInput()`: Retrieves and validates user guess
*   `playAgain()`: Asks user if they want to play again and returns choice
*   `closeScanner()`: Closes scanner to prevent resource leaks
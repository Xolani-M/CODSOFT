package task_1_number_game.src;

import java.util.Random;

import static java.lang.String.*;

public class GuessingGameEngine {

    private int targetNumber;
    private int attempts;
    private final int maxAttempts;
    private int score;
    private final Random random = new Random();
    private final GameConfig config;
    private GameState currentState;

    public GuessingGameEngine(GameConfig config){
        validateConfig(config);
        this.config = config;
        this.maxAttempts = config.getMaxAttempts();
    }


    /**
     * Launches a new game.
     */
    public void launchGame() {
        targetNumber = randomNumberGenerator(config.getMinRange(), config.getMaxRange());
        attempts = 0;
        score = 0;
        currentState = GameState.IN_PROGRESS;
    }


    /**
     * Starts a new game and prints the game message.
     */
    public void startNewGame(){
        System.out.printf("New Game: Guess a number between %d and %d%n", config.getMinRange(), config.getMaxRange());
    }


    /**
     * Gets the minimum range.
     *
     * @return minimum range
     */
    public int getMinRange() {
        return config.getMinRange();
    }


    /**
     * Gets the maximum range.
     *
     * @return maximum range
     */
    public int getMaxRange() {
        return config.getMaxRange();
    }


    /**
     * Generates a random number between min and max.
     *
     * @param min minimum value
     * @param max maximum value
     * @return random number
     */
    private int randomNumberGenerator(int min, int max) {
        validateBoundaries(min,max);
        return random.nextInt(max - min + 1) + min;
    }


    /**
     * Validates game boundaries.
     *
     * @param min minimum value (inclusive)
     * @param max maximum value (inclusive)
     *
     * @throws IllegalArgumentException for invalid boundaries
     */
    private void validateBoundaries(int min, int max) {
        if (min < 0 || max < 0) {
            throw new IllegalArgumentException("Game boundaries must be non-negative");
        } else if (min >= max) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
    }


    /**
     * Guesses a number.
     *
     * @param guess guessed number
     * @return result message
     */
    public String guessNumber(int guess) {
        attempts++;
        if (attempts > maxAttempts) {
            currentState = GameState.GAME_OVER;
            return gameOverMessage();
        }

        if (guess < targetNumber) {
            return guess + " is too low!";
        } else if (guess > targetNumber) {
            return guess + " is too high!";
        }

        currentState = GameState.WON;
        score += (maxAttempts - attempts + 1);
        return format("Correct! You nailed it in %d attempts! Your score is %d.",
                attempts, score);
    }


    /**
     * Gets the score.
     *
     * @return score
     */
    public int getScore() {
        return score;
    }


    /**
     * Gets the game over message.
     *
     * @return game over message
     */
    private String gameOverMessage() {
        return format("Game over! You've reached the maximum attempts. The target was %d.", targetNumber);
    }


    /**
     * Validates the GameConfig object.
     *
     * @param config GameConfig object
     * @throws NullPointerException     if config is null
     *
     */
    private void validateConfig(GameConfig config) {
        if (config == null) {
            throw new NullPointerException("GameConfig cannot be null");
        }
    }

}

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
     * Prints the welcome msg
     * Starts a new game and prints the game msg.
     */
    public void startNewGame(){
        System.out.println(GameMessenger.WELCOME_MSG);
        System.out.printf(GameMessenger.NEW_GAME_MSG, config.getMinRange(), config.getMaxRange());
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
     * @param minRange minimum value
     * @param maxRange maximum value
     * @return random number
     */
    private int randomNumberGenerator(int minRange, int maxRange) {
        config.validateGameBounds(minRange,maxRange);
        return random.nextInt(minRange - maxRange + 1) + minRange;
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
            return guess + GameMessenger.GUESS_LOW_MSG;
        } else if (guess > targetNumber) {
            return guess + GameMessenger.GUESS_HIGH_MSG;
        }

        currentState = GameState.WON;
        score += (maxAttempts - attempts + 1);
        return format(GameMessenger.CORRECT_GUESS_MSG,
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

    public boolean isGameOver(){
        return currentState == GameState.WON || currentState == GameState.GAME_OVER;
    }


    /**
     * Gets the game over message.
     *
     * @return game over message
     */
    private String gameOverMessage() {
        return format(GameMessenger.GAME_OVER_MSG, targetNumber);
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
            throw new NullPointerException(GameMessnger.CONFIG_NULL_ERROR);
        }
    }

}

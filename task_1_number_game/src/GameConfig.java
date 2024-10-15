package task_1_number_game.src;

public class GameConfig {

    private final int minRange;
    private final int maxRange;
    private final int maxAttempts;

    /**
     * Constructs a new GameConfig with the given parameters.
     *
     * @param minRange    minimum range
     * @param maxRange    maximum range
     * @param maxAttempts maximum attempts
     * @throws IllegalArgumentException if invalid values are provided
     */
    public GameConfig(int minRange, int maxRange, int maxAttempts) {
        validateConfig(minRange, maxRange, maxAttempts);
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.maxAttempts = maxAttempts;
    }

    /**
     * Validates the GameConfig values.
     *
     * @param minRange    minimum range
     * @param maxRange    maximum range
     * @param maxAttempts maximum attempts
     * @throws IllegalArgumentException if invalid values are provided
     */
    private void validateConfig(int minRange, int maxRange, int maxAttempts) {
        if (minRange < 0 || maxRange < 0) {
            throw new IllegalArgumentException("Game boundaries must be non-negative");
        }
        if (minRange >= maxRange) {
            throw new IllegalArgumentException("Min range must be less than max range");
        }
        if (maxAttempts <= 0) {
            throw new IllegalArgumentException("Max attempts must be positive");
        }
    }

    /**
     * Gets the minimum range.
     *
     * @return minimum range
     */
    public int getMinRange() {
        return minRange;
    }

    /**
     * Gets the maximum range.
     *
     * @return maximum range
     */
    public int getMaxRange() {
        return maxRange;
    }

    /**
     * Gets the maximum attempts.
     *
     * @return maximum attempts
     */
    public int getMaxAttempts() {
        return maxAttempts;
    }
}
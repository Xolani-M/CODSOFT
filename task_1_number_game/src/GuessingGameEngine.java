package task_1_number_game.src;

import java.util.Random;

import static java.lang.String.*;

public class GuessingGameEngine {

    private int targetNumber;
    private int attempts;
    private int maxAttempts;
    private int score;
    private final Random random = new Random();


    public void launchGame(int min,int max, int maxAttempts){
        this.targetNumber = randomNumberGenerator(min,max);
        this.attempts = 0;
        this.maxAttempts = maxAttempts;
        System.out.printf("New Game: Guess a number between %d and %d%n", min, max);
    }


    private int randomNumberGenerator(int min, int max) {
        if (min < 0 || max < 0)
            throw new IllegalArgumentException("Game boundaries must be non-negative.");
        else if (min >= max)
            throw new IllegalArgumentException("Minimum value (%d) must be less than maximum value (%d).".formatted(min, max));

        return random.nextInt(max - min + 1) + min;
    }


    public String guessNumber(int guess){
        attempts++;
        if (attempts > maxAttempts) return gameOverMessage();

        if (guess < targetNumber) return guess + " is too low!";
        else if (guess > targetNumber) return guess + " is too high!";

        score += (maxAttempts - attempts + 1);
        return format("Correct! 🎉 You nailed it in %d attempts! Your score is %d." +
                "\nDo you want to play again? (yes/no)", attempts, score);
    }

    public int getScore(){
        return score;
    }

    private String gameOverMessage() {
        return format("Game over! You've reached the maximum attempts. " +
                "The target was %d.\nDo you want to play again? (yes/no)", targetNumber);
    }

}
